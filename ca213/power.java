class power{
    public static void main(String [] args){
        double x,y,z,err,a,b;
        a = 0.0;
        b = 0.0;
        z = 1.0;
        x = 10.0;
        y = 1.2;
        
        while(x != 1.0 && y > 0.0){
            if(y >= 1.0){
                y = y-1.0;
                z = z*x;
            }
            else{
                a = (1.0+x)/2.0;
                System.out.println("old "+a);
                do{
                    b = a;
                    a = (a+(x/a))/2;
                    System.out.println("new "+a);
                    System.out.println("b is "+b);
                    System.out.println("");
                    
                    if(a>b){
                        err = (a-b)*.5;
                        System.out.println(err);
                    }
                    else{
                        err = (b-a)*.5;
                        System.out.println(err);
                    }
                }while(err > 0.0000001);
               x = a;
               y = 2.0*y;
            }
        }
        System.out.println("power = "+z);
    }
}