import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;


public class EditButtonGUI extends JFrame implements ActionListener {
    
    private HashMap<String,String> app;
    private JLabel nameLabel;
    private JLabel descLabel;
    private JLabel frameLabel;
    private JTextField nameTextField;
    private JTextField descTextField;
    private JButton editButton;

    public EditButtonGUI(HashMap<String,String> app) {
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
        c.gridwidth = 5;
        descLabel = new JLabel("Description");
        add(descLabel,c);

    
        c.gridx = 0;
        c.gridy = 3;
        nameTextField = new JTextField(15);
        add(nameTextField,c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 5;
        descTextField = new JTextField(30);
        add(descTextField,c);

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
            String materialname = nameTextField.getText();
            String desc = descTextField.getText();
            // Update the material in the system with the new name
            //
            if (app.containsKey(materialname)){
                app.put(materialname,desc);
                System.out.println("Successfully edited " + materialname + " to " + desc);
                System.out.println(app);
            } else {
                System.out.println(materialname + " not found in records, records unchanged");
                System.out.println(app);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String,String> app = new HashMap<String,String>();
        for(int i = 0; i<10; i++){
            app.put("Key_" + Integer.toString(i), "Dummy Data");
        }
        new EditButtonGUI(app);
    }
}