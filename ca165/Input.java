import java.util.*;

class TestScanner {
  public static void main(String args[]) {
    String input = "10:11:12";
    Scanner sc = new Scanner(input).useDelimiter(":");
    while (sc.hasNextInt()) {
          int i = sc.nextInt();
          System.out.println(i);
    }
  }
}

