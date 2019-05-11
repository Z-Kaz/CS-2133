import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TopPanel extends JPanel{
  JLabel label;
  public TopPanel(){
    label = new JLabel();
    add(label);
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    label.setText(Integer.toString(MinesweeperModel.mines));
    repaint();
  }
}
