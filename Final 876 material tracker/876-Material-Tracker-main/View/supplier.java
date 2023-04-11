package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.LoginAuthenticator;
import Controller.MaterialSearchApp;
import Controller.MessagingController1;

public class supplier extends JFrame {
    
    private JButton editMaterialsButton;
    private JButton talkToUserButton;
    private LoginAuthenticator ui;
    private JButton search;
    public MessagingController1 chatui;
    
    public supplier(LoginAuthenticator ui) {
        this.ui  =ui;
        editMaterialsButton = new JButton("Edit Materials");
        talkToUserButton = new JButton("Message a Quanity Surveyer");
        search = new JButton("Search Materials");

        
        talkToUserButton.addActionListener(new talklistener());
        
        // add action listeners to the buttons
        editMaterialsButton.addActionListener(e -> openEditMaterialsDialog());
        talkToUserButton.addActionListener(e -> openChatWindow());
        search.addActionListener(e -> matSearch());
        
        // create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editMaterialsButton);
        buttonPanel.add(talkToUserButton);
        
        buttonPanel.add(search);
        // add the panel to the frame
        this.getContentPane().add(buttonPanel);
        
        // set the frame properties
        this.setTitle("Supplier GUI");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
     
    }
    
  
    
    private void openEditMaterialsDialog() {
        // code to open the "Edit Materials" dialog
        new delete();
    }

    private void matSearch() {
        // code to open the "Edit Materials" dialog
        new MaterialSearchApp();
    }
    
    private void openChatWindow() {
        // code to open the chat window
    }

    public class talklistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            chatui = new MessagingController1(ui);
        }

      
    }
    

}