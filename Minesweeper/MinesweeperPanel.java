import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
public class MinesweeperPanel extends JPanel{
  static TileButton[][] buttonGrid;
  public MinesweeperPanel(){
    MinesweeperModel.createBoolGrid();
    int dimension = MinesweeperModel.dimension;
    makeButtonGrid(dimension);
  }
  public MinesweeperPanel(Save savedGame) {
    MinesweeperModel.probability = savedGame.getProbability();
    MinesweeperModel.mines = savedGame.getMines();
    MinesweeperModel.clearSpots = savedGame.getClearSpots();
    MinesweeperModel.dimension = savedGame.getDimension();
    int dimension = MinesweeperModel.dimension;
    MinesweeperModel.mines = (int)((dimension * dimension) * MinesweeperModel.probability);
    MinesweeperModel.clearSpots = (dimension * dimension) - MinesweeperModel.mines;
    MinesweeperModel.mineArray = new boolean[dimension][dimension];
    MinesweeperModel.revealArray = new boolean[dimension][dimension];
    MinesweeperModel.flagArray = new boolean[dimension][dimension];
    MinesweeperModel.mineArray = savedGame.mineArray;
    MinesweeperModel.revealArray = savedGame.revealArray;
    MinesweeperModel.flagArray = savedGame.flagArray;
    MinesweeperModel.number1VictoryRoyale = savedGame.number1VictoryRoyale;
    makeButtonGrid(dimension);
  }
  public void makeButtonGrid(int dimension) {
    buttonGrid = new TileButton[dimension][dimension];
    setLayout(new GridLayout(dimension, dimension));
    for(int i = 0; i < dimension; i++){
      for(int x = 0; x < dimension; x++){
        TileButton button = new TileButton(null);
        button.addActionListener(new ButtonHandler());
        button.addMouseListener(new MouseHandler());
        add(button);
        buttonGrid[i][x] = button;
        button.setR(i);
        button.setC(x);
        if(MinesweeperModel.mineArray[i][x] == true){
          button.setMine();
        }
      }
    }
    MinesweeperModel.setButtons(buttonGrid);
  }
  private class ButtonHandler extends MinesweeperModel implements ActionListener{
    public void actionPerformed(ActionEvent e){
      TileButton j = (TileButton)(e.getSource());
      if(j.getFlag() || j.getRevealed() == true || MinesweeperModel.number1VictoryRoyale == true){
        ;
      }
      else if(j.getMine() == true){
        revealAll(buttonGrid);
        ImageIcon icon = new ImageIcon(MinesweeperModel.class.getResource("youDied.jpg"));
                  JOptionPane.showMessageDialog(
                          null,
                          null,
                          null, JOptionPane.INFORMATION_MESSAGE,
                          icon);
        //JOptionPane.showMessageDialog(null, "You Lose!!");
      }
      else{
        //j.setIcon(null);
        j.setRevealed();
      }
      if(MinesweeperModel.number1VictoryRoyale == true) {
        ;
      }
      else if((MinesweeperModel.mines == 0) && (MinesweeperModel.clearSpots == 0)){
        MinesweeperModel.victory();
      }
    }
  }
      private class MouseHandler extends MouseAdapter implements MouseListener {
        public void mousePressed(MouseEvent e){
          TileButton j = (TileButton)(e.getSource());
          if(e.getButton() == 1 && j.getFlag() == true || MinesweeperModel.number1VictoryRoyale == true){
            ;
          }
          else if(e.getButton() == 3 && j.getRevealed() == false && j.getFlag() == false){
            j.setFlag("flag.jpg");
            j.setImage("flag.jpg");
          }
          else if(e.getButton() == 3 && j.getFlag() == true){
            j.removeFlag();
            j.setImage("Blank.jpg");
          }
          if((MinesweeperModel.mines == 0) && (MinesweeperModel.clearSpots == 0)){
            MinesweeperModel.victory();
          }
        }
      }
    }
