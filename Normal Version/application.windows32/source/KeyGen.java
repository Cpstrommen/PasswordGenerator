import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class KeyGen extends PApplet {


PFont f;

PrintWriter output;

int numberOfChar = 8;

int switcher = 0;
int number = 0;
int letter = 0;
int i = 0;
int count = 1;
int once = 0;
int desired = 0;
float percent = 0;

long Mbytes = 0;

String title = "Wordlist_";
String fakeConsole = "";
String typing = "";
String saved = "";
String status = "Ready";

public void setup() {
   
   
   title = title + year();
   title = title + "-";
   title = title + month();
   title = title + "-";
   title = title + day();
   title = title + "_";
   title = title + hour();
   title = title + "-";
   title = title + minute();
   title = title + "-";
   title = title + second();
   title = title + ".txt";
   
   output = createWriter(title);
   println(title);
   
   f = createFont("Arial", 16);
   
}

public void draw(){ 
    background(0);
    int indent = 25;
    
    // Set the font and fill for text
    textFont(f);
    fill(255);
    
    // Display everything
    text("Input Number of Keys Desired. \nHit enter to begin generating.", indent, 40);
    text("Number to Request: " + typing,indent,190);
    text("Last Requested: " + saved,indent,230);
  
  fakeConsole = "";
  if (count < desired) {
    running();
    fill(241, 244, 65);
    status = "Running";
  }
  if (desired == count) {
     status = "Complete/Ready";
     desired = 0;
     count = 0;
  }
  
  percent = (count/(desired+0.0001f))*100;
  
  fill(255);
  fakeConsole = fakeConsole + title + "\n";
  fakeConsole = fakeConsole + "Key #: " + count;
  fakeConsole = fakeConsole + "  Size: " + Mbytes + " MB" + "\n";
  fakeConsole = fakeConsole + "Status: " + status + "  Percent Complete: " + percent + "%";
  text(fakeConsole, indent, 275, width-40, height-40);
  
  stroke(65, 244, 73);
  strokeWeight(2);
  line(20,380,(percent*3.6f)+20,380);
  
}

public void keyPressed() {
  
  // If the return key is pressed, save the String and clear it
  if (key == '\n' ) {
    saved = typing;
    // A String can be cleared by setting it equal to ""
    typing = ""; 
    desired = PApplet.parseInt(saved);
    
  } else {
    // Otherwise, concatenate the String
    // Each character typed by the user is added to the end of the String variable.
    typing = typing + key; 
  }

}


// MAIN LOOP----------------------------------------------------------------------

public void running() {
  
  print("  Password #: ");;
  print(count);
  print("  Key:  ");
  
  while (i < numberOfChar) {
  
    switcher = PApplet.parseInt(random(0,2));
    number = PApplet.parseInt(random(0,10));
    letter = PApplet.parseInt(random(1,26));
    
    if (switcher == 0) {
      output.print(number);
      print(number);
    }
    if (switcher == 1) {
      if (letter == 1) {
        output.print("a");
        print("a");
      }
      if (letter == 2) {
        output.print("b");
        print("b");
      }
      if (letter == 3) {
        output.print("c");
        print("c");
      }
      if (letter == 4) {
        output.print("d");
        print("d");
      }
      if (letter == 5) {
        output.print("e");
        print("e");
      }
      if (letter == 6) {
        output.print("f");
        print("f");
      }
      if (letter == 7) {
        output.print("g");
        print("g");
      }
      if (letter == 8) {
        output.print("h");
        print("h");
      }
      if (letter == 9) {
        output.print("i");
        print("i");
      }
      if (letter == 10) {
        output.print("j");
        print("j");
      }
      if (letter == 11) {
        output.print("k");
        print("k");
      }
      if (letter == 12) {
        output.print("l");
        print("l");
      }
      if (letter == 13) {
        output.print("m");
        print("m");
      }
      if (letter == 14) {
        output.print("n");
        print("n");
      }
      if (letter == 15) {
        output.print("o");
        print("o");
      }
      if (letter == 16) {
        output.print("p");
        print("p");
      }
      if (letter == 17) {
        output.print("q");
        print("q");
      }
      if (letter == 18) {
        output.print("r");
        print("r");
      }
      if (letter == 19) {
        output.print("s");
        print("s");
      }
      if (letter == 20) {
        output.print("t");
        print("t");
      }
      if (letter == 21) {
        output.print("u");
        print("u");
      }
      if (letter == 22) {
        output.print("v");
        print("v");
      }
      if (letter == 23) {
        output.print("w");
        print("w");
      }
      if (letter == 24) {
        output.print("x");
        print("x");
      }
      if (letter == 25) {
        output.print("y");
        print("y");
      }
      if (letter == 26) {
        output.print("z");
        print("z");
      }
    }
    
   i++;
}
    i = 0;
    Mbytes = ((count*numberOfChar)/1000000);
    count++;
    
    println();
    output.println();
}
  public void settings() {  size(400, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "KeyGen" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
