class person{
		private String name,surname;
		private char sex;
		private int age;
		
		public void getPerson(){
			name = Console.readToken();
			surname = Console.readToken();
			sex = Console.readChar();
			age = Console.readInt();
		}
		
		public void putPerson(){
			String type = " ";
			if(sex == 'm')
				type = "male";
			if(sex == 'f')
				type = "female";
			System.out.println(surname+", "+ name +" aged "+ age +" and "+ type); 
		}
		
		private boolean isYoungMale(){
			if(sex == 'm' && age >= 20 && age <= 30)
				return true;
			else	
				return false;
		}
		
		private boolean isYoungFemale(){
			if(sex == 'f' && age >= 18 && age <= 28)
				return true;			
			else 
				return false;
		}
		
		public boolean IsEligible(){
			if(isYoungMale() || isYoungFemale())
				return true;
			else
				return false;
		}
	}
