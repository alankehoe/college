//
//
// Alan kehoe, 10735389
//
// CA166, Assessed Excercise 2, Level 4
//
// My program performs as required by thr problem specification
//
// This is my own work. I have not recieved assistance beyond what is normal,
// i have cited an sources from which  have borrowed. I have not given a copy of my work,
// or part of my work, to anyone. I am aware that copying or giving a copy may have serious
// consequences, including an outright fail for the module 
//
// the way in which i use the classes Book and Transaction is very bad coding practise i have not made the 
// variables private as they should be. 
// also the way i print the transaction file with title and not isbn should be done in a more efficient way 
// the way in which i have done it if i want to add a new book i will have to manually add it to the array(time consuming)
// i have added a few of my own functions which i thought would be nice such as an option to reset stock to zero,
// also i done some extra research on how to open a default editor so that editing the transactions.txt file can be
// done from the program itself. the quit method i also added uses a time delay and then clears the screen the 
// time delay is to let the user know what he has done and doesnt get so much of a fright when the screen is cleared.
// the main program is ran in a loop so that the user can implement as many commands as they like as long as it is not "quit"
// research for the java.awt class was from the web and also for the time delay.
//
//

import java.io.*;
import java.util.*;
import java.awt.*;

public class ManageStock{
	private static class Transaction{ // to allow easier use of the transactions file.
		private String isbn;
		private int stock;
	}
	
	private static class Book{ // for storing in arraylists etc..
		private String author,title,isbn;
		private int amount;
		
		private void putBook(){ // formatted print method..
			System.out.printf("%-16s%-20s%-35s%-5d",isbn,author,title,amount);System.out.println("");
		}
	}
	
	private static void DisplayInventory(){// display inventory from books.dat.
		try{
			GregorianCalendar date = new GregorianCalendar();//get todays date.	
			int day = date.get(Calendar.DATE);
			int month = date.get(Calendar.MONTH)+1;//num of full months, so month = month plus 1.
			int year = date.get(Calendar.YEAR);
			System.out.println("______________________________Inventory "+day+"/"+month+"/"+year+"________________________________");
			RandomAccessFile f = new RandomAccessFile("books.dat","r");// read only.
			System.out.printf("%-16s%-20s%-35s%-10s","ISBN","Author","Title","In Stock");// title
			System.out.println("");
			ArrayList<Book> a = new ArrayList<Book>(); // arraylist of books
			while(f.getFilePointer() < f.length()){//end of file.
				Book book = new Book();
				book.author = f.readUTF();
				book.title = f.readUTF();
				book.isbn = f.readUTF();
				book.amount = f.readInt();
				a.add(book);
				book.putBook();
			}
			System.out.println("");
			f.close();//close f.
			System.gc();// garbage collector, clean up memory.
		}
		catch(IOException e){
			System.out.println("cant read file");
			e.printStackTrace();
		}
	}
	
	private static void DisplayTransaction(){// display transactions in good style.	
		System.out.println("__________________________________Transactions___________________________________");
		ConsoleReader f = new ConsoleReader("transactions.txt");//read from.
		System.out.printf("%-25s%10s","Title","Level");System.out.println("");// title.
		String [] a ={"0201403765","0202535665","034565976X","080539057X","0805645782","0905297568"};
		String [] b ={"Java from the Begining","Software Engineering","Program Construction",
			      "Data Structures","Java for Programmers","Chaos Theory"};
		//two arrays to hold book data, for comparison for level 3 problem.	
		while(!f.endOfFile()){// compare the two arrays. with the transaction.txt file.
			Transaction trans = new Transaction();
			trans.isbn = f.readToken();
			trans.stock = f.readInt();
			int i = 0;
			while(!trans.isbn.equals(a[i]))// when isbn from file = isbn in a then stop counting i and print equivelent title
				i++;//linear search.
			System.out.printf("%-25s%10d",b[i],trans.stock);// print "formatted" transaction's
			System.out.println("");
		}
		System.out.println("");
		f.close();// finished with f.
		System.gc();// clean up.
	}
	
	private static void stockReset(){// reset all stock to zero. optional function.
		try{
			RandomAccessFile f = new RandomAccessFile("books.dat","rw");//rewrite function.
			ArrayList<Book> a = new ArrayList<Book>();// store everything in arraylist then empty contents of array but amount = 0.
			while(f.getFilePointer() < f.length()){// end of file code
				Book book = new Book(); // have to read in all data in order to put file pointer in correct position.
				book.author = f.readUTF();
				book.title = f.readUTF();
				book.isbn = f.readUTF();
				book.amount = f.readInt()*0;// set amount to zero.
				a.add(book);
			}
			f.seek(0);//empty file.
			for(int i = 0; i < a.size(); i++){// write new data from arraylist
				f.writeUTF(a.get(i).author);
				f.writeUTF(a.get(i).title);
				f.writeUTF(a.get(i).isbn);
				f.writeInt(a.get(i).amount); //will be 0. (0 * anynumber = 0).
			}	
			f.close();// close file, im done with f.
			System.gc();// clean up.
		}
		catch(IOException e){
			System.out.println("cant read file");
			e.printStackTrace();
		}
	}
	
