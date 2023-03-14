/*
@Name = Erik Malek Merkoomyans
@Class = CSC321 Programming 3
@Purpose = Graphical User Interface Reversi Game
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
     
  private boolean[][] gameBoard;
  private JPanel boardPanel;
  

    public GUI() {
        setTitle("Reversi Board Game");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameBoard = new boolean[8][8];
        gameBoard[3][3] = true;
        gameBoard[3][4] = false;
        gameBoard[4][3] = false;
        gameBoard[4][4] = true;
      
        boardPanel = new JPanel(new GridLayout(8, 8));
        add(boardPanel, BorderLayout.CENTER);

        for (int i = 0; i < 64; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(60, 60));
            button.setFocusPainted(false);
          
            int row = i / 8;
            int col = i % 8;
            if ((row == 3 && col == 3) || (row == 4 && col == 4)) {
                button.setBackground(Color.WHITE);
                gameBoard[row][col] = true;
            } else if ((row == 3 && col == 4) || (row == 4 && col == 
                        3)) {
                button.setBackground(Color.BLACK);
                gameBoard[row][col] = true;
            } else {
                button.setBackground(Color.GREEN);
            }
            
            button.setActionCommand(Integer.toString(i));
            button.addActionListener(this);
            boardPanel.add(button);
        }
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create menu
        JMenu gameMenu = new JMenu("Menu");
        menuBar.add(gameMenu);

        // Create menu items
        JMenuItem saveItem = new JMenuItem("Save Game");
        JMenuItem endItem = new JMenuItem("End Game");
        JMenuItem resetItem = new JMenuItem("Reset Game");

        // Add menu items to menu
        gameMenu.add(saveItem);
        gameMenu.add(endItem);
        gameMenu.add(resetItem);

        // Add action listeners to menu items
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Main.this, "Game has been saved");
            }
        });

        endItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUI();
            }
        });

        setVisible(true);
    }



     public void actionPerformed(ActionEvent e) {
        int buttonIndex = Integer.parseInt(e.getActionCommand());
        int row = buttonIndex / 8;
        int col = buttonIndex % 8;

        if (gameBoard[row][col]) {
            ((JButton)e.getSource()).setBackground(Color.WHITE);
            gameBoard[row][col] = false;
        } else {
            ((JButton)e.getSource()).setBackground(Color.BLACK);
            gameBoard[row][col] = true;
        }
    }
    
    public static void main(String[] args) {
        new GUI();
    }
}
