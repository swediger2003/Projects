package src.view;

import src.controller.Features;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Gui view for an ImageProcessing app that uses JFRAME and Swing to construct
 * a graphical interface for the user.
 */
public class JFrameView extends JFrame implements IView {

  String currentName;

  private JLabel imageLabel;

  private JButton commandSelecterButton;

  private JButton applyCommandButton;

  private Histogram histogram;

  private JLabel optionDisplay;

  private JLabel fileOpenDisplay;

  private JLabel brightenDarkenInputDisplay;

  /**
   * Constructer which establishes every item on the main page of the Graphical interface.
   */
  public JFrameView() {
    super();
    setTitle("Image Processing Jacob and Aaron");
    setSize(1000, 800);
    setLocation(500, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(new Dimension(500, 500));

    //this.setLayout(new FlowLayout());


    JPanel mainPanel = new JPanel();
    mainPanel.setSize(900, 700);
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

    JScrollPane mainScrollPane;

    //scroll bars around this main panel
    mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);


    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));


    //show an image with a scrollbar
    JPanel imagePanel = new JPanel();
    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Showing an image"));
    imagePanel.setLayout(new GridLayout(1, 0, 100, 10));
    //imagePanel.setMaximumSize(null);
    mainPanel.add(imagePanel);

    imageLabel = new JLabel();
    JScrollPane imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(200, 500));
    imageLabel.setLocation(100, 250);
    mainPanel.add(imageScrollPane);

    histogram = new Histogram();
    JScrollPane histoScrollPane = new JScrollPane(histogram);
    histoScrollPane.setPreferredSize(new Dimension(100, 225));
    mainPanel.add(histoScrollPane);


    //dialog boxes
    JPanel dialogBoxesPanel = new JPanel();
    dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Command Center"));
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.LINE_AXIS));
    // dialogBoxesPanel.setSize(100, 200);

    // Command select button
    JPanel inputDialogPanel = new JPanel();
    inputDialogPanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(inputDialogPanel);

    commandSelecterButton = new JButton("Pick the Command");
    commandSelecterButton.setActionCommand("selection command");
    dialogBoxesPanel.add(commandSelecterButton);

    optionDisplay = new JLabel("[Command goes here]");
    dialogBoxesPanel.add(optionDisplay);

    applyCommandButton = new JButton("Apply the Command");
    applyCommandButton.setActionCommand("apply command");
    dialogBoxesPanel.add(applyCommandButton);

    //Load pop-up
    JPanel fileopenPanel = new JPanel();
    fileopenPanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(fileopenPanel);
    JButton fileOpenButton = new JButton("Open a file");
    fileOpenButton.setActionCommand("open file");
    mainPanel.add(dialogBoxesPanel);

    pack();
    setVisible(true);

  }




  /**
   * updates the histogram display.
   *
   * @param red     the red line.
   * @param green   the green line.
   * @param blue    the blue line.
   * @param average the average.
   */
  public void updateHistogram(int[] red, int[] green, int[] blue, int[] average) {
    histogram.setRHisto(red);
    histogram.setGHisto(green);
    histogram.setBHisto(blue);
    histogram.setAvgHisto(average);

    histogram.repaint();
  }


  /**
   * Opens the command pop-up window when the user clicks the choose a command button.
   */
  public void openCommandPopup() {
    String[] options = {"load", "save", "brighten", "darken", "grayscale", "flip", "sepia", "blur",
                        "sharpen", "mosaic"};
    int retvalue = JOptionPane.showOptionDialog(this, "Please choose a command",
            "Options", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
            options, JOptionPane.UNINITIALIZED_VALUE);
    if (retvalue == -1) {
      return;
    }
    if (this.currentName == null && !options[retvalue].equals("load")) {
      JOptionPane.showMessageDialog(this, "Please load an image before" +
                      " attempting apply a filter or save",
              "No Image Loaded", JOptionPane.ERROR_MESSAGE);
      return;
    }
    this.runProgram(options[retvalue]);

  }

  /**
   * Updates the current image on the screen with the given Image.
   */
  public void updateImage(BufferedImage image) {

    //  JScrollPane[] imageScrollPane = new JScrollPane[image.length];
    ImageIcon icon = new ImageIcon(image);
    imageLabel.setIcon(icon);
  }

  /**
   * Adds features to the view, ie functionallity for a button, linking the current view to any
   * controller that implements the features interface.
   *
   * @param features Controller that implements the features interface and provides functionality
   *                 to the view's various buttons and actionable items.
   */
  @Override
  public void addFeatures(Features features) {
    commandSelecterButton.addActionListener(evt -> features.commandSelect());
    applyCommandButton.addActionListener(evt -> features.doAction(optionDisplay.getText()));

  }


  private void runProgram(String text) {
    switch (text) {
      case "load":
        final JFileChooser fchooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PPM Images", "jpg", "ppm");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
                "PNG & BMP Images", "png", "bmp");
        fchooser.setFileFilter(filter);
        fchooser.addChoosableFileFilter(filter2);
        int retvalue = fchooser.showOpenDialog(this);

        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          String filepath = f.getName();
          int endingIndexStart = filepath.indexOf(".");
          this.currentName = filepath.substring(0, endingIndexStart);
          optionDisplay.setText("load " + f.getAbsolutePath() + " ");
        }
        break;
      case "brighten":
      case "darken":
        String input = JOptionPane.showInputDialog("Please type a non-negative increment");
        if (input == null) {
          break;
        }
        if (input.equals("")) {
          break;
        }
        int increment = Integer.parseInt(input);

        if (increment < 0) {
          JOptionPane.showMessageDialog(this,
                  "Please try again with a non-negative increment",
                  "Invalid increment.", JOptionPane.ERROR_MESSAGE);
          break;
        }
        optionDisplay.setText(text + " " + increment + " " + this.currentName + " ");
        break;
      case "save":
        final JFileChooser fchooserSave = new JFileChooser(".");
        int returnValue = fchooserSave.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File f = fchooserSave.getSelectedFile();
          optionDisplay.setText("save " + f.getAbsolutePath() + " ");
        }
        break;
      case "blur":
        optionDisplay.setText("blur " + this.currentName);
        break;
      case "grayscale":
        String[] greyscaleOptions = {"red", "blue", "green", "luma", "intensity", "value",
                                     "regular"};
        int retValue4Gray = JOptionPane.showOptionDialog(this, "Please" +
                        " choose a Grayscale type",
                "Options", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                greyscaleOptions, JOptionPane.UNINITIALIZED_VALUE);
        String choice = greyscaleOptions[retValue4Gray];
        if (choice.equals("regular")) {
          optionDisplay.setText("greyscale " + this.currentName);
        } else {
          optionDisplay.setText(choice + "-component " + this.currentName);
        }

        break;
      case "mosaic":
        String in = JOptionPane.showInputDialog("Please type a non-negative increment");
        if (in == null) {
          break;
        }
        if (in.equals("")) {
          break;
        }
        int seed = Integer.parseInt(in);

        if (seed < 0) {
          JOptionPane.showMessageDialog(this,
                  "Please try again with a non-negative increment",
                  "Invalid increment.", JOptionPane.ERROR_MESSAGE);
          break;
        }


        optionDisplay.setText("mosaic " + seed + " " + this.currentName);
        break;
      case "flip":
        String[] flipOptions = {"horizontal", "vertical"};
        int retValue4Flip = JOptionPane.showOptionDialog(this, "Please choose a flip type",
                "Options", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                flipOptions, JOptionPane.UNINITIALIZED_VALUE);
        optionDisplay.setText(flipOptions[retValue4Flip] + "-flip " + this.currentName);
        break;
      case "sepia":
        optionDisplay.setText("sepia " + this.currentName);
        break;
      case "sharpen":
        optionDisplay.setText("sharpen " + this.currentName);
        break;

      default:
        JOptionPane.showMessageDialog(this, "Please try again.",
                "Unknown Command Found", JOptionPane.ERROR_MESSAGE);
        break;
    }
  }

  public String getCurrentName() {
    return this.currentName;
  }

  public void setImageName(String newName) {
    this.currentName = newName;
  }

}
