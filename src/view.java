import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class view {
    String text = "";
    private JPanel base;
    private JButton login;
    private JScrollPane posts;
    private JTextArea conntent;

    public Container getPanel() {
        return base;
    }
    public void setText(ArrayList<String> post){
        for (int i = 0; i < post.size(); i++) {
            text += post.get(i) + "\n";
        }
        conntent.setText(text);
    }
}
