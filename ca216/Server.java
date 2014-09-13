/* 
 Alan Kehoe - 10735389 
 David O'Regan - 10331017
 */

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    
    static final int port = 7777;
    // final so cant be altered.
    // its shouldnt be anyway.
    //the servers port no.
    
    private static ArrayList<String> names = new ArrayList<String>(); 
    // store amount of clients in session
    
    private static ArrayList<PrintWriter> producers = new ArrayList<PrintWriter>();
    // for writing the messages
    
    public static void main(String[] args) throws Exception {//wait for and initialise new threads
        ServerSocket reciever = new ServerSocket(port);//new socket
        System.out.println("The server is running.");
        try {
            while (true) {//loop forever
                new ServerThread(reciever.accept()).start(); // new thread
            }
        } finally {
            reciever.close(); // close socket
        }
    }
    
    private static class ServerThread extends Thread { // server side thread
        //static enables us to use static variables in class server
        private String name; // user name
        private Socket socket; // socket (7777)
        private BufferedReader in; // read messages
        private PrintWriter out; // print to screen
        
        public ServerThread(Socket socket) {
            this.socket = socket;
        }
        
        public synchronized void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                name = in.readLine(); // get name
                names.add(name); //add name to list
                System.out.println("Clients: "+names.size());
                
                out.println("hello "+this.name);
                producers.add(out);//add to writers
                
                for (PrintWriter producer : producers) {
                    if (producer == this.out)//i know i just entered
                        producer.print("");//empty print
                    else// say who has entered
                        producer.println(this.name+" just joined the chat room...");
                }
                
                while (true) {
                    String input = in.readLine();//read message
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter producer : producers) {// print messages to everyone
                        producer.println(this.name + " says: " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // This client is leaving clean up.
                if (name != null) {
                    names.remove(name);// remove client
                    for (PrintWriter producer : producers) {
                        if (producer == this.out)
                            producer.print("");//empty print
                        else//tell everyone who just left
                            producer.println(name+" just left the chat room...");
                    }
                    System.out.println("Clients: "+names.size());
                    //print client numbe again after someone has left
                }
                if (out != null) {
                    producers.remove(out);//take off the list
                }
                try {
                    socket.close(); // close socket
                } catch (IOException e) {
                }
            }
        }
    }
}