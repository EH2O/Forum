import javax.swing.*;

public class Controller extends JFrame {
     view view;
     modell modell;
    public Controller(modell m, view v) {
        this.modell = m;
        this.view = v;

        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        modell m = new modell();
        view v = new view();
        Controller thisIsTheProgram = new Controller(m,v);
        thisIsTheProgram.setVisible(true);
    }


}
