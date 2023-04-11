package Controller;

import javax.swing.*;
import View.adminGUI;
import View.clientGUI;
import View.qsGui;
import View.*;
import java.awt.Color; 
import java.awt.event.*;

public class LoginAuthenticator extends JFrame implements ActionListener {

    // GUI components
    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private LoginAuthenticator ui;
    private JButton loginButton;
    public String mess = "";
    public qsGui sup;
    public supplier realsup;

    // Constructor
    public LoginAuthenticator() {

        ui = this;
        setTitle("Login Page");
        JPanel panel = new JPanel();
        panel.setSize(500, 300);
        panel.setLayout(null);



        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       ImageIcon image = new ImageIcon("876-Material-Tracker-main/download.png");
        JLabel pic = new JLabel(image);
        pic.setBounds(5, 15, 140, 140);
        
//E86A33
        // Initialize components
        userLabel = new JLabel("Username:");
        userLabel.setBounds(150, 5, 80, 30);
        userLabel.setForeground(Color.decode("#FF6000"));
        userTextField = new JTextField(20);
        userTextField.setBounds(250, 5, 100, 30);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.decode("#FF6000"));
        passwordLabel.setBounds(150, 55, 80, 30);
        passwordField = new JPasswordField(20);
        passwordField.setBounds(250, 55, 100, 30);
        loginButton = new JButton("Login");
        loginButton.setBounds(200, 125, 100, 30);

         JRadioButton rb1=new JRadioButton("Client");  
         rb1.setBounds(100, 150, 59, 50);

         JRadioButton rb2=new JRadioButton("Admin");
         rb2.setBounds(159, 150, 80, 50);


      


        getContentPane().setBackground( Color.white );
        panel.setBackground(Color.white);
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
        panel.add(pic);
        // Add action listener to login button
        loginButton.addActionListener(this);

        setVisible(true);
    }

    // Action performed method for login button
    public void actionPerformed(ActionEvent e) {
        String usernam = userTextField.getText();
     String passwor = new String(passwordField.getPassword());
     User bob = new User(usernam,passwor);
     String type = bob.login(usernam, passwor);
      if (type.equals("Client"))
                 {
                     new clientGUI(bob.user_id);
                   
                 }
                 else if(type.equals("Admin"))
                 {
                     new adminGUI();  
                  
                 }

                 else if(type.equals("Supplier"))
                 {
                     realsup = new supplier(ui); 
                  
                 }

                 else if(type.equals("Quantity Surveyor"))
                 {
                     sup = new qsGui(ui, realsup); 
                     
                 }
               
             

        
    }

    

    // Main method to start the application
    public static void main(String[] args) {
        new LoginAuthenticator();
     
    }
}
