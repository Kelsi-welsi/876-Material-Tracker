package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaterialSearchApp {

    private JFrame frame;
    private JTextField textField;
    private static ArrayList<String> names;
    private JTextArea textArea;
    private static DatabaseTable db  = new DatabaseTable();

    // Sample data structure to represent a table of materials

 

    public MaterialSearchApp() {
        initialize();
        names = db.get();
    }

    
    

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // add logo at the top left corner
        ImageIcon logo = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(logo);
        frame.getContentPane().add(logoLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);

        JLabel searchLabel = new JLabel("Material Name:");
        searchPanel.add(searchLabel);

        textField = new JTextField();
        textField.setColumns(20);
        textField.setMargin(new Insets(2, 5, 2, 5));
        searchPanel.add(textField);

        JButton searchButton = new JButton("Find Material");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                /* 
                String materialName = textField.getText();
                String materialInfo = materials.get(materialName);
                if (materialInfo != null) {
                    textArea.setText(materialInfo);
                } else {
                    textArea.setText("Material not found.");
                }
                 */

                 for(String blah:names)
                 {
                    if(blah.equals(textField.getText()))
                    {
                        found = true;
                        break;
                    }
                 }

                 if(found)
                 {
                    textArea.setText("Material found.");
                    JOptionPane.showConfirmDialog (null, "Material Found","Found",JOptionPane.DEFAULT_OPTION);
                 }
                 else{
                    textArea.setText("Material not found.");
                    JOptionPane.showConfirmDialog (null, "Material Not Found","Not Found",JOptionPane.DEFAULT_OPTION);

                 }
                
            }
           
        });
        searchPanel.add(searchButton);

        JLabel resultLabel = new JLabel("Material Information:");
        frame.getContentPane().add(resultLabel, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);

        // Sample data for the materials table
       

        // change background color
        searchPanel.setBackground(Color.WHITE);
        resultLabel.setBackground(Color.WHITE);
        textArea.setBackground(Color.WHITE);
        frame.setVisible(true);
    }
}
