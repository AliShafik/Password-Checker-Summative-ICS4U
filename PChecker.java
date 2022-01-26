import java.util.Scanner;
public class PChecker{
 public static void passwordchecker(){
    int minLength = 8; //minimum length for password
    int maxLength = 16;// maximum Length for password
    int digit = 0;// amount of numbers in password
    int special = 0;// amount of special characters in password
    int lowCase = 0; // amount of lower cases in password 
    int uppCase = 0;//amount of upper cases in password
    
    Scanner scnr = new Scanner(System.in);
    System.out.println("Please enter your password: ");
    String password = scnr.nextLine(); // detects user input for a password string

      if (password.length() > minLength && password.length()<= maxLength) {
      for (int i = 0; i< password.length();i++) {
        char checker = password.charAt(i);
        if (Character.isUpperCase(checker)){
          uppCase++; //determines the number of upper case characters in the user input
        }
        if (Character.isLowerCase(checker)){
          lowCase++; //determines the number of lower case characters in the user input
        }
        if (Character.isDigit(checker)){
          digit++; //determines the number of integers characters in the user input
        }
        if (checker == 33 || checker == 63 ){
          special++; //determines the number of special characters in the user input
        }
      }
        if (special>=1&&lowCase>=1&&uppCase>=1&&digit>=1){
          System.out.println("The password is PERFECT");
        }// checks that all aspects of a good password is met and outputs if the password is good if not the rest of the code will run
      }
      if (password.length() < minLength){
        for (int i=0;i<password.length();i++){
          char c = password.charAt(i);// checks characters in the string
          if (Character.isLowerCase(c)){
            lowCase++;
          }
        }
        if (lowCase>0){//outputs password requirment if password only has lower case characters
          System.out.println("your password must have " + minLength + " characters and a maximum of " + maxLength + " characters");
          System.out.println("You need at least 1 uppercase character, 1 digit and 1 special character");
        }
      }
      else if (password.length()<minLength&&uppCase>1){
        for (int i=0;i<password.length();i++){
          char checker = password.charAt(i);
          if (Character.isLowerCase(checker)){
            lowCase++;
          }
          if (Character.isUpperCase(checker)){
            uppCase++;
          }
        }
        if (lowCase>0&&uppCase>0){//outputs password requirment if password only has lower & upper case characters
          System.out.println("your password must have " + minLength + " characters");
           System.out.println("You need at least 1 digit and 1 special character");
        }
      }
        if (password.length()>maxLength||password.length()>=maxLength&&uppCase>0&&lowCase>0&&digit>0){//outputs password requirment if password has most requirments but it's too long
           System.out.println("Password is too long. Limit is " + maxLength + " characters");
           System.out.println("Need at least 1 special characters");
        }
     if (password.length()>minLength&&password.length()<maxLength&&lowCase>0&&uppCase>0&&digit>0&&special==0){//outputs password requirment if password is missing a special characters
       System.out.println("You need at least 1 special character");
     }
     if (password.length()>minLength&&password.length()<maxLength&&lowCase>0&&uppCase>0&&digit==0&& special==0){//outputs password requirment if password is missing a special character and a digit
        System.out.println("You need at least 1 special character & at least 1 digit");
     }
     
  }
}