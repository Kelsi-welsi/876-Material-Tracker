import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {

    // GUI components
    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Constructor
    public LoginGUI() {
        setTitle("Login Page");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        userLabel = new JLabel("Username:");
        userTextField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Set layout
        setLayout(new GridLayout(3, 2));

        // Add components to the frame
        add(userLabel);
        add(userTextField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel(""));
        add(loginButton);

        // Add action listener to login button
        loginButton.addActionListener(this);

        setVisible(true);
    }

    // Action performed method for login button
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        String password = new String(passwordField.getPassword());

        // Validate credentials
        if (username.equals("admin") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new LoginGUI();
    }
}
