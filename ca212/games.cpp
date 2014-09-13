//
//  main.cpp
//  Assignment212
//
//  Created by Alan Kehoe & David O'Regan on 16/04/2012.
//  Alan Kehoe
//  David O'Regan 10331017

// Snakes & L done by David
//Connect 4 done by Alan
//Drafts(our attempt) done together.


//
// Coonect 4 & Snakes and Ladders was developed to spec, Drafts was not as we had trouble working some of the functions and in the end ran out of time.
//
//
//
//


#include <cstdlib>
#include <ctime>
#include <iostream>

using namespace std;

class Snakes
{
    char table[100];            //I use a single array for my board.
    bool player1b,player2b;     //My variables are declared.
    int player1, player2;
    int R;                  //Global Variable for rolled.

public:
    void setup();
    void setBoard();
    void display();
    void clear();               //My functions are declared.
    void change();
    bool checkWin();
    int checkSL();
    void movePlayer();
    void play();
    int roll();


};
/*----------------------------------------------------------------------*/
void Snakes::setup()
{
    player1 = -1, player2 = -1;        // My two players are Ints, by adding and taking away they move through the board.
    player1b = true, player2b = false; // I also have a second set of bools for my players
    setBoard();
}
/*---------------------------------------------------------------------*/
void Snakes::setBoard()
{
     for(int i = 0; i < 100; i++)
    {
            table[i] = '-';
            table[2] = 'L';
            table[13] = 'L';
            table[44] = 'L';
            table[70] = 'L';
            table[81] = 'L';

                                    //A for loop will print my board, print L's for the ladders and S's for the Snakes.
            table[20] = 'S';
            table[35] = 'S';
            table[53] = 'S';
            table[72] = 'S';
            table[92] = 'S';
    }
}
/*---------------------------------------------------------------------*/
void Snakes::play()
{
        //My main function, this will loop until the checkWin method is true.

         setup();   //Board/Game is setup
         display(); //The board is displayed
         while(checkWin() == false)
         {
            setBoard();
            movePlayer(); //PLayer is moved
            checkSL();    //Snakes & Ladders are checked for
            display();    //Board is re-displayed
            change();     //PLayers are changed.
         }
}
/*-----------------------------------------------------------------------*/
int Snakes::checkSL()
{
    //Ladder 1 2-22
    if(player1 == 2)
    {
        player1 = 22;
    }
    else if(player2 == 2)
    {
          player2 = 22;
    }

    //Ladder 2 13-32
    if(player1 == 13)
    {
        player1 = 32;
    }
    else if(player2 == 13)
    {
          player2 = 32;
    }

    //Ladder 3 44-51
    if(player1 == 44)
    {
        player1 = 51;
    }
    else if(player2 == 44)
    {
          player2 = 51;
    }

    //Ladder 4 70-89
    if(player1 == 70)
    {
        player1 = 89;
    }
    else if(player2 == 70)
    {
          player2 = 89;
    }

    //Ladder 5 81-99
    if(player1 == 81)
    {
        player1 = 96;
    }
    else if(player2 == 81)
    {
          player2 = 96;
    }
                                //These are my Snakes and Ladders.
                                //My origional design was to make the snakes and ladders random on each play through.
                                //After re-reading the program spec I scrapped that approach for staic values.

                                //If a player lands on a certian index of the array, the players "vaule" is changed either up or down.

        //Snake 1 20 - 3
    if(player1 == 20)
    {
        player1 = 3;
    }
    else if(player2 == 20)
    {
          player2 = 3;
    }

    //Snake 2 35 - 15
    if(player1 == 35)
    {
        player1 = 15;
    }
    else if(player2 == 35)
    {
          player2 = 15;
    }

    //Snake 3 53-48
    if(player1 == 53)
    {
        player1 = 48;
    }
    else if(player2 == 53)
    {
          player2 = 48;
    }

    //Snake 4 72-54
    if(player1 == 72)
    {
        player1 = 54;
    }
    else if(player2 == 72)
    {
          player2 = 54;
    }

    //Snake 5 92-30
    if(player1 == 92)
    {
        player1 = 30;
    }
    else if(player2 == 92)
    {
          player2 = 30;
    }
}
/*---------------------------------------------------------------------*/
bool Snakes::checkWin()
{
    //A very simple check win staement,
    //A player can only win by being on the square EXACTLY.

    if(player1 == 99)
    {
         cout << ("Player1 Wins yall!");
         return true;
    }
    else if(player2 == 99)
    {
        cout << ("PLayer2 Wins yall");
        return true;
    }
    else
        return false;
}
/*----------------------------------------------------------------------*/

