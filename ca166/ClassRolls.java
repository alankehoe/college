public class ClassRolls{
	static class PersonName{ // The name of a person
		private String first, second; // first and second names
		
		void get(){ // Read name from keyboard 
			first = Console.readToken(); 
			second = Console.readToken();
		}

		void put(){ // Write name in form "Smith, Fred" to length 25  
			String name = second + ", " + first; 
			System.out.printf("%-25s", name);
		}
		
		boolean lt(PersonName s){ // My name precedes s.name? 
			if(second.compareTo(s.second)<0)
				return true;
			else if(second.equals(s.second) && first.compareTo(s.first)<0)
				return true;
			else 
				return false;	
		}
		
		boolean equals(PersonName s){ // My name equals s.name?
			if(first.equals(s.first) && second.equals(s.second))
				return true;
			else 
				return false;
		}
	}
	
	static class SubjectSet{ // Set of subjects
		private final int numSubjects = 3; 
		private String [] subjects = new String[numSubjects]; // The set

		void get(){ // Read set from keyboard. 
			int i;
			for (i=0; i<numSubjects; i++){ 
				subjects[i] = Console.readToken();
			}
		}
		
		boolean contains(String s){ // Is s a member of the set? 
			int i = 0;
			while (i<numSubjects && !subjects[i].equals(s)){ 
				i++;
			}
			if(i<numSubjects)
				return true;
			else 
				return false;
		}
		public static final String[] subjectTitles ={"biology", "chemistry", "computing", "maths", "physics", "stats"};
		public static final int numTitles = subjectTitles.length;
	}
	
	static class Student{ // A student
		private String studentNum; // Student number 
		private PersonName name = new PersonName(); // name private 
		SubjectSet courses = new SubjectSet(); // Subjects being studied
		void get(){// Read from keyboard. 
			studentNum = Console.readToken(); 
			name.get(); 
			courses.get();
		}
		
		void put(){// Display student name and number 
			name.put();
			System.out.println(studentNum);
		}
		
		boolean lte(Student s){// Do I precede s in phonebook order? 
			if(name.lt(s.name))
				return true;
			else if(name.equals(s.name) && studentNum.compareTo(s.studentNum) <=0)
				return true;
			else 
				return false;
		}
		
		boolean isTaking(String s){ // Am I taking subject s? 
			if(courses.contains(s))
				return true;
			else
				return false;
		}
	}
	
	static class StudentRegister{ // Register of students
		private final static int maxNumStudents = 1000; 
		private Student[] register = new Student[maxNumStudents];
		private int numStudents = 0; // number of significant items in register

		void get(){ // Read register of students, and sort 
			while (!Console.endOfFile()) {
				register[numStudents] = new Student(); 
				register[numStudents].get(); 
				numStudents++;
			} 
			sort();
		}
		void sort(){ // sort register 
			//Sort register[0..numStudents-1] 
			int lft = 0; 
			while (lft<numStudents){
				int min = lft; 
				int i = lft+1; 
				while (i<numStudents){
					if(register[i].lte(register[min])){
						min = i; 
						i++;
					}
					Student temp = register[lft];
					register[lft] = register[min];
					register[min] = temp;
					lft++;
				}
			}
		}
		
		void putHeader(String s){ // Put header for subject s 
			System.out.println(); System.out.println(); 
			System.out.println("	SUBJECT: " + s); 
			System.out.println();
		}

		void put(String s){ // Display roll for subject s 
			int total = 0; // Number of students taking this subject 
			for(int i=0; i<numStudents; i++){
				if(register[i].isTaking(s)){ 
					if(total==0){
						putHeader(s);
						register[i].put();
						total++;
					}
				}
			}
		}
	}
		
	public static void main (String[] args){
		StudentRegister register = new StudentRegister();
		register.get(); 
		for (int i=0; i<SubjectSet.numTitles; i++){
			register.put(SubjectSet.subjectTitles[i]);
		}
	}
}
