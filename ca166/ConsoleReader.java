// Basic line-buffered input from a textfile or keyboard.
//
// Author: J. M. Morris (Joseph.Morris@computing.dcu.ie). 
// Version 1.4      February 11th 2002.
//
// Example of use: To read a textfile called "foo.txt", or the keyboard,
// declare, respectively
//
//      ConsoleReader myFile = new ConsoleReader("foo.txt"); // associate file "foo.txt" with myFile
//      ConsoleReader myFile = new ConsoleReader(); // associate standard input with myFile
//
// Then execution of the statements 
//
// j=myFile.readInt(); b=myFile.readBoolean(); c=myFile.readChar(); 
// t=myFile.readToken(); s=myFile.readString();
//
// with input (where - represents a space, and ended with RETURN)
//
// ------23----TRue-X---Java123---the--rest---
//
// would leave j=23,  b=true,  c='X',  t="Java123", and
// s= "--the--rest---"
//

import java.io.*;

public class ConsoleReader {

    private BufferedReader br; // the input stream
    
    static String buffer = "";
    static int p = 1; // buffer[p..] contains next input
    
    public ConsoleReader(String f) { // f is name of file
        try { 
        	br = new BufferedReader(new FileReader(f));
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
    }
    
    public ConsoleReader() { // default: keyboard input
        br = new BufferedReader(new InputStreamReader(System.in));
    }       

    String getToken() throws IOException { // return next token from input stream
        while (buffer != null && (p>= buffer.length() || 
                Character.isWhitespace(buffer.charAt(p)))) {
            if (p>= buffer.length()) {
                buffer = br.readLine();
                p = 0;
            }
            else p++;
        }
        if (buffer == null) throw new IOException("ConsoleReader: Unexpected end of file");
        int t = p;
        p++;
        while(p < buffer.length() &&
                !(Character.isWhitespace(buffer.charAt(p))))
            p++;
        p++;
        return(buffer.substring(t,p-1));
    }

    public int readInt() {
    // Consume and return an integer. Trailing delimiter consumed.
        try {   
        	return Integer.parseInt(getToken());
        } 
        catch (Exception e) {
            System.err.println("ConsoleReader: IO Exception in readInt");
            return 0;
        }
    }   

    public boolean readBoolean() {
    // Consume and return a boolean. Trailing delimiter consumed.
    // Any string other than "true" (case ignored) is treated as false.
        try {   
        	return new Boolean(getToken()).booleanValue();
        } 
        catch (Exception e) {
            System.err.println("ConsoleReader: IO Exception in readBoolean");
            return false;
        }
    }

    public double readDouble() {
    // Consume and return a double. Trailing delimiter consumed.
        try {
        	return new Double(getToken()).doubleValue();
        } 
        catch (Exception ioe) {
            System.err.println("ConsoleReader: IO Exception in readDouble");
            return 0.0;
        }
    }

    public String readToken() {
    // Consume and return a token. Trailing delimiter consumed.
    // A token is a maximal sequence of non-whitespace characters.
    // null returned on end of file
        try {
            while (buffer != null && (p>= buffer.length() || 
                Character.isWhitespace(buffer.charAt(p)))) {
                if (p>= buffer.length()) {
                    buffer = br.readLine();
                    p = 0;
                }
                else p++;
            }
            if (buffer == null) return null;
            int t = p;
            p++;
            while(p < buffer.length() &&
                    !(Character.isWhitespace(buffer.charAt(p))))
                p++;
            p++;
            return(buffer.substring(t,p-1));
        } 
        catch (IOException ioe) {
            System.err.println("ConsoleReader: IO Exception in readToken");
            return "";
        } 
    }
    
    public char readChar() {
    //Consume and return a character (which may be an end-of-line).
        try { 
            if (buffer != null && p>buffer.length()) {
                buffer = br.readLine();
                p = 0;
            }
            if (buffer == null) 
            	throw new IOException("ConsoleReader: Unexpected end of file in readChar"); 
            if (p == buffer.length()) { // supply end-of-line
                p++; 
                return('\n'); 
            }       
            else {
                p++;
                return buffer.charAt(p-1); 
            } 
        } 
        catch (IOException ioe) {
                System.err.println("ConsoleReader: IO Exception in readChar");
                return (char)0;
        }
    }

    public char peekChar() {
    // The next available character if any (which may be an end-of-line). The
    // character is not consumed. If buffer is empty return null character.
        if (buffer == null || p>buffer.length()) return('\000'); 
        else if (p == buffer.length()) return('\n'); 
        else return buffer.charAt(p); 
    }

    public String readString() {
    // Consume and return the remainder of current line (end-of-line discarded).
    // null returned on end of file
        try {
            if (buffer!= null && p>buffer.length()) {
                buffer = br.readLine();
                p = 0;
            }   
            if (buffer == null) return null; 
            int t = p;  p = buffer.length() + 1;
            return buffer.substring(t);
       } 
       catch (IOException ioe) {
            System.err.println("ConsoleReader: IO Exception in readString");
            return "";
       } 
    }

    public int available() {
    // Number of characters available on this line (including end-of-line, 
    // which counts as one character, i.e. '\n')
        if (buffer == null) return 0;
        else return (buffer.length()+1-p);
    }
    
    public boolean hasMoreTokens() {
    // Are there more tokens on the current line?
        if (buffer == null) return false;
        int q = p; 
        while (q<buffer.length() && Character.isWhitespace(buffer.charAt(q))) q++;
        return (q<buffer.length());
    }
    
    public void skipLine() {
    // Skip any remaining input on this line.
        if (buffer != null) p = buffer.length() + 1;
    }

    public void skipWhitespace() {
    // Consumes input until a non-whitespace character is entered (which
    // is not consumed).
        try {
            while (buffer != null && (p>= buffer.length() || 
                    Character.isWhitespace(buffer.charAt(p)))) {
                if (p>= buffer.length()) {
                        buffer = br.readLine(); 
                    p = 0;
                }
                else p++;
            }
        } 
        catch (IOException ioe) {
            System.err.println("ConsoleReader: IO Exception in skipWhitespace");
        }
    }   
    
    public boolean EndOfFile() { //Does the file contain more characters
    // Not intended for use with keyboard.
        if (available()>0) return false;
        try { 
        	buffer = br.readLine(); 
        } 
        catch (IOException ioe) {
            System.err.println("ConsoleReader: IO Exception in EndOfFile");
        }
        p = 0;
        return (buffer == null);
    }
    
    public boolean endOfFile() { //Does the file contain more characters
    // Not intended for use with keyboard.
    // This version just provides alternative spelling
        if (available()>0) return false;
        try { 
        	buffer = br.readLine(); 
        } 
        catch (IOException ioe) {
            System.err.println("ConsoleReader: IO Exception in EndOfFile");
        }
        p = 0;
        return (buffer == null);
    }
    
    public void close() { // close file
        try {
        	br.close();
        } 
        catch(IOException e) { 
            e.printStackTrace();
        }
    }


    public static void main(String[] args) { // For testing only
    
        ConsoleReader tf = new ConsoleReader("foo.txt");
         /* foo.txt should contain
            This is a string on a line
            123 67
            x
            false
            3.14
            2
            3
            4
         */
         
        int j; double d; char c; boolean b; String s;
        s = tf.readString();
        System.out.println(s);
        j = tf.readInt();
        System.out.println(j);
        j = tf.readInt();
        System.out.println(j);
        c = tf.readChar();
        System.out.println(c);
        b = tf.readBoolean();
        System.out.println(b);
        d =  tf.readDouble();
        System.out.println(d);
        while(!tf.EndOfFile()) {
            j = tf.readInt();
            System.out.println(j);
        }       
    }      
}
