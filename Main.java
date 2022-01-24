//Imports for java swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Import for scanner for user input
import java.util.Scanner;

class Main {

  //Class for layout to manage panels and frame
  public static class CLayout {
    
    //Class to retrieve main frame, main panel and card layout 
    public class infoToRetreive {
      private JPanel panelCont = new JPanel(); //main panel
      private CardLayout cl = new CardLayout(); //card layout to manage all panels
      private JFrame startFrame = new JFrame("Password Maker and Creator"); //main frame 

      //Getters for main frame, main panel and card layout
      public CardLayout getcl() {
        return cl;
      }

      public JPanel getPanelCont() {
        return panelCont;
      }

      public JFrame getStartingFrame() {
        return startFrame;
      }
    }

    public CLayout() {

      //Scanner class for user input
      Scanner input = new Scanner(System.in);

      //Retrieving info from class above to re-use
      infoToRetreive infoRetreival = new infoToRetreive();
      JPanel panelcont = infoRetreival.getPanelCont();
      CardLayout cl = infoRetreival.getcl();
      JFrame startFrame = infoRetreival.getStartingFrame();
      
      //Setting main panel to follow the card layout
      panelcont.setLayout(cl);

      // FRAME TO HOLD ALL PANELS

      //Setting attributes of main frame
      startFrame.add(infoRetreival.getPanelCont());
      startFrame.setSize(450, 350);
      startFrame.setLocation(100, 100);
      startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      startFrame.setVisible(true);

      // MAIN MENU PANEL

      //Declaring starting panel
      JPanel mainMenuPanel = new JPanel();
      mainMenuPanel.setLayout(null); //setting layout to null to allow for movement of items

      //Labels to display on starting label
      JLabel programTitle = new JLabel("Password Maker and");//declaring label
      programTitle.setFont(new Font("Verdana", Font.PLAIN, 35)); //setting font and font size of label
      programTitle.setBounds(50, 70, 400, 50); //setting the location of label
      mainMenuPanel.add(programTitle); //adding label to panel

      JLabel programTitle2 = new JLabel("Creator");
      programTitle2.setFont(new Font("Verdana", Font.PLAIN, 35));
      programTitle2.setBounds(155, 120, 400, 50);
      mainMenuPanel.add(programTitle2);

      JButton instructionsButton = new JButton("Instructions"); //declaring button
      instructionsButton.setBounds(150, 200, 150, 25);
      instructionsButton.setFocusable(false); //removing focus on button
      mainMenuPanel.add(instructionsButton);

      JButton checkerButton = new JButton("Checker"); 
      checkerButton.setBounds(50, 250, 150, 25);
      checkerButton.setFocusable(false);
      mainMenuPanel.add(checkerButton);

      JButton creatorButton = new JButton("Creator");
      creatorButton.setBounds(250, 250, 150, 25);
      creatorButton.setFocusable(false);
      mainMenuPanel.add(creatorButton);

      //Action Listener to scan button action
      instructionsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) { //checks for button click
          cl.show(infoRetreival.getPanelCont(), "2"); //shows next panel on button click
        }
      });

      // INSTRUCTIONS PANEL

      JPanel instructionsPanel = new JPanel();


      // CHECKER PANEL 

      JPanel checkerPanel = new JPanel();

      checkerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) { //checks for button click
          cl.show(infoRetreival.getPanelCont(), "3"); //shows checher panel on button click
        }
      });

      // CREATOR PANEL

      JPanel creatorPanel = new JPanel();

      creatorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) { //checks for button click
          cl.show(infoRetreival.getPanelCont(), "4"); //shows creator panel on button click
        }
      });


      // FINAL PANEL

      JPanel finalPanel = new JPanel(); //creating final panel
      finalPanel.setLayout(null); //set layout to null to allow movement of attributes

      //Labels to display on final panel
      
      JLabel restartLabel = new JLabel("Restart?"); 
      restartLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
      restartLabel.setBounds(25, 50, 400, 100);
      finalPanel.add(restartLabel);

      JButton quitButton = new JButton("Quit"); //quit button to exit program
      quitButton.setFocusable(false);
      quitButton.setBounds(250, 200, 150, 25);
      finalPanel.add(quitButton);

      JButton restartButton = new JButton("Restart"); //play again button to reset program
      restartButton.setFocusable(false);
      restartButton.setBounds(50, 200, 150, 25);
      finalPanel.add(restartButton);

      quitButton.addActionListener(new ActionListener() { //action listener to see if quit button is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
          System.exit(0); //closes program
        }
      });

      restartButton.addActionListener(new ActionListener() { //action listener to see if restart button is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
          new CLayout(); //starts a new program from the start
        }
      });

      // CONT PANEL ADJUSTMENTS

      infoRetreival.getPanelCont().add(mainMenuPanel, "1"); //adds starting panel to main panel
      infoRetreival.getPanelCont().add(instructionsPanel, "2"); //adds instructions panel to main panel
      infoRetreival.getPanelCont().add(checkerPanel, "3"); //adds checker panel to main panel
      infoRetreival.getPanelCont().add(creatorPanel, "4"); //adds creator panel to main panel
      infoRetreival.getPanelCont().add(finalPanel, "5"); //adds final panel to main panel
      cl.show(infoRetreival.getPanelCont(), "1"); //shows first panel on game start

    }
  }

  public static void main(String[] args) {
    new CLayout(); //calls entire program to start
  }
}