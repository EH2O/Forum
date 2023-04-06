import javax.swing.*;
import java.sql.*;
public class Controller extends JFrame {
     view view;
     model model;
    public Controller(model m, view v) {
        this.model = m;
        this.view = v;

        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        m.MakeConnection();

        v.setText( m.GetPosts());


    }

    public static void main(String[] args) {
        model m = new model();
        view v = new view();
        Controller thisIsTheProgram = new Controller(m,v);
        thisIsTheProgram.setVisible(true);
    }


}
