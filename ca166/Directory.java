//
//
// Alan kehoe, 10735389
//
// CA166, Sample Assessed Excercise 1, Extra version.
//
// My program performs as required in the specification
//
// This is my own work. I have not recieved assistance 
// and i have cited any sources from which i have borrowed.I
// have not given a copy of my work, or part of my work to anyone.I
// am aware that copying or giving a copy may have serious consequences,
// including an outright fail for the module.
//
// This program works correctly when used with standard input it throws the following problems when you want to read from a file.
// alans-mac:ca166 Alan$ java Directory<persons.txt 
// Console: IO Exception in readInt
// Exception in thread "main" java.lang.NullPointerException
//	  at java.lang.String.compareTo(String.java:1167)
//	  at Directory$Person.Before(Directory.java:34)
//	  at Directory.sort(Directory.java:67)
//	  at Directory.access$000(Directory.java:17)
//	  at Directory$Population.getPopulation(Directory.java:53)
//	  at Directory.main(Directory.java:78)
//
// i know it is not neccesary to read from a file give the program specification,
// but if you could give me some feed back about these exceptions please it will be appreciated. 
// (the program will wright to a file with no problems at all.)
// alans-mac:ca166 Alan$ java Directory>output.txt
// bill smith 3456
// jill sixpack 7654578
// fred flintstone 8357647
// donald duck 298465475
// micky mouse 0874567878
// minnie mouse 0874567878
// albert einstien 9032831
//
//

public class Directory{
	static class Person{
		private String name,surname; //variables that make up the class Person.
		private int num;
		
		public void getPerson(){ // reads in a person variable.
			name = Console.readToken();
			surname = Console.readToken();
			num = Console.readInt();
		}
		
		public void putPerson(){ // prints a formated instance of a person variable.
			System.out.printf("%-25s%-11d",surname+", "+name,num);// formatted printing
			System.out.println("");// new line
		}
		
		public boolean Before(Person a){// compares two names and 
			if(surname.compareTo(a.surname)<0)
				return true;
			else if(surname.equals(a.surname) && name.compareTo(a.name)<0)//in the case of the surnames being the same.
				return true;
			else
				return false;
		}
	}	
	
	static class Population{
		private Person [] all = new Person [1000];// max amount of persons in popultion is 1000
		private static int i = 0;// static so we can use it in sort. 
					 //i.e any action on i in getPopulation changes the value of i
		public void getPopulation(){
			while(!Console.endOfFile()){// reads in partially filled array 
				all[i] = new Person();
				all[i].getPerson();
				i++;
			}
			sort(all,i);// sorting is done within getPopulation immediatly after being read in.
				    // this is more efficiant for the user
		}
		
		public void putPopulation(){// prints out a list of persons.
			System.out.println("");// give a space between the command line read in and the output.easier to look at
			System.out.printf("%26s","Telephone Directory");
			System.out.println("");
			for(int j = 0; j < i; j++)
				all[j].putPerson();// print all indexes of the array
		}	
	}
	
	private static void sort(Person [] ds, int n){// sorts an array of Person's
		Person tmp = new Person();// used for swap.
		for(int j = 0; j < n-1;j++){ // search's through the entire array ds.
			for(int i = 0;i < n-1;i++){
				if(!ds[i].Before(ds[i+1])){// checks an element to make sure it is not come before the next
					tmp = ds[i]; // swap the elements into correct order
					ds[i] = ds[i+1];
					ds[i+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String [] args){
		Population all = new Population();
		all.getPopulation();// reads all the telephone book entrys.
		all.putPopulation();// prints all the telephone book entrys.
	}
}

			
		
		