	private static void update(){// update books.dat from transactions.txt.
		try{
			RandomAccessFile f = new RandomAccessFile("books.dat","rw");//read & write.
			ConsoleReader c = new ConsoleReader("transactions.txt");
			ArrayList<Book> a = new ArrayList<Book>();
			ArrayList<Transaction> b = new ArrayList<Transaction>(); 
			while(f.getFilePointer() < f.length()){// read file.
				Book book = new Book();
				book.author = f.readUTF();
				book.title = f.readUTF();
				book.isbn = f.readUTF();
				book.amount = f.readInt();
				a.add(book);// add contents of file to an array.
			}
			while(!c.endOfFile()){// read file
				Transaction trans = new Transaction();
				trans.isbn = c.readToken();
				trans.stock = c.readInt();
				b.add(trans);//also add contents of file to array
			}
			for (int i = 0;i < a.size(); i++){//compare isbn's and make new value of stock level.
				for(int j = 0; j < b.size(); j++){
					if(a.get(i).isbn.equals(b.get(j).isbn)){
						a.get(i).amount = a.get(i).amount + b.get(j).stock;
					}
				}
			}
			f.seek(0);//empty file.
			for(int i = 0; i < a.size(); i++){// rewrite books.dat with new stock level.
				f.writeUTF(a.get(i).author);
				f.writeUTF(a.get(i).title);
				f.writeUTF(a.get(i).isbn);
				f.writeInt(a.get(i).amount);
			}
			f.close();
			c.close();//close f & c.
			System.gc();// clean up.
		}
		catch(IOException e){
			System.out.println("cant read file");
			e.printStackTrace();
		}
	}
	
	private static void editTransactions(){//opens transactions.txt in suitable editor and closes program.
		try {
			File file = new File("transactions.txt");
			if(!file.exists() && file.length() < 0){// check if file exists.
				System.out.println("Specified file does not exist!");
				System.exit(0);//exit program.
			}
			Desktop desktop = null;// code to open default editor. required extra research to find this class.
			if (Desktop.isDesktopSupported()){
				desktop = Desktop.getDesktop();//load applications
			}
			desktop.edit(file);//edit file
			quit();//closes the terminal program.
			System.gc();
			
		}
		catch (IOException e){
			System.out.println("No application to open \"transactions.txt\"");// error message.
			e.printStackTrace();
		}
	}
	
	private static void quit(){// exits the program and clears the screen.
		try{
			System.out.println("");
			System.out.println("Good bye thank you for using BookShop. program will close soon. ");//exit message.
			for(int i = 62;i > -1; i--){
				Thread.sleep(50);// pause 200 milliseconds.
				System.out.print("*");// acts like a progress bar.							
			}
			System.out.println("");
			String os = System.getProperty("os.name");
			if(os.charAt(0)=='W'){// clear screen code.
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//carrige returns 
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			}
			else{//only works on unix based machines, not windows..
				String ESC = "\033[";
				System.out.print(ESC + "2J"); 
			}
			System.exit(0);// ends the program.
			System.gc();// clean up
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		String name = System.getProperty("user.name");//gets account name of computer
		System.out.println("");
		System.out.println("Welcome "+name+".");// welcome message to the user.
		
		long a1 = System.nanoTime();//time in nano seconds since 1/jan/1970
		DisplayInventory();
		DisplayTransaction();
		long b1 = System.nanoTime();
		double time = (double) (b1-a1) / 1000000000.0;// from nanoSeconds to seconds.
		System.out.println("This page was loaded in "+(time)+" seconds.");// performance time.
		System.out.println("");
		System.out.println("Do you wish to update or reset stock? \"help\" for details, \"quit\" to finish");
		String anw = Console.readToken();//which method to execute next.
		if(anw.equals("quit"))//ends
			quit();
		while(!anw.equals("quit")){//in a while loop so you can execute many commands.				
			if(anw.equals("edit")){
				editTransactions();
			}
			if(anw.equals("help")){
				System.out.println("");
				System.out.printf("%-7s%-50s","edit",":edit the transaction file and close the program.");
				System.out.println("");
				System.out.printf("%-7s%-50s","quit",":ends program");
				System.out.println("");
				System.out.printf("%-7s%-50s","update",":update stock from transactions file.");
				System.out.println("");
				System.out.printf("%-7s%-50s","reset",":zero's all stock.");
				System.out.println("");System.out.println("");
				anw = Console.readToken();
			}
			if(anw.equals("update")){
				System.out.println("");
				update();
				DisplayInventory();
				System.out.println("Stock has been updated \"quit\" to exit or, implement another command."); 
				anw = Console.readToken();
			}
			if(anw.equals("reset")){
				System.out.println("");
				stockReset();
				DisplayInventory();
				System.out.println("Stock has been reset \"quit\" to exit or, implement another command.");
				anw = Console.readToken();
			}
			if(anw.equals("quit")){
				quit();
			}
		}
		System.gc();// clean up unwanted objects "orphan objects". clean's memory
	}
}
