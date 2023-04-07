package Controller;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginAuthenticator extends JFrame implements ActionListener {

    // GUI components
    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private LoginAuthenticator ui;
    private JButton loginButton;
    public String mess = "";
    qsGui sup;
    supplier realsup;
    // Constructor
    public LoginAuthenticator() {

        ui = this;
        setTitle("Login Page");
        JPanel panel = new JPanel();
        panel.setSize(300, 200);
        panel.setLayout(null);



        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       

        

        // Initialize components
        userLabel = new JLabel("Username:");
        userLabel.setBounds(0, 0, 80, 30);
        userTextField = new JTextField(20);
        userTextField.setBounds(100, 0, 100, 30);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(0, 50, 80, 30);
        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 100, 30);
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 100, 100, 30);

         JRadioButton rb1=new JRadioButton("Client");  
         rb1.setBounds(100, 150, 59, 50);

         JRadioButton rb2=new JRadioButton("Admin");
         rb2.setBounds(159, 150, 80, 50);


      



        // Set layout
        setLayout(null);
        add(panel);
        // Add components to the frame
        //panel.add(rb1);
        //panel.add(rb2);
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(loginButton);

        // Add action listener to login button
        loginButton.addActionListener(this);

        setVisible(true);
    }

    // Action performed method for login button
    public void actionPerformed(ActionEvent e) {
        String usernam = userTextField.getText();
        String passwor = new String(passwordField.getPassword());

        Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "SELECT * from login_credentials";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/materials_db";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            result = sqlSt.executeQuery(SQL);
            while(result.next() != false)
            {
                 int userid = result.getInt(1);
                 String username = result.getString(2);
                 String password=result.getString(3);
                 String type=result.getString(4);      

                
                if (usernam.equals(username) && password.equals(passwor))
                {
                    if (type.equals("Client"))
                    {
                        new clientGUI(userid);
                        break; 
                    }
                    else if(type.equals("Admin"))
                    {
                        new adminGUI();  
                        break;
                    }

                    else if(type.equals("Supplier"))
                    {
                        realsup = new supplier(ui); 
                       break;    
                    }

                    else if(type.equals("Quantity Surveyor"))
                    {
                        sup = new qsGui(ui, realsup); 
                       break;    
                    }
                  
                }
            
            }

            

            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }

        System.out.println("succesful");
        
    }

    

    // Main method to start the application
    public static void main(String[] args) {
        new LoginAuthenticator();
    }
}
