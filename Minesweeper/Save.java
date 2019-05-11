import java.io.Serializable;
import java.util.*;

public class Save implements Serializable {
  private int dimension;
  private double probability;
  private static int mines;
  private int buttonDim;
  private int clearSpots;
  public boolean[][] mineArray;
  public boolean[][] revealArray;
  public boolean[][] flagArray;
  public boolean number1VictoryRoyale;
  public Save(MinesweeperModel model) {
    setDimension(model.dimension);
    setProbability(model.probability);
    setMines(model.mines);
    setButtonDim(model.buttonDim);
    setClearSpots(model.clearSpots);
    mineArray = MinesweeperModel.mineArray;
    revealArray = MinesweeperModel.revealArray;
    flagArray = MinesweeperModel.flagArray;
    number1VictoryRoyale = MinesweeperModel.number1VictoryRoyale;
  }
  public int getDimension() {
    return dimension;
  }
  public void setDimension(int dimension) {
    this.dimension = dimension;
  }
  public double getProbability() {
    return probability;
  }
  public void setProbability(double probability) {
    this.probability = probability;
  }
  public int getMines() {
    return mines;
  }
  public void setMines(int mines) {
    this.mines = mines;
  }
  public int getButtonDim() {
    return buttonDim;
  }
  public void setButtonDim(int buttonDim) {
    this.buttonDim = buttonDim;
  }
  public int getClearSpots() {
    return clearSpots;
  }
  public void setClearSpots(int clearSpots) {
    this.clearSpots = clearSpots;
  }
}
