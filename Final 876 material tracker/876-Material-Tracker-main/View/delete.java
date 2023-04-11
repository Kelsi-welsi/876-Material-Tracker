package View;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.*;
public class delete extends JFrame implements ActionListener{
    private String localhost = "3306";
    private String password = "godlove1";
    private JTextField tf ;

    public delete(){
        //Creating the Frame
        JFrame frame = new JFrame("Delete Material");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mm = new JMenuBar();
        JMenu m1 = new JMenu("Manage Material");
        JMenu m2 = new JMenu("Help");
        mm.add(m1);
        mm.add(m2);
        JMenuItem m11 = new JMenuItem("Add Material");
        JMenuItem m22 = new JMenuItem("Edit Material");
        JMenuItem m33 = new JMenuItem("Delete Material");
        m11.addActionListener(new addButtonListener());
        m22.addActionListener(new editButtonListener());

        m1.add(m11);
        m1.add(m22);
        m1.add(m33);
        

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Material to be deleted:");
        tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Delete");
        send.addActionListener(new delButtonListener());
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mm);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        //send.addActionListener();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        new delete();

        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    //public void actionPerformed(ActionEvent e){
   // textArea.setText(textArea.getText().concat("Material Deleted!"));
   // }

   public  class addButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        new AddProduct();
    }
}

public  class editButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        new edit();
    }
       
    }


public  class delButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Statement sqlSt;

        String text=  "'" +  tf.getText() +"'";

        String SQL = "delete FROM materials WHERE material_name = " +text;
     
        System.out.println(SQL);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:" + localhost+"/materials_db";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", password);
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
            preparedStmt.execute();
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }
    }
}
}

