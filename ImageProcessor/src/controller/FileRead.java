package src.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * a class used for reading a text file.
 */
public class FileRead {
  File f;

  /**
   * a constructor for the class.
   *
   * @param f the file that holds commands.
   */
  public FileRead(File f) {
    this.f = f;
  }

  /**
   * a method that reads a file that holds the commands to run the program.
   *
   * @return a Readable that is sent to the controller to read.
   */
  public Readable readFile() {
    Scanner sc = null;
    StringBuilder s = new StringBuilder();
    try {
      sc = new Scanner(f);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("file not found");
    }
    while (sc.hasNextLine()) {
      s.append(sc.nextLine());
    }
    return new StringReader(s.toString());
  }
}
