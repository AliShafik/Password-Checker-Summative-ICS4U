//Imports for java swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Import for scanner for user input
import java.util.Scanner;

public class Main implements ActionListener {

  private JFrame frame;
  private JPanel mainMenuPanel;
  private JPanel instructionsPanel;
  private JButton instructionsButton;

  public Main(){

    frame = new JFrame();

    instructionsButton = new JButton("Instructions");
    instructionsButton.addActionListener(this);

    mainMenuPanel = new JPanel();
    mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
    mainMenuPanel.setLayout(new GridLayout(0, 1));
    mainMenuPanel.add(instructionsButton);

    frame.add(mainMenuPanel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Password Maker and Creator");
    frame.pack();
    frame.setVisible(true);

  }

  public static void main(String[] args) {
    new Main(); 
  }

  @Override
  public void actionPerformed(ActionEvent e){

  }
}






/*char[] checker = new char[UI.length()];
   for (int i = 0; i < UI.length(); i++) {
      checker[i] = UI.charAt(i);
  }*/