

//Step 1: Simple name interaction:
//question loop

//Step 2: Series of questions
//favorite pet
//Ask age
//Lucky number
//favorite quarterback? Their jersey number?
//year of their car? (2-digits)
//first name of their favorite actor
//random number b/t 1-50

//Step 3: Generating output: using the 6-7 pieces of info.
//     Goal: outputs 5 random numbers between 1 - 65, and a Magic Ball b/t 1 - 75.

//1) Magic ball = Jersey number OR lucky number (I choose) x random number. Must be <75; subtract it if >75


//2) 5 other numbers = 

* Find the 3rd letter of their favorite pet.  Convert that character value to an integer value.
* Use the two digit model year of their car and add their lucky number to it.
* Use the random number between 1 and 50, subtracting one of the generated random numbers.
* Convert the first letter of their favorite actor/actress to an integer and use that value.
* Convert the last letter of their favorate actor/actress to an integer and use that value.
* Use the value 42.
* Use the age of their favorite pet + their car model year.
* Favorite quarterback number + age of pet + lucky number.

//3) Print answers: example
Lottery numbers: 4, 17, 15, 52, 26  Magic ball: 22

//4) Replay: 
After the numbers have been printed, ask the user if they would like to answer questions to generate another set of numbers.  If so, repeat the entire process.  If not, print a thank you message and exit.  


Once the basics of this are working (happy path), go back and add error-checking for each question.  If the user does not enter a valid entry, ask the question again until a valid entry is produced.



