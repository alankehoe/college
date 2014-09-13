Class BoundedBuffer{
    private int size, nextIn, nextOut = 0;
    public int occupied, ins, outs;
    private boolean dataAvailable;
    private boolean roomAvailable;
    private int [] contents;
    
    public BoundedBuffer(int size0){
        size = size0;
    }

    public synchronized void change(){
        delta = nextin - nextOut - occupied;
        notifyAll();
    }

    public synchronized void insertItem(int tmp){
        while(roomAvailable == false){
            try{
                wait();
            }
            catch(InterruptedException e){}
                contents[nextin] = tmp;
                nextin++;
                nextout++;
                
    }

    public synchronized void removeItem(){
            
    }
}

class Producer extends thread{
    public BoundedBuffer buffer;
    private int random;
    
    public producer(BoundedBuffer buffer){
        
    }
    
    public void run(){
        
    }
}

class Consumer extends thread{
    public BoundedBuffer buffer;
    
    public Consumer(BoundedBuffer buffer){
        
    }
    
    public void run(){
        
    }
}

class Assignment{
    public static void main(String [] args){
        
    }
}
