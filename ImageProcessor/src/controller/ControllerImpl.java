package src.controller;

import src.model.BlueGreyscale;
import src.model.Blur;
import src.model.Brighten;
import src.model.Darken;
import src.model.GreenGreyscale;
import src.model.GreyScale;
import src.model.HorzFlip;
import src.model.ImageFunction;
import src.model.ImageModel;
import src.model.ImageProcModel;
import src.model.Intensity;
import src.model.Load;
import src.model.Luma;
import src.model.Mosaic;
import src.model.RedGreyscale;
import src.model.Save;
import src.model.Sepia;
import src.model.Sharpen;
import src.model.TestComp;
import src.model.ValueComponent;
import src.model.VerticalFlip;

import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;


// our file and text commands are without the - first. meaning the command would work with 'file'
// but not '-file'

/**
 * Controller for the image processing program. Delegates tasks to the model
 * based upon the text input from the user, via a readable.
 */
public class ControllerImpl implements IController {
  Map<String, Function<Scanner, ImageFunction>> commands = new HashMap<>();

  Map<String, Function<Scanner, Map<Integer, Integer>>> histograms = new HashMap<>();

  ImageModel m;
  Readable readable;


  /**
   * controller for the class. creates a controller with 2 default values.
   */
  public ControllerImpl() {
    this(new InputStreamReader(System.in), new ImageProcModel());
  }

  /**
   * controller for the class.
   *
   * @param rd is a parameter that represents the readable from which the controller is reading
   *           commands.
   */
  public ControllerImpl(Readable rd) {
    this(rd, new ImageProcModel());
  }

  /**
   * constructor for the class.
   *
   * @param m the model that the constructor is interacting with.
   */
  public ControllerImpl(ImageModel m) {
    this(new InputStreamReader(System.in), m);
  }

  /**
   * constructor for the class.
   *
   * @param rd the readable from which the controller reads commands
   * @param m  the model with which the controller is interacting with.
   */
  public ControllerImpl(Readable rd, ImageModel m) {
    this.readable = rd;
    this.m = m;
    commands.put("brighten", s -> {
      try {
        return new Brighten(s.nextInt(), s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("load", s -> {
      try {
        return new Load(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("save", s -> {
      try {
        return new Save(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("horizontal-flip", s -> {
      try {
        return new HorzFlip(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("vertical-flip", s -> {
      try {
        return new VerticalFlip(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("darken", s -> {
      try {
        return new Darken(s.nextInt(), s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("red-component", s -> {
      try {
        return new RedGreyscale(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("green-component", s -> {
      try {
        return new GreenGreyscale(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("blue-component", s -> {
      try {
        return new BlueGreyscale(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("luma-component", s -> {
      try {
        return new Luma(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("intensity-component", s -> {
      try {
        return new Intensity(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("value-component", s -> {
      try {
        return new ValueComponent(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("blur", s -> {
      try {
        return new Blur(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("sepia", s -> {
      try {
        return new Sepia(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("sharpen", s -> {
      try {
        return new Sharpen(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("greyscale", s -> {
      try {
        return new GreyScale(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    commands.put("test-i", s -> {
      try {
        return new TestComp(s.next(), s.next());
      } catch (Exception e) {
        throw new IllegalArgumentException("wrong input");
      }
    });
    commands.put("mosaic", s -> {
      try {
        return new Mosaic(s.nextInt(), s.next(), s.next(), new Random());
      } catch (Exception e) {
        throw new IllegalArgumentException("wrong input");
      }
    });

    /*  histograms.put("redHistogram", s -> {
      try {
        return m.getHistogramMap(s.next(), (Pixel :: getRed));
      } catch(Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    histograms.put("greenHistogram", s -> {
      try {
        return m.getHistogramMap(s.next(), (Pixel :: getGreen));
      } catch(Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });
    histograms.put("blueHistogram", s -> {
      try {
        return m.getHistogramMap(s.next(), (Pixel :: getBlue));
      } catch(Exception e) {
        throw new IllegalArgumentException("invalid input");
      }
    });*/

  }

  // private ImageFunction returnLoads(Scanner s) {
  //  if
  // }

  /**
   * Initializes the image processing game and starts to read input from the given readable,
   * which then calls upon commands in the command Map.
   */
  public void playGame() {
    Scanner s = new Scanner(this.readable);
    while (s.hasNext()) {
      ImageFunction c;
      String in = s.next();
      Function<Scanner, ImageFunction> cmd = commands.getOrDefault(in, null);
      if (in.equalsIgnoreCase("file")) {
        File file = new File(s.next());
        Readable r = new FileRead(file).readFile();
        IController controller = new ControllerImpl(r, this.m);
        controller.playGame();
      } else if (in.equalsIgnoreCase("text")) {
        continue;
      } else if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit")) {
        return;
      } else if (cmd == null) {
        throw new IllegalArgumentException("No command found");
      } else {
        c = cmd.apply(s);
        m.alter(c);
      }
    }
  }

}

