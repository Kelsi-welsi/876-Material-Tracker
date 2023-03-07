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

public class Editproduct extends JFrame implements ActionListener{
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

    public Editproduct() {
        this.app = app;
        setTitle("Edit Material Frame");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.weighty = 0.05;
        c.weightx = 0.05;

        c.gridx = 0;
        c.gridy = 2;
        nameLabel = new JLabel("Material Name");
        add(nameLabel,c);
        
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 3;
        descLabel = new JLabel("Description");
        add(descLabel,c);

        c.gridx = 5;
        c.gridy = 2;
        c.gridwidth = 2;
        priceLabel = new JLabel("Price");
        add(priceLabel,c);

    
        c.gridx = 0;
        c.gridy = 3;
        nameTextField = new JTextField(15);
        add(nameTextField,c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 5;
        descTextField = new JTextField(30);
        add(descTextField,c);

        c.gridx = 5;
        c.gridy = 3;
        c.gridwidth = 5;
        priceTextField = new JTextField(15);
        add(priceTextField,c);

        c.weighty  = 0.05f;
        c.gridx = 0;
        c.gridy = 4;
        editButton = new JButton("Submit");
        editButton.addActionListener(this);
        add(editButton,c);

        setVisible(true);
    
    
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
 
}