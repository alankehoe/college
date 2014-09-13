
#include <iostream.h>

// Idea of the Russian Peasant Method (as old as 1700 B.C.)
// x * n = 2x * (n/2) if n even
//       = x + x * (n-1) if n odd

int fastmult (int x, int y) {
  int result;
  result = 0;
  while (y != 0) {
    if (y % 2 == 0) {
      x = 2*x;
      y = y/2;
    }
    else {
      result = result + x;
      y = y-1;
    }
  }
  return(result);
}

int main () {
  int x, y;
  cout << "Enter two natural numbers: ";
  cin >> x >> y;
  cout << x << " * " << y << " = " << fastmult(x,y) << endl;
  return(0);
}
