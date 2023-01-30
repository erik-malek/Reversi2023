/*
@Name = Erik Malek Merkoomyans
@Class = CSC321 Programming 3
@Purpose = Create first layout of Reversi Board 
 */


 import java.awt.*;
 import javax.swing.*;
 
 public class GUI_two {
   private JFrame frame;
   private JButton[][] buttons;
 
   public GUI_two() {
     frame = new JFrame("Reversi GUI");
     frame.setLayout(new GridLayout(8, 8));
 
     buttons = new JButton[8][8];
     for (int row = 0; row < 8; row++) {
       for (int col = 0; col < 8; col++) {
         buttons[row][col] = new JButton(){
           @Override
           protected void paintComponent(Graphics g) {
             super.paintComponent(g);
             int diameter = Math.min(getWidth(), getHeight());
             int x = (getWidth() - diameter) / 2;
             int y = (getHeight() - diameter) / 2;
             g.fillOval(x, y, diameter, diameter);
           }
         };
         buttons[row][col].setBackground(Color.GREEN);
         
         frame.add(buttons[row][col]);
       }
     }
 
     frame.pack();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
   }
 
   public static void main(String[] args) {
     new GUI_two();
   }
 }