/*-----------------------------------------------------------------------*/
void Snakes::movePlayer()
{
    //This function "moves" my player.
    //This is done by adding a using the roll() function and then re printing the players piece(X/O).

    char tmp;
    cout << "Press A to roll" << endl;
    cin >> tmp;
    while(tmp != 'a' && tmp != 'A')
    {
        cout << "try again";
        cin >> tmp;
    }

    roll();
    table[player1] = 'X';
    table[player2] = 'O';
}
/*-----------------------------------------------------------------------*/
void Snakes::clear()
{
    //This will clear the screen
    //Our program is unix baised i.e. clear
    system("clear");
}
/*-----------------------------------------------------------------------*/
void Snakes::display()
{
    //This function will display the board
    //This function will be recalled after each move to display a new board.

    clear();
    cout << "Snakes and ladders" << endl;
    cout << "Player 1 is the X and PLayer 2 is the O." << endl << endl;
    int x = 0;
    while(x != 100)
    {
        for(int i = 0; i < 10; i++)
        {
            std::cout << table[x] << " ";
               x++;
        }
            cout << endl;

    }

     cout << "You Rolled: " << R << endl;
}
/*-----------------------------------------------------------------------*/
int Snakes::roll()
{
    srand((unsigned)time(0));   //Ensures a random varibale each play through
    int count1, count2 = 0;     //A count variable for the 3 six's rule.
    int DiceR = rand() % 6 + 1; //Generate a random int 1-6.
     R = DiceR;

    if(player1b == true)
    {
        while(player1 != 99 && player1 < 99)
        {
                  player1 = player1 + DiceR; //Add random variable(1-6) to player 1
                  if(DiceR == 6) //If the random int is 6
                  {
                      count1++; // Increase count variable.
                  }
                  if(count1 == 3) // If cound reachs 3
                  {
                      player1 = player1 - 18; // Go back three sixs
                      cout << "Oh no! Player 1 has rolled three 6's!";
                      count1 = 0; // Reset count
                  }
                  if(player1 > 99)
                  {
                        player1 = player1 - 100;    //Ensures player 1 will always end on the last square.
                        player1 = 100 - player1;
                  }
            return player1;
        }
    }
    else
    {
        while(player2 != 99 && player2 < 99)
        {
             player2 = player2 + DiceR;
                 if(DiceR == 6)
                  {
                      count2++;
                  }
                  if(count1 == 3)
                  {
                      player2 = player2 - 18;
                      cout << "Oh no! Player 2 has rolled three 6's!";
                      count2 = 0;
                  }
                if(player2 > 99)
                  {
                        player2 = player2 - 100;
                        player2 = 100 - player2;
                  }
            return player2;
        }
    }
}
/*------------------------------------------------------------------------*/
void Snakes::change()
{
    //A very simple method to change players

    if(player1b == true)
    {
        player1b = false;
        player2b = true;
    }
    else
    {
        player2b = false;
        player1b = true;
    }

}
/*------------------------------------------------------------------------*/
int SnakesL()
{
    //My game is played.

    Snakes snake;
    snake.play();

}
/*--------------------------------------------------------------------------------------------------------------------------*/


#include <iostream>
using namespace std;using namespace std;

class Drafts{

