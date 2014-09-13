//David O'Regan 10331017
//Alan Kehoe    10735389


#include <stdio.h>
#include <pthread.h>
#include <signal.h>
#include <time.h>
#include <unistd.h>
#include <stdlib.h>
#include <unistd.h>

//Define variables we need
#define FIVE_SECONDS 5000
#define EXIT_SUCCESS 0
#define ETIMEDOUT 110

//Global variables
unsigned int seed;
int num_elements = 0; 	//number of elements in array
int num_allocated = 10;    //number of spaces in array
int woken = 0;		//counter for wakeups

//Create our struct for wakeup calls
typedef struct
{
	int roomNum;
	time_t time;
} Node;


pthread_mutex_t lock;		//make mutex lock
Node * nodeArray = NULL;	//Make dynamic array for wakeup calls
Node n;				//Global Node(wakeup)


//Adds node at correct index in array
void addNodeAtIndex(int i, Node *nodeArray, Node n)
{
    if (num_elements == num_allocated-1)
    {
         nodeArray[num_elements] = n;			//n = num_elements
         num_allocated           = num_allocated * 2;   //Double spaces

	 //Allocated dynmaic memory
         Node *temp_nodeArray    = malloc( num_allocated * sizeof(Node));

  

	 //Run through elements 
         int i;
         for(i=0; i<num_elements; i++)
         {
                    temp_nodeArray[i] = nodeArray[i]; //Swap 
         }
         nodeArray = temp_nodeArray;

    }

    //Run through array and shift to right 
    int k;
    for (k=num_elements; k>i; k--) // shift seq[i..] to right
    {
			nodeArray[k] = nodeArray[k-1];
    }

    nodeArray[i] = n;	//Pass values of n into array
    num_elements++;	//Increment number of alarms

}

//Adds node at correct index in array
void findIndexAndAddNode(Node DATA)
{	
         int i;
	 for(i=0; i<num_elements; i++)
         {
                  if ( nodeArray[i].time > DATA.time  )
                  {
                      break;    
                  }
         }

	//Call our add method 
        addNodeAtIndex(i, nodeArray, DATA); 

	//Print our registered wakeup
	printf("\nRegistering: \t%d\t %s \n", DATA.roomNum, ctime(&DATA.time));	
}



Node removeNode()
{
   Node Min = nodeArray[0];	//Min = first element

   if (num_elements > 1)	//If at least one
   {
        int k;
        for (k=0; k < num_elements; k++) // shift seq[i..] to right
        {
		nodeArray[k] = nodeArray[k+1];
        }
 	num_elements--; 	//Decrement num of alarms left
 	woken++;		//Expired alarms increment
    }
   
   return Min;			//Return Min with values roomNum & time
}


//Function to generate random num between min and max
int get_random(int min, int max)
{
     srand((unsigned)time(0));
     return rand()%(max-min)+min;

}

void * threadg()	//Logs our calls
{
	//Infinate loop
	while(1)
	{
		//Add data, make random
		n.roomNum = get_random(1, 10000);
		n.time = time(NULL) + get_random(1,100);
	
		
		pthread_mutex_lock(&lock); //Set lock for critical section	
		
                findIndexAndAddNode(n);//addNode(n);

		pthread_mutex_unlock(&lock);//Unlock		

		sleep(get_random(1,5));
    }
}

void * threadw()	//Handles wake up calls
{
	while(1)
	{
		//Get current time
		time_t curtime;
		time(&curtime);		

		//Compare current time to time in wakeupcall
		if(curtime == nodeArray[1].time)
		{
			pthread_mutex_lock(&lock);//Set lock
                
             	        Node removed_node = removeNode();//Remove vaild wakeup

			//Print our removed wakeup call and its values
		        printf("\nWakeup:\t%d\t %s \n", removed_node.roomNum, ctime(&removed_node.time));
					
			//print our expired alarms and number of alarms left
			printf("\nExprired Alarms: %d\t\n", woken);
			printf("Pending Alarms: %d\t\n", num_elements); 	
		
			pthread_mutex_unlock(&lock);//Unlock
		}
	}
}


int main()
{
	//Allocate starting memory to array
	nodeArray = malloc( num_allocated * sizeof(Node) );
	
	//Check for mutex init
	if(pthread_mutex_init(&lock,NULL) != 0)
	{
		printf("\n mutex init failed");
		return 1;
	}

	//Set signals
	sigset_t set;
	sigfillset(&set);
	pthread_sigmask(SIG_BLOCK, &set, NULL);
	
	pthread_t threadG, threadW;

	//Create threads that use named functions and call functions
	pthread_create(&threadG, NULL, threadg, NULL);
	pthread_create(&threadW, NULL, threadw, NULL);
	
	//Use sigwait and sigint to register when program terminated
	int sig, err;
	err = sigwait (&set, &sig);
	if(err || sig == SIGINT)
	{
		pthread_cancel(threadG);	//Cancel and print
		printf("\nGuest thread cleaning up...\n");
		printf("Goodbye from guest thread\n");
		pthread_cancel(threadW);	//Cancel and print
		printf("Waiter thread is cleaning up...\n");
		printf("Goodbye from waiter thread\n");
	}

	return EXIT_SUCCESS;	
}
