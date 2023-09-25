
import View.frame;
import View.intro;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new intro();
        //USA THREAD NUEVO DE AWT PARA LA VIEW
        SwingUtilities.invokeLater(frame::new);
    }
}









