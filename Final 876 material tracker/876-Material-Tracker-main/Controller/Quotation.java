package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Quotation extends JFrame {
   private JTextField fnameinput ;
   private JTextField lnameinput ;
   private JTextField line1input ;
   private JTextField line2input ;
   private JTextField cityinput ;
    public Quotation()
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,120,600,500);
        add(mainPanel);

        JLabel title = new JLabel("Shipping Details");
        title.setBounds(200, 5, 250, 70);
        title.setFont(new Font("Serif", Font.PLAIN, 24));

        JLabel fname = new JLabel("First Name");
        fname.setFont(new Font("Serif", Font.PLAIN, 14));
        fname.setBounds(120, 80, 85, 50);

        fnameinput = new JTextField();
        fnameinput.setFont(new Font("Serif", Font.PLAIN, 14));
        fnameinput.setBounds(120, 130, 120, 23);

        JLabel lname = new JLabel("Last Name");
        lname.setFont(new Font("Serif", Font.PLAIN, 14));
        lname.setBounds(300, 80, 85, 50);

         lnameinput = new JTextField();
        lnameinput.setFont(new Font("Serif", Font.PLAIN, 14));
        lnameinput.setBounds(300, 130, 120, 23);

        JLabel line1 = new JLabel("Shipping Address Line 1");
        line1.setFont(new Font("Serif", Font.PLAIN, 14));
        line1.setBounds(120, 160, 305, 50);

         line1input = new JTextField();
        line1input.setFont(new Font("Serif", Font.PLAIN, 14));
        line1input.setBounds(120, 210, 250, 23);

        JLabel line2 = new JLabel("Shipping Address Line 2");
        line2.setFont(new Font("Serif", Font.PLAIN, 14));
        line2.setBounds(120, 240, 305, 50);

         line2input = new JTextField();
        line2input.setFont(new Font("Serif", Font.PLAIN, 14));
        line2input.setBounds(120, 290, 250, 23);

        JLabel city = new JLabel("City");
        city.setFont(new Font("Serif", Font.PLAIN, 14));
        city.setBounds(120, 320, 305, 50);

        cityinput = new JTextField();
        cityinput.setFont(new Font("Serif", Font.PLAIN, 14));
        cityinput.setBounds(120, 370, 125, 23);

        JButton but = new JButton("Request Shipping");
        but.setFont(new Font("Serif", Font.PLAIN, 14));
        but.setBounds(200, 430, 145, 23);
     
     
        but.setBackground(Color.WHITE);
      
        but.addActionListener(new requestlistener());
        //project = new JTextField();
        //project.setBounds(105, 110, 150, 25);

        //JLabel descriptionname = new JLabel("Description:");
        //descriptionname.setBounds(270, 100, 80, 50);
        //description = new JTextField();
        //description.setBounds(355, 110, 170, 25);
        mainPanel.add(line2);
        mainPanel.add(but);
        mainPanel.add(city);
        mainPanel.add(line1input);
        mainPanel.add(cityinput);
        mainPanel.add(fname);
        mainPanel.add(line2input);
        mainPanel.add(lname);
        mainPanel.add(title);
        mainPanel.add(line1);
        mainPanel.add(lnameinput);
        mainPanel.add(fnameinput);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        setLayout(null);
    }

    public class requestlistener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            String name = fnameinput.getText()+" "+lnameinput.getText();
            String line1 = line1input.getText();
            String line2 = line2input.getText();
            String city = cityinput.getText();
            Statement sqlSt;

            if (name.equals("") || line1.equals("") || line2.equals("")|| city.equals(""))
            {
                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Error");
                return;
            }
            
            String SQL = "INSERT INTO shipping_details(client_name, shipping_line1, shipping_line2, city)" + " values (?, ?, ?, ?);";
            System.out.println(SQL);
    
            try{
    
                //opening a connection to the database
                Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/materials_db";
                Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "godlove1");
    
    
                sqlSt = dbConnect.createStatement();//allows SQL to be executed
                PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
                preparedStmt.setString (1, name);
                preparedStmt.setString (2, line1);
                preparedStmt.setString (3, line2);
                preparedStmt.setString (4, city);
             
             
                preparedStmt.execute();//magic
                sqlSt.close();

                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Details Saved."); 
           
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