    char table[9][9];       //The board is a 2D array
    bool player1, player2;  //The players are booleans
    int column, row;        //Varibales for Col&Row
    int destCol, destRow;   ////Varibales for destination colums and Rows.
    int scoreOne, scoreTwo;

public:
    void initialise();
    void setBoard();
    void clear();
    void display();
    void change();      //Our functions are declared.
    void jump();
    void king();
    bool checkWin();
    void play();
    void checkMove();
};
/*---------------------------------------------------------------------*/
void Drafts::checkMove()
{
    //This was the function that caused the problems, we simply could not figure it out.
    //Our idea was to pass the col & row to the function and check against the board
    //It would have definded what you could and could not do with a piece.
    //AS it is, all moves are valid.

    if(player1 == true)
    {
           if(table[row][column] != 'x')
            {
                cout << "Invalid move" << endl;
            }

        if(destRow != row +1 || destCol != column+1 || destCol != destCol-1)
        {
            cout << "Invalid move" << endl;
        }
    }
    if(player2 == true)
    {
           if(table [column][row] != 'o')
            {
                cout << "Invalid move" << endl;
            }
        if(destRow != row-1 || destCol != column+1 || destCol != destCol-1)
        {
            cout << "Invalid move" << endl;
        }
    }
};
/*---------------------------------------------------------------------*/
void Drafts::change()
{
    //A simple method to change players each turn

    if(player1 == true){
        player1 = false;
        player2 = true;
    }
    else{
        player2 = false;
        player1 = true;
    }
}
/*---------------------------------------------------------------------*/
void Drafts::jump(){

    //Our jump method
    //We take two sets of cordinates
    //One to select a piece and then one to move him.

    if(player1 == true){
        cout << "Player 1 enter a column 1-8 and a row 1-8: " << endl;
        cin >> column;
        cin >> row;
        cout << "Now enter a new column 1-8 and a new row 1-8: " << endl;
        cin >> destCol;
        cin >> destRow;
    }
    else{
        cout << "Player 2 enter a column 1-8 and a row 1-8: ";
        cin >> column;
        cin >> row;
        cout << "Now enter a new column 1-8 and a new row 1-8: " << endl;
        cin >> destCol;
        cin >> destRow;
    }

    if(player1 == true)
    {
        checkMove();
        table[row][column] = '-';
        table[destRow][destCol] = 'x';
    }
    else if(player2 == true)
    {
        checkMove();
        table[row][column] = '-';
        table[destRow][destCol] = 'o';
    }
    change();
    display();
}
/*---------------------------------------------------------------------*/
void Drafts::initialise(){
    player1 = true; player2 = false;
    scoreOne = 0; scoreTwo = 0;
    setBoard();
}
/*---------------------------------------------------------------------*/
void Drafts::setBoard()
{
    //This is our function for displaying the board.
    //It will print X's and O's in the correct location on the board using a for loop and paramters.

    char X = 'x';

        for(int i = 0; i <= 8; i++)
        {
            for(int j = 0; j <= 8; j++)
            {
                //One loop running in the other
                if(i % 2 == j % 2)  //If the mof of i = the mod of j
                        table[i][j] = '-';  //Print - i.e. parts of the board
                else
                        table[i][j] = X;    //else its going to print X's

            }
                if(i > 2 && i < 5)
                    X = '-';
                                    //Then the paramters are set to redeclare X our char and use it to print the O's and rest of the board.
                if(i > 4)
                   X = 'o';
        }

}
/*---------------------------------------------------------------------*/
void Drafts::display(){
    system("clear");// works for unix
    clear();
    cout << "*** Checkers ***" << endl;
    cout << "Player 1 is X's and Player 2 is O's" << endl << endl;
    cout << "1  2  3  4  5  6  7  8" << endl << endl;

    for(int i = 1; i<=8; i++)
    {
        for(int j = 1; j<=8; j++)
        {
            cout <<table[i][j] << "  ";
        }
        cout  << endl;
    }

    cout << endl << "Player One : "+scoreOne << endl;
    cout << "Player Two : "+scoreTwo << endl;
}
/*---------------------------------------------------------------------*/
void Drafts::clear()
{
   system("clear");
}
/*---------------------------------------------------------------------*/
void Drafts::play(){
    initialise();
    while(true){
        display();
        jump();
    }
}
/*--------------------------------------------------------------------------------------------------------------------*/
bool Drafts::checkWin(){
    for(int i = 0 ; i < 8 ; i++)
    {
        for(int j = 0 ; j < 8 ; j++)
        {
        }
    }
}

/*--------------------------------------------------------------------------------------------------------------------*/
int Checkers()
{
    Drafts draft;
    draft.play();
}
/*-------------------------------------------------------------------------------------------------------------------*/
class Connect{
    char table [10][10];// 10x10 because there was some wrap around happening in the check win method this fixed it.
    bool player1, player2,winner;
    int column;
    int row1, row2 ,row3 ,row4 , row5, row6, row7;
    bool one,two,three,four,five,six,seven;

public:
    void initialise();
    void setBoard();
    void display();
    void enter();
    void change();
    bool tableFull();
    void play();
    bool checkWin();
};

