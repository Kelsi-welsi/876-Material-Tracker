package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddProduct extends JFrame implements ActionListener{
    //DB info
    private String localhost = "3306";
    private String password = "godlove1";
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel descLabel;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField descTextArea;
    private JButton addButton;

    public AddProduct(){
        setTitle("Add Material");
        setSize(750, 500);
        setLayout(new GridBagLayout());
        // setLayout(new GridLayout(0,1));
        GridBagConstraints c = new GridBagConstraints();

        JPanel productPanel = new JPanel();

        nameLabel = new JLabel("Material Name: ");
        nameTextField = new JTextField(15);
        productPanel.add(nameLabel);
        productPanel.add(nameTextField);

        descLabel = new JLabel("Description: ");
        descTextArea = new JTextField(30);
        productPanel.add(descLabel);
        productPanel.add(descTextArea);


        priceLabel = new JLabel("Price: ");
        priceTextField = new JTextField(5);
        productPanel.add(priceLabel);
        productPanel.add(priceTextField);
        add(productPanel);

        c.weighty  = 0.05f;
        c.gridx = 0;
        c.gridy = 4;
        addButton = new JButton("Save");
        addButton.addActionListener(this);
        add(addButton, c);

        setVisible(true);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==addButton){
            Statement sqlSt;
            String SQL = "insert into materials (material_name, description, material_cost)" + " values (?, ?, ?)";
         
            System.out.println(SQL);
    
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbURL = "jdbc:mysql://localhost:" + localhost+"/materials_db";
                Connection dbConnect =  DriverManager.getConnection(dbURL, "root", password);
                sqlSt = dbConnect.createStatement();//allows SQL to be executed
                PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
                preparedStmt.setString (1,nameTextField.getText()  );
                preparedStmt.setString (2,descTextArea.getText() );
                preparedStmt.setInt(3,Integer.parseInt(priceTextField.getText()));
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
        new AddProduct();
    }
}