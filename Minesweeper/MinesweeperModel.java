import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
public class MinesweeperModel{
  public static int dimension = 24;
  public static double probability = 0.12;
  public static int mines = 0;
  //public static boolean[][] grid;
  public static int buttonDim;
  public static int clearSpots;
  public static boolean number1VictoryRoyale = false;
  public static boolean[][] mineArray;
  public static boolean[][] revealArray;
  public static boolean[][] flagArray;

  public static boolean[][] createBoolGrid(){
    MinesweeperModel.revealArray = new boolean[dimension][dimension];
    MinesweeperModel.flagArray = new boolean[dimension][dimension];
    mineArray = new boolean[dimension][dimension];
    mines = (int)((dimension * dimension) * probability);

    for(int i = 0; i < mines; i++){
      int randomX = (int)(Math.random() * dimension);
      int randomY = (int)(Math.random() * dimension);
      if(mineArray[randomX][randomY] == true) {
        i--;
        continue;
      }
      else {
        mineArray[randomX][randomY] = true;
      }
    }
    clearSpots = (dimension * dimension) - mines;
    return mineArray;
  }

  /*public static boolean chanceM(){
    double chance = Math.random();
    if(chance <= probability){
      return true;
    }
    else{
      return false;
    }
  }
  */
  public static void setButtons(TileButton[][] buttonGrid){
    int counter = 0;
    for (int r = 0; r < dimension; r++){
      for (int c = 0; c < dimension; c++){
        if(buttonGrid[r][c].getMine() == true){
          continue;
        }
        if(r != 0 && r != (dimension - 1) && c != 0 && c != (dimension-1)){ //Middles Squares
          if (buttonGrid[r-1][c-1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r-1][c].getMine() == true){
            counter++;
          }
          if(buttonGrid[r-1][c+1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r][c+1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c+1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c-1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r][c-1].getMine() == true){
            counter++;
          }
        }
        else if(r == 0 && c != 0 && c != (dimension - 1)){ //Top Border
          if(buttonGrid[r][c-1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c-1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c+1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r][c+1].getMine() == true){
            counter++;
          }
        }
        else if(c == 0 && r != 0 && r != (dimension - 1)){ //Left Border
          if(buttonGrid[r-1][c].getMine() == true){
            counter++;
          }
          if(buttonGrid[r-1][c+1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r][c+1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c+1].getMine() == true){
            counter++;
          }
          if(buttonGrid[r+1][c].getMine() == true){
            counter++;
        }
      }
      else if(c == (dimension - 1) && r != 0 && r != (dimension - 1)){ //Right Border
        if(buttonGrid[r-1][c].getMine() == true){
          counter++;
        }
        if(buttonGrid[r+1][c].getMine() == true){
          counter++;
        }
        if(buttonGrid[r-1][c-1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r+1][c-1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r][c-1].getMine() == true){
          counter++;
        }
      }
      else if(r == (dimension - 1) && c != 0 && c != (dimension - 1)){ //Bottom Border
        if(buttonGrid[r][c-1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r][c+1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r-1][c-1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r-1][c].getMine() == true){
          counter++;
        }
        if(buttonGrid[r-1][c+1].getMine() == true){
          counter++;
        }
      }
      else if(c == 0 && r == 0){ //Top Left corner
        if(buttonGrid[r+1][c].getMine() == true){
          counter++;
        }
        if(buttonGrid[r+1][c+1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r][c+1].getMine() == true){
          counter++;
        }
      }
      else if(c == (dimension - 1) && r == 0){ //Top Right corner
        if(buttonGrid[r][c-1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r+1][c-1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r+1][c].getMine() == true){
          counter++;
        }
      }
      else if(c == (dimension - 1) && r == (dimension - 1)){ //Bottom Right corner
        if(buttonGrid[r-1][c].getMine() == true){
          counter++;
        }
        if(buttonGrid[r-1][c-1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r][c-1].getMine() == true){
          counter++;
        }
      }
      else if(c == 0 && r == (dimension - 1)){ //Bottom Left corner
        if(buttonGrid[r-1][c].getMine() == true){
          counter++;
        }
        if(buttonGrid[r-1][c+1].getMine() == true){
          counter++;
        }
        if(buttonGrid[r][c+1].getMine() == true){
          counter++;
        }
      }
      buttonGrid[r][c].setValue(counter);
      counter = 0;
    }
  }
}
    public static void revealAll(TileButton[][] buttonGrid) {
      for (int i = 0; i < dimension; i++){
        for( int x = 0; x < dimension; x++){
          buttonGrid[i][x].setRevealed();
        }
      }
    }
    public static void autoReveal(int r, int c, TileButton[][]buttonGrid){ //Middle Buttons
      if(r != 0 && r != (dimension - 1) && c != 0 && c != (dimension - 1)){
        if(buttonGrid[r-1][c-1].getRevealed() == false){
          buttonGrid[r-1][c-1].setRevealed();
        }
        if(buttonGrid[r-1][c].getRevealed() == false){
          buttonGrid[r-1][c].setRevealed();
        }
        if(buttonGrid[r-1][c+1].getRevealed() == false){
          buttonGrid[r-1][c+1].setRevealed();
        }
        if(buttonGrid[r][c-1].getRevealed() == false){
          buttonGrid[r][c-1].setRevealed();
        }
        if(buttonGrid[r][c+1].getRevealed() == false){
          buttonGrid[r][c+1].setRevealed();
        }
        if(buttonGrid[r+1][c-1].getRevealed() == false){
          buttonGrid[r+1][c-1].setRevealed();
        }
        if(buttonGrid[r+1][c].getRevealed() == false){
          buttonGrid[r+1][c].setRevealed();
        }
        if(buttonGrid[r+1][c+1].getRevealed() == false){
          buttonGrid[r+1][c+1].setRevealed();
        }
      }
      else if(r == 0 && c != 0 && c != (dimension - 1)){ //Top Border
        if(buttonGrid[r][c-1].getRevealed() == false){
          buttonGrid[r][c-1].setRevealed();
        }
        if(buttonGrid[r][c+1].getRevealed() == false){
          buttonGrid[r][c+1].setRevealed();
        }
        if(buttonGrid[r+1][c-1].getRevealed() == false){
          buttonGrid[r+1][c-1].setRevealed();
        }
        if(buttonGrid[r+1][c].getRevealed() == false){
          buttonGrid[r+1][c].setRevealed();
        }
        if(buttonGrid[r+1][c+1].getRevealed() == false){
          buttonGrid[r+1][c+1].setRevealed();
        }
      }
      else if(c == (dimension - 1) && r != 0 && r != (dimension - 1)){ //Right Border
        if(buttonGrid[r-1][c].getRevealed() == false){
          buttonGrid[r-1][c].setRevealed();
        }
        if(buttonGrid[r+1][c].getRevealed() == false){
          buttonGrid[r+1][c].setRevealed();
        }
        if(buttonGrid[r-1][c-1].getRevealed() == false){
          buttonGrid[r-1][c-1].setRevealed();
        }
        if(buttonGrid[r][c-1].getRevealed() == false){
          buttonGrid[r][c-1].setRevealed();
        }
        if(buttonGrid[r+1][c-1].getRevealed() == false){
          buttonGrid[r+1][c-1].setRevealed();
        }
      }
      else if(r == (dimension - 1) && c != 0 && c != (dimension - 1)){ //Bottom Border
        if(buttonGrid[r][c-1].getRevealed() == false){
          buttonGrid[r][c-1].setRevealed();
        }
        if(buttonGrid[r][c+1].getRevealed() == false){
          buttonGrid[r][c+1].setRevealed();
        }
        if(buttonGrid[r-1][c-1].getRevealed() == false){
          buttonGrid[r-1][c-1].setRevealed();
        }
        if(buttonGrid[r-1][c].getRevealed() == false){
          buttonGrid[r-1][c].setRevealed();
        }
        if(buttonGrid[r-1][c+1].getRevealed() == false){
          buttonGrid[r-1][c+1].setRevealed();
        }
      }
      else if(c == 0 && r != 0 && r != (dimension - 1)){ //Left Border
        if(buttonGrid[r-1][c].getRevealed() == false){
          buttonGrid[r-1][c].setRevealed();
        }
        if(buttonGrid[r+1][c].getRevealed() == false){
          buttonGrid[r+1][c].setRevealed();
        }
        if(buttonGrid[r-1][c+1].getRevealed() == false){
          buttonGrid[r-1][c+1].setRevealed();
        }
        if(buttonGrid[r][c+1].getRevealed() == false){
          buttonGrid[r][c+1].setRevealed();
        }
        if(buttonGrid[r+1][c+1].getRevealed() == false){
          buttonGrid[r+1][c+1].setRevealed();
        }
      }
      else if(r == 0 && c == 0){ //Top left corner
        if(buttonGrid[r][c+1].getRevealed() == false){
          buttonGrid[r][c+1].setRevealed();
        }
        if(buttonGrid[r+1][c+1].getRevealed() == false){
          buttonGrid[r+1][c+1].setRevealed();
        }
        if(buttonGrid[r+1][c].getRevealed() == false){
          buttonGrid[r+1][c].setRevealed();
        }
      }
      else if(r == 0 && c == (dimension - 1)){ //Top right corner
        if(buttonGrid[r][c-1].getRevealed() == false){
          buttonGrid[r][c-1].setRevealed();
        }
        if(buttonGrid[r+1][c-1].getRevealed() == false){
          buttonGrid[r+1][c-1].setRevealed();
        }
        if(buttonGrid[r+1][c].getRevealed() == false){
          buttonGrid[r+1][c].setRevealed();
        }
      }
      else if(r == (dimension - 1) && c == (dimension - 1)){ //Bottom right corner
        if(buttonGrid[r-1][c].getRevealed() == false){
          buttonGrid[r-1][c].setRevealed();
        }
        if(buttonGrid[r-1][c-1].getRevealed() == false){
          buttonGrid[r-1][c-1].setRevealed();
        }
        if(buttonGrid[r][c-1].getRevealed() == false){
          buttonGrid[r][c-1].setRevealed();
        }
      }
      else if(r == (dimension - 1) && c == 0){ //Bottom left corner
        if(buttonGrid[r][c+1].getRevealed() == false){
          buttonGrid[r][c+1].setRevealed();
        }
        if(buttonGrid[r-1][c+1].getRevealed() == false){
          buttonGrid[r-1][c+1].setRevealed();
        }
        if(buttonGrid[r-1][c].getRevealed() == false){
          buttonGrid[r-1][c].setRevealed();
        }
      }
    }
    public static void setDefaultIm(TileButton[][] buttonGrid){
      for(int i = 0; i < dimension; i++){
        for(int x = 0; x < dimension; x++){
          buttonGrid[i][x].setImage("Blank.jpg");
        }
      }
    }
    public static void victory(){
      ImageIcon icon = new ImageIcon(MinesweeperModel.class.getResource("#1VictoryRoyale.jpg"));
                JOptionPane.showMessageDialog(
                        null,
                        null,
                        null, JOptionPane.INFORMATION_MESSAGE,
                        icon);
      //JOptionPane.showMessageDialog(null, "#1 Victory Royale!");
    }
    public static void setSavedCells() {
      for(int i = 0; i < dimension; i++) {
        for(int x = 0; x < dimension; x++) {
          if(MinesweeperModel.revealArray[i][x] == true && MinesweeperPanel.buttonGrid[i][x].getRevealed() == false) {
            MinesweeperPanel.buttonGrid[i][x].setRevealed();
          }
          if(MinesweeperModel.flagArray[i][x] == true) {
            MinesweeperPanel.buttonGrid[i][x].setFlag("flag.jpg");
          }
        }
      }
    }
  }
