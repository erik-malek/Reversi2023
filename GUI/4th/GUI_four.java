import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI_four {
  private JButton newGameButton;
  private JButton saveButton;
  private JButton pauseButton;
  private JButton resetButton;
  private JFrame frame;
  private JButton[][] buttons;

  public GUI_four() {
    frame = new JFrame("Reversi GUI");
    frame.setLayout(new BorderLayout());
    
    newGameButton = new JButton("New Game");
    saveButton = new JButton("Save");
    pauseButton = new JButton("Pause");
    resetButton = new JButton("Reset");

    JPanel topButtons = new JPanel(new FlowLayout());
    topButtons.add(newGameButton);
    topButtons.add(saveButton);
    topButtons.add(pauseButton);
    topButtons.add(resetButton);

    frame.add(topButtons, BorderLayout.NORTH);

    JPanel board = new JPanel(new GridLayout(8, 8));
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
        buttons[row][col].setPreferredSize(new Dimension(120, 120));
        board.add(buttons[row][col]);
      }
    }
    frame.add(board, BorderLayout.CENTER);

    newGameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(frame, "New Game button clicked");
        }
    });
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(frame, "Save button clicked");
        }
    });
    pauseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(frame, "Pause button clicked");
        }
      });
    resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(frame, "Reset button clicked");
        }
    });
      

    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }

  public static void main(String[] args) {
  new GUI_four();
  }
}


