/*---------------------------------------------------------------------*/
void Connect::initialise(){// setup all the variables
    player1 = true; player2 = false; winner = false;
    row1 = 5,row2 = 5,row3 = 5,row4 = 5,row5 = 5,row6 = 5,row7 = 5;
    one = false,two = false,three = false, four = false, five = false, six = false, seven = false;
    setBoard();
}
/*---------------------------------------------------------------------*/
void Connect::setBoard(){//initialise the board 6x7 to '-'
    for(int i = 0; i < 6; i++){
        for(int j = 0; j < 7; j++){
            table[i][j] = '-';
        }
    }
}
/*---------------------------------------------------------------------*/
bool Connect::checkWin(){// check all the winning conditions
    for(int i = 0 ; i < 7 ; i++)
    {
        for(int j = 0 ; j < 6 ; j++)
        {
            if((table[i][j] == 'X') && (table[i][j+1] == 'X') && (table[i][j+2] == 'X') && (table[i][j+3] == 'X')){//horizontal
                setBoard();// initialise board
                table[i][j] = 'X'; table[i][j+1] = 'X'; table[i][j+2] = 'X'; table[i][j+3] = 'X';// show the connect 4 on its own
                return true;
            }
            if((table[i][j] == 'X') && (table[i+1][j] == 'X') && (table[i+2][j] == 'X') && (table[i+3][j] == 'X')){//verticle
                setBoard();
                table[i][j] = 'X'; table[i+1][j] = 'X'; table[i+2][j] = 'X'; table[i+3][j] = 'X';
                return true;
            }
            if((table[i][j] == 'X') && (table[i+1][j+1] == 'X') && (table[i+2][j+2] == 'X') && (table[i+3][j+3] == 'X')){//diagonal down
                setBoard();
                table[i][j] = 'X'; table[i+1][j+1] = 'X'; table[i+2][j+2] = 'X'; table[i+3][j+3] = 'X';
                return true;
            }
            if((table[i][j] == 'X') && (table[i-1][j+1] == 'X') && (table[i-2][j+2] == 'X') && (table[i-3][j+3] == 'X')){//diagonal up
                setBoard();
                table[i][j] = 'X'; table[i-1][j+1] = 'X'; table[i-2][j+2] = 'X'; table[i-3][j+3] = 'X';
                return true;
            }
            if((table[i][j] == 'O') && (table[i][j+1] == 'O') && (table[i][j+2] == 'O') && (table[i][j+3] == 'O')){//horizontal
                setBoard();
                table[i][j] = 'O'; table[i][j+1] = 'O'; table[i][j+2] = 'O'; table[i][j+3] = 'O';
                return true;
            }
            if((table[i][j] == 'O') && (table[i+1][j] == 'O') && (table[i+2][j] == 'O') && (table[i+3][j] == 'O')){//verticle
                setBoard();
                table[i][j] = 'O'; table[i+1][j] = 'O'; table[i+2][j] = 'O'; table[i+3][j] = 'O';
                return true;
            }
            if((table[i][j] == 'O') && (table[i+1][j+1] == 'O') && (table[i+2][j+2] == 'O') && (table[i+3][j+3] == 'O')){//diagonal down
                setBoard();
                table[i][j] = 'O'; table[i+1][j+1] = 'O'; table[i+2][j+2] = 'O'; table[i+3][j+3] = 'O';
                return true;
            }
            if((table[i][j] == 'O') && (table[i-1][j+1] == 'O') && (table[i-2][j+2] == 'O') && (table[i-3][j+3] == 'O')){//diagonal up
                setBoard();
                table[i][j] = 'O'; table[i-1][j+1] = 'O'; table[i-2][j+2] = 'O'; table[i-3][j+3] = 'O';
                return true;
            }
        }
    }
    return false; // return false if no winner
}
/*---------------------------------------------------------------------*/
void Connect::display(){// display the board
    system("clear");// works for unix
    cout << "***Connect  Four***" << endl;
    cout << "1  2  3  4  5  6  7" << endl;
    for(int i=0; i<6; i++){
        for(int j=0; j<7; j++){
            cout <<table[i][j] << "  ";
        }
        cout << endl;
    }
}
/*---------------------------------------------------------------------*/
void Connect::enter(){// where the player will have a chance to go
    if(player1 == true){
        cout << "Player 1 enter a column 1-7 : ";
        cin >> column;
    }
    else{
        cout << "Player 2 enter a column 1-7 : ";
        cin >> column;
    }

    while(column < 1 || column > 7){// cant enter values that arnt on the board
        cout << "Please enter column again in the range 1-7: ";
        cin >> column;
    }
    if(column == 1 && one == false){
        if(player1 == true){
            table[row1][column-1] = 'X';
            row1--;
        }
        else{
            table[row1][column-1] = 'O';
            row1--;
        }
        if(row1 < 0){
            one = true;
            //cout << "column one is full please choose another";
        }
    }
    if(column == 2 && two == false){
        if(player1 == true){
            table[row2][column-1] = 'X';
            row2--;
        }
        else{
            table[row2][column-1] = 'O';
            row2--;
        }
        if(row2 < 0){
            two = true;
            //cout << "column two is full please choose another";
        }
    }
    if(column == 3 && three == false){
        if(player1 == true){
            table[row3][column-1] = 'X';
            row3--;
        }
        else{
            table[row3][column-1] = 'O';
            row3--;
        }
        if(row3 < 0){
            three= true;
            //cout << "column three is full please choose another";
        }
    }
    if(column == 4 && four == false){
        if(player1 == true){
            table[row4][column-1] = 'X';
            row4--;
        }
        else{
            table[row4][column-1] = 'O';
            row4--;
        }
        if(row4 < 0){
            four = true;
            //cout << "column four is full please choose another";
        }
    }
    if(column == 5 && five == false){
        if(player1 == true){
            table[row5][column-1] = 'X';
            row5--;
        }
        else{
            table[row5][column-1] = 'O';
            row5--;
        }
        if(row5 < 0){
            five = true;
            //cout << "column five is full please choose another";
        }
    }
    if(column == 6 && six == false){
        if(player1 == true){
            table[row6][column-1] = 'X';
            row6--;
        }
        else{
            table[row6][column-1] = 'O';
            row6--;
        }
        if(row6 < 0){
            six = true;
            //cout << "column six is full please choose another";
        }
    }
    if(column == 7 && seven == false){
        if(player1 == true){
            table[row7][column-1] = 'X';
            row7--;
        }
        else{
            table[row7][column-1] = 'O';
            row7--;
        }
        if(row7 < 0){
            seven = true;
            //cout << "column seven is full please choose another";
        }
    }
}
/*---------------------------------------------------------------------*/
bool Connect::tableFull(){// checks to see if the top line of the board is ull if it is then the board can be said to be full
    if((table[0][0] != '-')&&(table[0][1] != '-')&&(table[0][2] != '-')&&(table[0][3] != '-')&&(table[0][4] != '-')&&(table[0][5] != '-')
       &&(table[0][6] != '-')){
        return true;
    }
    return false;
}
/*---------------------------------------------------------------------*/
void Connect::change(){// changes the players go so if was player one now is player two
    if(player1 == true){
        player1 = false;
        player2 = true;
    }
    else{
        player2 = false;
        player1 = true;
    }
}
/*---------------------------------------------------------------------*/
void Connect::play(){// the method where the game is played stays in while loop untill a winner found or table is full
    initialise();
    display();
    while(checkWin() == false){
        enter();
        change();
        display();
        if(tableFull()==true){
            cout << "Table is full this game was a draw" << endl;
            break;// jump out of the loop
        }
    }
    if(player1 == true && checkWin() == true){
        display();// display the new values
        cout << "Player two wins" << endl;
    }
    else if(player2 == true && checkWin() == true){
        display();
        cout << "Player one wins" << endl;
    }
}
/*---------------------------------------------------------------------*/
int C4(){
    Connect con;
    con.play();
}

