// A version of ConsoleReader() specialised to the standard input
// for convenience of reading text from the keyboard.
// For example, 
//
//		j = Console.readInt(); b = Console.readBoolean();
// 
// behaves identically to
//
// 		ConsoleReader console = new ConsoleReader();
//		j = console.readInt(); b = console.readBoolean();
//
// Author: J. M. Morris (jmorris@compapp.dcu.ie). 
// Version 1.5      Februaey 11th 2002.
//
// Example of use: Execution of the statements 
//  
// j = Console.readInt(); b = Console.readBoolean(); c = Console.readChar(); 
// t = Console.readToken(); s = Console.readString();
//
// with input (where - represents a space, and ended with RETURN)
//
// ------23----TRue-X---Java123---the--rest---
//
// would leave j=23,  b=true,  c='X',  t="Java123", and
// s= "--the--rest---"
//

import java.io.*;

public class Console {

    private static BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)); // the input stream
    private static String buffer = "";
    private static int p = 1; // buffer[p..] contains next input

    private static String getToken() throws IOException { // return next token from input stream
        while (buffer != null && (p>= buffer.length() || 
                Character.isWhitespace(buffer.charAt(p)))) {
            if (p>= buffer.length()) {
                buffer = br.readLine();
                p = 0;
            }
            else p++;
        }
        if (buffer == null) throw new IOException("Console: Unexpected end of file");
        int t = p;
        p++;
        while(p < buffer.length() &&
                !(Character.isWhitespace(buffer.charAt(p))))
            p++;
        p++;
        return(buffer.substring(t,p-1));
    }

    public static int readInt() {
    // Consume and return an integer. Trailing delimiter consumed.
        try {   
        	return Integer.parseInt(getToken());
        } 
        catch (Exception e) {
            System.err.println("Console: IO Exception in readInt");
            return 0;
        }
    }   

    public static boolean readBoolean() {
    // Consume and return a boolean. Trailing delimiter consumed.
    // Any string other than "true" (case ignored) is treated as false.
        try {   
        	return new Boolean(getToken()).booleanValue();
        } 
        catch (Exception e) {
            System.err.println("Console: IO Exception in readBoolean");
            return false;
        }
    }

    public static double readDouble() {
    // Consume and return a double. Trailing delimiter consumed.
        try {
        	return new Double(getToken()).doubleValue();
        } 
        catch (Exception ioe) {
            System.err.println("Console: IO Exception in readDouble");
            return 0.0;
        }
    }

    public static String readToken() {
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
            System.err.println("Console: IO Exception in readToken");
            return "";
        } 
    }
    
    public static char readChar() {
    //Consume and return a character (which may be an end-of-line).
        try { 
            if (buffer != null && p>buffer.length()) {
                buffer = br.readLine();
                p = 0;
            }
            if (buffer == null) throw new IOException("Console: Unexpected end of file in readChar"); 
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
                System.err.println("Console: IO Exception in readChar");
                return (char)0;
        }
    }

    public static char peekChar() {
    // The next available character if any (which may be an end-of-line). The
    // character is not consumed. If buffer is empty return null character.
        if (buffer == null || p>buffer.length()) return('\000'); 
        else if (p == buffer.length()) return('\n'); 
        else return buffer.charAt(p); 
    }

    public static String readString() {
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
            System.err.println("Console: IO Exception in readString");
            return "";
       } 
    }

    public static int available() {
    // Number of characters available on this line (including end-of-line, 
    // which counts as one character, i.e. '\n')
        if (buffer == null) return 0;
        else return (buffer.length()+1-p);
    }
    
    public static boolean hasMoreTokens() {
    // Are there more tokens on the current line?
        if (buffer == null) return false;
        int q = p; 
        while (q<buffer.length() && Character.isWhitespace(buffer.charAt(q))) q++;
        return (q<buffer.length());
    }
    
    public static void skipLine() {
    // Skip any remaining input on this line.
        if (buffer != null) p = buffer.length() + 1;
    }

    public static void skipWhitespace() {
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
            System.err.println("Console: IO Exception in skipWhitespace");
        }
    }   
    
    public static boolean EndOfFile() { // More characters? 
        // This method is intended for use when keyboard is redirected to file
        if (available()>0) return false;
        try { 
        	buffer = br.readLine(); 
        } 
        catch (IOException ioe) {
            System.err.println("Console: IO Exception in EndOfFile");
        }
        p = 0;
        return (buffer == null);
    }        

    public static boolean endOfFile() { // More characters? 
    // alternative spelling for EndOfFile()
        // This method is intended for use when keyboard is redirected to file
        if (available()>0) return false;
        try { 
        	buffer = br.readLine(); 
        } 
        catch (IOException ioe) {
            System.err.println("Console: IO Exception in EndOfFile");
        }
        p = 0;
        return (buffer == null);
    }        

}
