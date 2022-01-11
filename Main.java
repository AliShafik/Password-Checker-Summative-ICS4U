import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to password checker");
    System.out.println("We take the password you input and check it's viability");
    System.out.println("If the password is strong we will say the password is STRONG");
    Scanner scnr = new Scanner(System.in);
    System.out.println("If the password was not good we will say the password is weak & provide you with a strong password or how to make yours better");
    System.out.println("Please enter your password");
    String UI; // UI = User Input 
    UI = scnr.nextLine();
}
}