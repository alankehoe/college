//David O'Regan 10331017
//Alan Kehoe    10735389

#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <signal.h>

//Global Variables

#define ONE_SECOND 100000
unsigned int seed;
static int cleanup_pop_arg = 0;	    	
pthread_t threadO, threadE;		//Create two threads to print out words

//Create a static function to be called in the handler  
static void cleanup_handler(void *arg)
{
	pthread_t id = pthread_self();

	//Used to make thread print goodbye from actual thread, not main
	if(pthread_equal(id, threadO))
		printf("Goodbye from thread 1 \n");
	if(pthread_equal(id, threadE))
		printf("Goodbye from thread 2 \n");
}

// Enable a data struct of our own type for a file pointer and thread name
typedef struct 
{
	FILE * file;
	char * name;
} DataStructure;


void * handlerThread(void * in) 
{
	pthread_t id = pthread_self();		//Identify threads
	pthread_cleanup_push(cleanup_handler,NULL);	//push cleanup handler

	DataStructure * t = (DataStructure *)in;
	char * word;
	word = malloc(64);	//returns apointer to a chunk of memory

	//Create signal variables
	sigset_t set;
	int sig;
	
	//Set signal set
	sigemptyset(&set);
	sigaddset(&set, SIGUSR1);
	sigprocmask(SIG_BLOCK, &set, NULL );
	
	while(1) 
	{
		sigwait(&set, &sig);
		fscanf(t->file, "%s", word); //read word from file
		if(!feof(t->file)) 
		{
			//after reading in word, thread will sleep
			usleep(rand_r(&seed) % ONE_SECOND);  
			printf("%s: %s\n", t->name, word);
		}
		else
			free(word);	//Frees dynamic memory from malloc
		kill(getpid(), SIGUSR2); //signal main with SIGUSR2
	}
	
	//pop cleanup handler
	pthread_cleanup_pop(cleanup_pop_arg);
	
	return (void *)NULL;
}

int main(int argc, char * argv[]) 
{
	//add SIGUSR2 to set, then block all signals using pthread_sigmask
	sigset_t set;
	int sig;
	sigemptyset(&set);
	sigaddset(&set, SIGUSR2);
	pthread_sigmask(SIG_BLOCK, &set, NULL );


	//create data struct to store file pointer and name of thread
	DataStructure threadOdd, threadEven;
	threadOdd.name = "Thread 1";
	threadEven.name = "Thread 2";

	FILE * file;
	if((file = fopen(argv[1], "r")) == NULL) 
	{
		printf("Cannot open file %s\n", argv[1]);
	}
	threadOdd.file = file;
	threadEven.file = file;
	
	//Run our threads
	pthread_create(&threadO, NULL, handlerThread, (void *)&threadOdd);
	pthread_create(&threadE, NULL, handlerThread, (void *)&threadEven);

	int count = 0; //counter to track threadO and threadE

	while(!feof(file)) //While not end of file
	{
		usleep(rand_r(&seed) % ONE_SECOND); // sleep before
		count++;
		if(count%2 == 1) 
		{
			pthread_kill(threadO, SIGUSR1); //Pass SIGUSR1->threadO
		}
		else 
		{
			pthread_kill(threadE, SIGUSR1); //Pass SIGUSR2->threadE
		}
		sigwait(&set, &sig); //selects a pending signal from set
	}

	//close threads from main
	pthread_cancel(threadO);
	pthread_cancel(threadE);

	pthread_join(threadO, NULL);
	pthread_join(threadE, NULL);
	
	
	return 0;
}
