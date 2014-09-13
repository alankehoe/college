// page 383, problem 3

#include <iostream.h>
#include <stdlib.h>
#include <iomanip.h>

typedef int Bool;

// converts 0 to 'S', 1 to 'M', etc
char whatDay (int); 

// not very good check for leap years
Bool isLeapYear (int); 

// takes the number of the month, a flag saying whether year is leap 
int numOfDaysInMonth (int,Bool); 

void printHeader (int); 

// takes the number of the month, and the first day, prints, and updates
// the first day of the next month
void printMonth (int, int&); 

// prints the specified amount of spaces
void skip (int);

// prints leading spaces in monthly calendar
void skipToDay (int);

// terminates program in case of unrecoverable errors
void disaster (); 

int main () {

  int year, firstDayInCurrentMonth;
  Bool leap;
  int currentMonth = 1; // start at Jan
  int numDays;

  cout << "What year do you want a calendar for? ";
  cin >> year;
  cout << "What day of the week does January 1 fall on?" << endl;
  cout << "(Enter 0 for Sunday, 1 for Monday, etc.) ";
  cin >> firstDayInCurrentMonth;

  leap = isLeapYear(year);
  skip(9); cout << year << endl;

  while (currentMonth <= 12) {
    numDays = numOfDaysInMonth(currentMonth,leap);
    printHeader(currentMonth);
    printMonth(numDays, firstDayInCurrentMonth);
    cout << endl << endl << endl;
    currentMonth = currentMonth + 1;
  }
  cout << endl;
  return 0;
}

void disaster () {
  cout << "Disaster! Exiting ..." << endl;
  exit (-1);
}

void skip (int i) {
  while (i > 0) {
    cout << " ";
    i = i - 1;
  }
}

char whatDay (int d) {
  if (d == 0) return('S');
  else if (d == 1) return('M');
  else if (d == 2) return('T');
  else if (d == 3) return('W');
  else if (d == 4) return('T');
  else if (d == 5) return('F');
  else if (d == 6) return('S');
  else disaster();
}

Bool isLeapYear (int y) {
  return ((y % 4) == 0); // simplified
}

void printHeader (int m) {

  if (m == 1) { skip(7); cout << "January" << endl; }
  else if (m == 2) { skip(7); cout << "February" << endl; } 
  else if (m == 3) { skip(7); cout << "March" << endl; }
  else if (m == 4) { skip(7); cout << "April" << endl; }
  else if (m == 5) { skip(7); cout << "May" << endl; }
  else if (m == 6) { skip(7); cout << "June" << endl; }
  else if (m == 7) { skip(7); cout << "July" << endl; }
  else if (m == 8) { skip(7); cout << "August" << endl; }
  else if (m == 9) { skip(7); cout << "September" << endl; }
  else if (m == 10) { skip(7); cout << "October" << endl; }
  else if (m == 11) { skip(7); cout << "November" << endl; }
  else if (m == 12) { skip(7); cout << "December" << endl; }
  else disaster();

  cout << " S  M  T  W  T  F  S" << endl;
  cout << "____________________" << endl;
}

int numOfDaysInMonth (int m, Bool leap) {
  if (m == 1) return(31);
  else if (m == 2) if (leap) return(29); else return(28);
  else if (m == 3) return(31);
  else if (m == 4) return(30);
  else if (m == 5) return(31);
  else if (m == 6) return(30);
  else if (m == 7) return(31);
  else if (m == 8) return(31);
  else if (m == 9) return(30);
  else if (m == 10) return(31);
  else if (m == 11) return(30);
  else if (m == 12) return(31);
  else disaster();
}

void skipToDay (int d) {
  skip(3*d);
}

void printMonth (int numDays, int& weekDay) {
  int day = 1;

  skipToDay(weekDay);
  while (day <= numDays) {
    cout << setw(2) << day << " ";
    if (weekDay == 6) {
      cout << endl;
      weekDay = 0;
    }
    else weekDay = weekDay + 1;
    day = day + 1;
  }
}
