import java.util.InputMismatchException;
import java.util.Scanner;

class PCreator {
  public static void passCreator() {

    System.out.println("--------------------------------");
    System.out.println("Welcome to the password creator!");
    System.out.println("--------------------------------");

    //Asks the user how many random passwords they want generated

    boolean again1 = false;
    int total = 0;

    do{
    again1 = false;
		try{ //bulletproofing

      Scanner input = new Scanner(System.in); //declares scanner

      System.out.println("How many random passwords do you want to generate? ");
		  total = input.nextInt();

      if (total < 1){
        System.out.println("Not a valid number!");
        System.out.println("");
        again1 = true;
      }
    }
    catch(InputMismatchException e){
      again1 = true;
      System.out.println("Not a number!");
      System.out.println("");
    }
    }while(again1);

		//Asks the user how long they want their random passwords to be 8 minimum and 16 max, repeats if they do not meet requirements
    
    boolean again2 = false;
    int length = 0;

    do{
    again2 = false;
    try{ //bulletproofing

      Scanner in = new Scanner(System.in); 

      System.out.println("How long do you want your random password(s) to be? (Min:8, Max:16) ");
      length = in.nextInt();

      if (length < 8){
        again2 = true;
        System.out.println("Too short!");
        System.out.println("");
      }

      if (length > 16){
        again2 = true;
        System.out.println("Too Long!");
        System.out.println("");
      }
    }
    catch(InputMismatchException e){
      again2 = true;
      System.out.println("Not a number!");
      System.out.println("");
    }
    }while(again2);
    

		//Create an array of random passwords
		String[] randomPasswords = new String[total];

		//Randomly generate passwords total number of times
		for(int i = 0; i < total; i++) {
			//Create a variable to store the random password
			String randomPassword = "";
			//Randomly generate a character for the password length number of times
			for(int j = 0; j < length; j++) {
				//Add a random lowercase or UPPERCASE character to our randomPassword
				randomPassword += randomCharacter();
			}
			//Add the random password to your array
			randomPasswords[i] = randomPassword;
		}

		//call funtion to print out the random passwords array
		printArray(randomPasswords);

  }

	//function that prints out an array that contains all the passwords for the user
	public static void printArray(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	//function that randomly generates a letter (lowercase or uppercase) or number (0-9) using ASCII
	public static char randomCharacter() {
		//We multiply Math.random() by 127 because there are 126 characters we are trying to choose from
		//This random number has values between 0 (inclusive) and 127 (exclusive)
		int rand = (int)(Math.random()*(127-33)+33);
		
    if(rand >= 33 || rand <= 47 || rand >= 58 || rand <= 64 || rand >= 91 || rand <= 96 || rand >= 123 || rand <= 126){
      //ASCII nums for special chars
      int specialchar = rand;
      return (char)(specialchar); //casting to char
    }
		else if(rand >= 48 || rand <= 57) {
			//ASCII nums for numbers
			int number = rand + 48;
			return (char)(number); 
		} 

    else if(rand >= 65 || rand <= 90) {
			//ASCII nums for upper case letters
			int uppercase = rand + 55;
			return (char)(uppercase);
		} 

    else {
			//rest of ASCII nums for lower case letters
			int lowercase = rand + 61;
			return (char)(lowercase);
		}
	}
}