import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddProduct extends JFrame implements ActionListener{
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel descLabel;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextArea descTextArea;
    private JButton addButton;

    public AddProduct(){
        setTitle("Add Material");
        setSize(750, 500);
        setLayout(new GridBagLayout());
        // setLayout(new GridLayout(0,1));
        GridBagConstraints c = new GridBagConstraints();

        JPanel productPanel = new JPanel();

        nameLabel = new JLabel("Material Name: ");
        nameTextField = new JTextField(30);
        productPanel.add(nameLabel);
        productPanel.add(nameTextField);

        descLabel = new JLabel("Description: ");
        descTextArea = new JTextArea();
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==addButton){
            System.out.println("Item added successfully!");
        }
    }

    public static void main(String[] args) {
        new AddProduct();
    }
}