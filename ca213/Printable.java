interface Printable{
	void put();
}

class Point implements Printable{
	private int x;
	private int y; // coordinates
	
	Point(int x0, int y0)
	{
		x = x0;
		y = y0;
	}
	
	void get(){
		x = Console.readInt();
		y = Console.readInt();
	}
	
	public void put(){
		System.out.println(x+":"+y);
	}
}

class Time implements Printable{ 
	private int hours;
	private int mins;
	
	Time(int h, int m)
	{
		hours = h;
		mins = m;
	}

	
	public void put(){
		System.out.println(hours+":"+mins);
	} 
}

class OrderDemo {
	
	static void print(Printable [] w){
		for(int i = 0; i < w.length; i++)
			w[i].put();
	}
	
    public static void main(String[] args){
        Point[] points = {new Point(5,4), new Point(3,5), new Point(6,1), new Point(3,3)}; 
        print(points);
        Time[] times = {new Time(15,10), new Time(11,5), new Time(9,20)};
        print(times);
        Printable[] p = {new Point(5,4), new Point(3,5), new Point(6,1), new Point(3,3),new Time(15,10), new Time(11,5), new Time(9,20)};
        print(p);
    }
}

		
