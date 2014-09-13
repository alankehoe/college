
#include <iostream.h>
#include <fstream.h>

int main () {
  ifstream f1;
  char c;
  int numchars, numlines;

  f1.open("transactions.txt");

  numchars = 0;
  numlines = 0;
  f1.get(c);
  while (f1) {
    while (f1 && c != '\n') {
      numchars = numchars + 1;
      f1.get(c);
    }
    numlines = numlines + 1;
    f1.get(c);
  }
  cout << "The file has " << numlines << " lines and " 
    << numchars << " characters" << endl;
  return(0);
}

