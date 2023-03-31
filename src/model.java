import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class model {
    Connection conn = null;
    ArrayList<String> posts = new ArrayList<>();
    String Password;
    public void EnterPassword(){
        JPasswordField pf = new JPasswordField();
        JOptionPane.showConfirmDialog(null, pf, "password?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        this.Password = new String(pf.getPassword());
    }
    public void MakeConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+ DatabaseInfo.ip +":"+ DatabaseInfo.port +"/"+ DatabaseInfo.base +"? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",DatabaseInfo.user,DatabaseInfo.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> GetPosts(){

        try {
            Statement stmt = conn.createStatement();
            String SQLQuery = "SELECT eho02forum.*, eho02users.name FROM eho02forum JOIN eho02users ON eho02forum.authorId = eho02users.id ORDER BY id DESC LIMIT 20";
            ResultSet result = stmt.executeQuery(SQLQuery);

            ResultSetMetaData metadata = result.getMetaData();

            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }

            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getString("name");
                posts.add(output);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