/*---------------------------------------------------------------------*/
class Main{
    bool play;
    string gameToPlay,game;

public:
    void go();
};

/*-------------------------------------------------------------------------------------------------------------------*/
void Main::go(){
    cout << "Welcome to the Board Game Compilation!" << endl;
    cout << "Do you want to play yes/no? :" << endl;
    cin >> game;
    if (game == "yes" || game == "Yes")
        play = true;
    else if(game == "no" || game == "No"){
        play = false;
        //break;
    }
    if(play == true){
        cout << "Enter the Number of the game you wish to play :" << endl;
        cout << "1) Connect4" << endl;
        cout << "2) Snakes And Ladders" << endl;
        cout << "3) Checkers" << endl;
        cin >> gameToPlay;
        if(gameToPlay == "connect4" || gameToPlay == "Connect4" || gameToPlay == "1"){
            Connect con;
            con.play();
        }
       if(gameToPlay == "snakes and ladders" || gameToPlay == "Snakes and ladders" || gameToPlay == "2"){
            Snakes snake;
            snake.play();
        }
        if(gameToPlay == "checkers" || gameToPlay == "Checkers" || gameToPlay == "3"){
            Drafts draft;
            draft.play();
        }
    }
}

/*-------------------------------------------------------------------------------------------------------------------*/
int main(){
    Main main;
    main.go();
}




