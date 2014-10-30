

import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class MainClass extends JFrame {
  JLabel label = new JLabel("Ready...", JLabel.CENTER);
  int count;
  public MainClass() {
    JButton launchButton = new JButton("Launch!");
    getContentPane().add(launchButton, "South");
    getContentPane().add(label, "Center");
    launchButton.addActionListener((ActionListener) EventHandler.create(ActionListener.class, this,
        "actionName"));
  }
  public void actionName() {
    label.setText("Launched: " + count++);
  }
  public static void main(String[] args) {
    JFrame frame = new MainClass();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(150, 150);
    frame.setVisible(true);
  }
}