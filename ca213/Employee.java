import java.util.*;

class Employee{
	String name;
	String department;
	
	Employee(String name0, String department0){
		name = name0; department = department0;
	}
	
	public void put(){
		System.out.println(name+" "+department+" ");
	}
	
	public boolean equals(Employee b){
		if(name.equals(b.name) && department.equals(b.department))
			return true;
		else 
			return false;
	}
}

class Tradesman extends Employee{
	String trade;
	
	Tradesman(String n,String d,String t){
		super(n,d);
		trade = t;
	}	
	
	public void put(){
		super.put();
		System.out.println(trade);
	}
}

class Staff{
	private ArrayList<Employee> b = new ArrayList<Employee>();
	
	void hire(Employee e){
		b.add(e);
	}
	
	void fire(Employee e){
		b.remove(e);
	}
	
	void put(){
		for(int i = 0; i < b.size(); i++){
			b.get(i).put();
		}
	}
}

class testEmployees{
	public static void main(String[] args) {  
		Staff personnel = new Staff();
			Employee e1 = new Employee("Mike","Sales");
			Employee e2 = new Tradesman("Fred","Engineering","Welder");
			Employee e3 = new Employee("Pat","Sales");
			Employee e4 = new Tradesman("Jean","Finishing", "Painter");
			Employee e5 = new Employee("Bill","Marketing");
			Employee e6 = new Tradesman("Anne","Engineering", "Fitter");
			Employee e7 = new Tradesman("Paul","Design", "Draughtsman");
			Employee e8 = new Tradesman("Eddy","Finishing","Painter");
			Employee e9 = new Employee("John","Despatch"); 
			personnel.hire(e1); 
			personnel.hire(e2); 
			personnel.hire(e3); 
			personnel.hire(e4); 
			personnel.hire(e5); 
			personnel.hire(e6);
			personnel.hire(e7);
			personnel.hire(e8); 
			personnel.hire(e9); 
			personnel.put(); System.out.println();
			personnel.fire(e1); 
			personnel.fire(e5); 
			personnel.fire(e9);
			personnel.put(); System.out.println();
			personnel.fire(new Tradesman("Eddy", "Finishing", "Painter"));				
			personnel.put(); 
	}
}
