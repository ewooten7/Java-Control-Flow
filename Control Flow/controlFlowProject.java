import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


//**Generating output**:
//Goal outcome: The output will 5 random numbers between 1 and 65, and the "magic ball" between 1 and 75. 
//How: You should have 3 random INTEGERS, generated in the SAME WAY as in the previous exercises (below, futher down).  
//Also: Can also declare constants for the max values of each set of of numbers (below):


public class controlFlowProject {
  // declare constants for the max values of each set of of numbers; Uses "FINAL".
  static final int SILVER_MAX = 70;   
  static final int GOLD_MAX = 30;

  // create arrayList to store generated numbers
  static ArrayList<Integer> silverBalls = new ArrayList<>(5);

  // set up scanner to gather information from user
  static Scanner scanner = new Scanner(System.in);

  /**
   * Method: addSilverBall
 * @param <silverBalls>

   *
   */
  public static <silverBalls> void addSilverBall(Integer silverBall) {
      // check if number is already in arrayList
      while (silverBalls.contains(silverBall)) {
          // if maximum number has been reached, start with lower number
          if (silverBall == SILVER_MAX) {
              silverBall /= 3;
          }
          // increment number until unused number has been found
          silverBall++;
      }
      // add number to arrayList
      silverBalls.add(silverBall);
  }

  /**
   * Method: addSilverBall
   * @param defaultNum 
   * @return: Returns entered (or default) number
   */
  public static int getNumInput(Integer defaultNum) {
      // creating local variables
      Integer result;
      String userInput;


      userInput = scanner.nextLine();
      if (userInput.isEmpty()) {
          // This defaultNum is used In the case that nothing is entered.
          result = defaultNum;
      } else {
          try {
              // if a number was entered, it will be stored in result
              result = Math.abs(Integer.parseInt(userInput));
          } catch (Exception e) {
              // if what was entered cannot be parsed to a number,
              // use default
              result = defaultNum;
          }
      }
      return result;
  }


  /**
   *Main Method to Start the Program:
 * @param userRandomNum 
    */
public static void main(String[] args, int userRandomNum) {
// ASCII characters called here:
      AsciiChars.printNumbers();
      AsciiChars.printLowerCase();
      AsciiChars.printUpperCase();

// Functional set up. Creating program variables
int goldBall;
int silverBall;
String petName;
int petAge;
int luckyNumber;
int jerseyNum = 7;
int carYear;
String favoriteActor;

int randomGold;
int randomNum;

String itemId = String.valueOf(silverBalls());
      
    
//Part II) The Lottery Game Questionnaire:

      // 1: Introduction - User name input
      System.out.print("Please enter your name: ");
      String userName = scanner.nextLine();

      System.out.println("Hello, " + userName);

      // 2: Permission to continue 'game'
      System.out.print("Would you like to continue to the interactive portion? y/n: ");
      String yesNo = scanner.nextLine().toLowerCase();
      if(yesNo.isEmpty()) {
          yesNo = "n";
      }

      // *2.5: If invalid input to prompt given. Note: "!=" must be used (anything that does not = input)
      if (yesNo.charAt(0) != 'y') {
          System.out.println("In this case, please return later to complete the survey. ");
          return;
      }

     
      // 3: start continuous loop to run program until user does NOT indicate yes
      while(yesNo.charAt(0) == 'y') {
          // clear arrayList at beginning of each loop
          silverBalls.clear();

          // generate new random numbers for each run
          randomGold = ThreadLocalRandom.current().nextInt(1, GOLD_MAX + 1);
          randomNum = ThreadLocalRandom.current().nextInt(1, SILVER_MAX + 1);

          // gather information from user
          System.out.print("First: What is the name of your favorite pet? ");
          petName = scanner.nextLine();
          if(petName.isEmpty()) {
              petName = "Mario";
          }

          System.out.print("What is your favorite pet's age? ");
          petAge = getNumInput(15);

          System.out.print("What is your lucky number? ");
          luckyNumber = getNumInput(30);

          System.out.print("Do you have a favorite quarterback? ");
          yesNo = scanner.nextLine().toLowerCase();
          if(yesNo.isEmpty()) {
              yesNo = "n";
          }
          if (yesNo.charAt(0) == 'y') {
              System.out.print("What is their jersey number?");
              jerseyNum = getNumInput(5);
          }

          System.out.print("What is the two-digit model year of your car? ");
          carYear = getNumInput(25) % 100;

          System.out.print("What is the first name of your favorite actor or actress? ");
          favoriteActor = scanner.nextLine();
          if (favoriteActor.isEmpty()) {
              favoriteActor = "Johnny";
          }

          System.out.print("Finally, please enter a number between 1 and 50: ");
          userRandomNum = getNumInput(7) % 50;


          // Formula to calculate numbers from inputs above:
          goldBall = (jerseyNum * randomGold) % GOLD_MAX;

          // 1st ball
          silverBall = petName.length() > 2 ? (int) petName.charAt(3) : (int) petName.charAt(0);
          silverBall %= SILVER_MAX;
          silverBalls.add(silverBall);

          // 2nd ball
          silverBall = (carYear + luckyNumber) % SILVER_MAX;
          if (silverBall < 1) {
            silverBall = luckyNumber % SILVER_MAX;
          }
          addSilverBall(silverBall);

          // 3rd ball
          silverBall = Math.abs(userRandomNum - randomNum);
          if (silverBall < 1) {
              silverBall = 2;
          }
          addSilverBall(silverBall);

          // 4th ball
          silverBall = (jerseyNum + petAge + luckyNumber) % SILVER_MAX;
          addSilverBall(silverBall);

          // 5th ball
          silverBall = (int) favoriteActor.charAt(0) % SILVER_MAX;
          addSilverBall(silverBall);

          // sort arrayList
          Collections.sort(silverBalls);

// Displays generated numbers
          System.out.printf("\nLottery Numbers: %d, %d, %d, %d, %d    Magic Ball: %d\n",
                  silverBalls.get(0),
                  silverBalls.get(1),
                  silverBalls.get(2),
                  silverBalls.get(3),
                  silverBalls.get(4),
                  goldBall);
                  

 //Play Again?
          System.out.print("\n Would you like to play again? (This will reset the game to generate new numbers.) y/n: ");

// Final step: choice to end the program
          yesNo = Scanner.nextLine().toLowerCase();
          if(yesNo.isEmpty()) {
              yesNo = "n"; 
          }
      }
  }

public static ArrayList<Integer> getSilverBalls() {
    return silverBalls;
}

public static void setSilverBalls(ArrayList<Integer> silverBalls) {
    controlFlowProject.silverBalls = silverBalls;
}

private static int silverBalls() {
    return 0;
}
}