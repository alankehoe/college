import java.io.*;
import java.net.*;

public class EchoServer{
    
    // Declaration section:
    static  Socket clientSocket = null;
    static  ServerSocket serverSocket = null;
    // This chat server can accept up to 1000 clients connections
    static  clientThread t[] = new clientThread[1000];           
    
    public synchronized static void main(String args[]) {
        
        // The default port
        
        int portNo=7777;
        System.out.println("Server running");

        
        // Initialization section:
        
        try {
            serverSocket = new ServerSocket(portNo);
        }
        catch (IOException e){
            System.out.println(e);
        }
        
        // Create a socket object from the ServerSocket to listen and accept 
        // connections.
        // Open input and output streams for this socket will be created in 
        // client's thread since every client is served by the server in
        // an individual thread
        
        while(true){
            try {
                clientSocket = serverSocket.accept();
                for(int i=0; i<t.length; i++){
                    if(t[i]==null)
                    {
                        (t[i] = new clientThread(clientSocket,t)).start();
                        System.out.println("Clients connected : "+(i+1));
                        break;
                    }
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }
} 

// This client thread opens the input and the output streams for a particular client,
// ask the client's name, informs all the clients currently connected to the 
// server about the fact that a new client has joined the chat room, 
// and as long as it receive data, echos that data back to all other clients.
// When the client leaves the chat room this thread informs also all the
// clients about that and terminates. 

class clientThread extends Thread{
    
    BufferedReader in = null;
    PrintStream os = null;
    Socket clientSocket = null;       
    clientThread t[]; 
    
    public clientThread(Socket clientSocket, clientThread[] t){
        this.clientSocket = clientSocket;
        this.t = t;
    }
    
    public synchronized void run() 
    {
        String line;
        String name;
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            os = new PrintStream(clientSocket.getOutputStream());
            name = in.readLine();
            os.println("Hello "+name+" press '.' on a new line to exit");//+" to our chat room.\nTo leave enter . in a new line"); 
            for(int i=0; i<t.length; i++)
                if (t[i]!=null && t[i]!=this)  
                    t[i].os.println(name+" Just joined the chat room...");
            while (true) {
                line = in.readLine();
                if(line.startsWith(".")) {
                    this.interrupt();
                    notifyAll();
                    break; 
                }
                for(int i=0; i<t.length; i++)
                    if (t[i]!=null)  
                        t[i].os.println(name+" says: "+line); 
            }
            for(int i=0; i<t.length; i++)
                if (t[i]!=null && t[i]!=this){  
                    t[i].os.println(name+": Just left the chat room." );
                }
            
            // Clean up:
            // Set to null the current thread variable such that other client could
            // be accepted by the server
            
            for(int i=0; i<t.length; i++)
                if (t[i]==this) 
                    t[i]=null;  
            
            // close stuff
            os.close();
            clientSocket.close();
        }
        catch(IOException e){
                System.out.println("Goodbye");
        }
    }
}