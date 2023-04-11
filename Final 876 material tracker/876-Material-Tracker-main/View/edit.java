package View;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class edit extends JFrame implements ActionListener{
    private String localhost = "3306";
    private String password = "godlove1";
    
    private HashMap<String,String> app;
    private JLabel nameLabel;
    private JLabel descLabel;
    private JLabel priceLabel;
    private JLabel frameLabel;
    private JTextField nameTextField;
    private JTextField descTextField;
    private JTextField priceTextField;
    private JButton editButton;

    public edit() {
        JFrame frame = new JFrame("Edit Material");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);   
        frame.setBackground(Color.red);   
       
        JMenuBar mm = new JMenuBar();
        JMenu m1 = new JMenu("Manage Material");
        JMenu m2 = new JMenu("Help");
        mm.add(m1);
        mm.add(m2);
        JMenuItem m11 = new JMenuItem("Add Material");
        JMenuItem m22 = new JMenuItem("Edit Material");
        JMenuItem m33 = new JMenuItem("Delete Material");
        m11.addActionListener(new addButtonListener());
        m33.addActionListener(new deleteButtonListener());

        m1.add(m11);
        m1.add(m22);
        m1.add(m33);
        
        
       JPanel inputpanel= new JPanel();
       inputpanel.setBackground(Color.pink);
       nameLabel = new JLabel("Material Name");
       nameTextField = new JTextField(15);
       nameTextField.setColumns(20);
       descLabel = new JLabel("Description     ");
       descTextField = new JTextField(30);
       descTextField.setColumns(20);
       priceLabel = new JLabel("Material Price");
       priceTextField = new JTextField(15);
       priceTextField.setColumns(20);

 
        inputpanel.add(nameLabel);
        inputpanel.add(nameTextField);
        inputpanel.add(descLabel);
        inputpanel.add(descTextField);
        inputpanel.add(priceLabel );
        inputpanel.add(priceTextField);

        JPanel buttonpanel= new JPanel();

        editButton = new JButton("Submit");
        editButton.addActionListener(this);
        buttonpanel.add(editButton);

        frame.getContentPane().add(BorderLayout.NORTH,mm);
        frame.getContentPane().add(BorderLayout.CENTER,inputpanel);
        frame.getContentPane().add(BorderLayout.SOUTH,buttonpanel);
        frame.setVisible(true);
    
    
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton) {
            String materialname = "'" +  nameTextField.getText() +"'";
            String desc = "'" +  descTextField.getText() +"'";
            String price = priceTextField.getText();
            // Update the material in the system with the new name
            //
            Statement sqlSt;


        String SQL = "UPDATE materials SET material_cost ="+ price+", description ="+desc+" WHERE material_name ="+materialname;
     
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
        public static void main(String[] args) {
        
            new edit();
    
            
        }
    public  class addButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddProduct();
        }
    }
    
    public  class deleteButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new delete();
        }
           
        }
}