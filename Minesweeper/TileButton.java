import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
public class TileButton extends JButton {
  private boolean mine;
  private boolean revealed;
  private int value;
  private int r;
  private int c;
  private String imageName;
  private boolean hasFlag;
  JLabel flag;

  public TileButton(String x){
    super(x);
    mine = false;
    revealed = false;
    hasFlag = false;
    this.setBackground(new Color(192, 192, 192));
  }
  public String getImage(){
    return imageName;
  }
  public void setImage(String imName){
    imageName = imName;
    ImageIcon icon = new ImageIcon(imName);
    Image im1 = icon.getImage();
    Image im2 = im1.getScaledInstance(MinesweeperModel.buttonDim, MinesweeperModel.buttonDim, Image.SCALE_DEFAULT);
    this.setIcon(new ImageIcon(im2));
  }
  public void setFlag(String flagName){
    imageName = flagName;
    flag = new JLabel();
    this.add(flag);
    ImageIcon icon = new ImageIcon(flagName);
    Image im1 = icon.getImage();
    Image im2 = im1.getScaledInstance(MinesweeperModel.buttonDim/2, MinesweeperModel.buttonDim/2, Image.SCALE_DEFAULT);
    flag.setIcon(new ImageIcon(im2));
    hasFlag = true;
    MinesweeperModel.mines--;
    MinesweeperModel.flagArray[r][c] = true;
  }
  public void removeFlag(){
    flag.setIcon(null);
    hasFlag = false;
    MinesweeperModel.mines++;
    MinesweeperModel.flagArray[r][c] = false;
  }
  public boolean getFlag(){
    return hasFlag;
  }
  public boolean getMine(){
    return mine;
  }
  public void setMine(){
    mine = true;
  }
  public String getValue(){
    return Integer.toString(value);
  }
  public void setValue(int x){
    value = x;
  }
  public boolean getRevealed(){
    return revealed;
  }
  public void setRevealed(){
    revealed = true;
    setIcon(null);
    if(getFlag()){
      removeFlag();
    }
    if(getMine() == true){
      setImage("Bomb.jpg");
    }
    else if(getValue().equals("0")){
      MinesweeperModel.autoReveal(r, c, MinesweeperPanel.buttonGrid);
    }
    else if(getValue().equals("1")){
      setImage("1.jpg");
    }
    else if(getValue().equals("2")){
      setImage("2.jpg");
    }
    else if(getValue().equals("3")){
      setImage("3.jpg");
    }
    else if(getValue().equals("4")){
      setImage("4.jpg");
    }
    else if(getValue().equals("5")){
      setImage("5.jpg");
    }
    else if(getValue().equals("6")){
      setImage("6.jpg");
    }
    else if(getValue().equals("7")){
      setImage("7.jpg");
    }
    else if(getValue().equals("8")){
      setImage("8.jpg");
    }
    MinesweeperModel.clearSpots--;
    MinesweeperModel.revealArray[r][c] = true;
  }
  public int getR(){
    return r;
  }
  public void setR(int r2){
    r = r2;
  }
  public int getC(){
    return c;
  }
  public void setC(int c2){
    c = c2;
  }
}
