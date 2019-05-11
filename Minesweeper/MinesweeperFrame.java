import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
public class MinesweeperFrame extends JFrame{

  public static TopPanel c;
  MinesweeperPanel panel;

  private JMenuBar menuBar;
  private JMenu files;
  private JMenuItem newGame;
  private JMenuItem saveGame;
  private JMenuItem loadGame;
  private JMenuItem quitGame;
  private JMenuItem easyMode;
  private JMenuItem normalMode;
  private JMenuItem hardMode;
  private JFileChooser filechooser;

  public MinesweeperFrame(Save savedGame) {
    setTitle("Minesweeper");
    setSize(750, 750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);
    JMenu files = new JMenu("File");
    menuBar.add(files);
    newGame = new JMenu("New Game");
    saveGame = new JMenuItem("Save Game");
    loadGame = new JMenuItem("Load Game");
    quitGame = new JMenuItem("Quit Game");
    newGame.addActionListener(new MenuItemHandler());
    saveGame.addActionListener(new MenuItemHandler());
    loadGame.addActionListener(new MenuItemHandler());
    quitGame.addActionListener(new MenuItemHandler());
    files.add(newGame);
    files.add(saveGame);
    files.add(loadGame);
    files.add(quitGame);
    easyMode = new JMenuItem("Easy Mode");
    normalMode = new JMenuItem("Normal Mode");
    hardMode = new JMenuItem("Hard Mode");
    easyMode.addActionListener(new MenuItemHandler());
    normalMode.addActionListener(new MenuItemHandler());
    hardMode.addActionListener(new MenuItemHandler());
    newGame.add(easyMode);
    newGame.add(normalMode);
    newGame.add(hardMode);

    if(savedGame != null) {
      panel = new MinesweeperPanel(savedGame);
      add(panel, BorderLayout.CENTER);
    }
    else {
      panel = new MinesweeperPanel();
      add(panel, BorderLayout.CENTER);
    }
    c = new TopPanel();
    add(c, BorderLayout.NORTH);
    setVisible(true);
    setResizable(false);
    MinesweeperModel.buttonDim = MinesweeperPanel.buttonGrid[0][0].getWidth();
    MinesweeperModel.setDefaultIm(MinesweeperPanel.buttonGrid);

    if(savedGame != null) {
      MinesweeperModel.setSavedCells();
    }
  }
  private class MenuItemHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == easyMode) {
        dispose();
        MinesweeperModel.probability = 0.045;
        MinesweeperModel.number1VictoryRoyale = false;
        new MinesweeperFrame(null);
      }
      else if(e.getSource() == normalMode) {
        dispose();
        MinesweeperModel.probability = 0.12;
        MinesweeperModel.number1VictoryRoyale = false;
        new MinesweeperFrame(null);
      }
      else if(e.getSource() == hardMode) {
        dispose();
        MinesweeperModel.probability = 0.20;
        MinesweeperModel.number1VictoryRoyale = false;
        new MinesweeperFrame(null);
      }
      else if(e.getSource() == saveGame) {
        filechooser = new JFileChooser();
        int respond = filechooser.showSaveDialog(null);
        if(respond == JFileChooser.APPROVE_OPTION) {
          try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filechooser.getSelectedFile()));
            MinesweeperModel model = new MinesweeperModel();
            Save savedGame = new Save(model);
            out.writeObject(savedGame);
            out.flush();
            out.close();
          }
          catch(IOException ex) {
            ex.printStackTrace();
          }
        }
        else {
        }
      }
      else if(e.getSource() == loadGame) {
        filechooser = new JFileChooser();
        int respond = filechooser.showOpenDialog(null);
        if(respond == JFileChooser.APPROVE_OPTION){
          try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filechooser.getSelectedFile()));
            Save savedGame = ((Save)in.readObject());
            dispose();
            new MinesweeperFrame(savedGame);
          }
          catch(IOException ex) {
            System.out.println("ERROR: save file could not be read.");
          }
          catch(ClassNotFoundException ex) {
            System.out.println("ERROR: chosen file is not a valid save file.");
          }
        }
        else{
        }
      }
      else if(e.getSource() == quitGame) {
        System.exit(0);
      }
    }
  }
}
/*  public MinesweeperFrame(){
    setTitle("Minesweeper");
    setSize(750,750);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MinesweeperPanel panel = new MinesweeperPanel();
    add(panel, BorderLayout.CENTER);
    c = new TopPanel();
    add(c, BorderLayout.NORTH);
    setVisible(true);
    MinesweeperModel.buttonDim = MinesweeperPanel.buttonGrid[0][0].getWidth();
    MinesweeperModel.setDefaultIm(MinesweeperPanel.buttonGrid);
  }
}
*/
