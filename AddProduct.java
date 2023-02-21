import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddProduct extends JFrame implements ActionListener{
    private JLabel nameLabel;
    private JLabel descLabel;
    private JLabel priceLabel;
    private JTextField nameTextField;
    private JTextField descTextField;
    private JTextField priceTextField;
    private JButton addButton;

    public AddProduct(){
        setTitle("Add Material");

        JPanel productPanel = new JPanel();

        nameLabel = new JLabel("Material Name: ");
        nameTextField = new JTextField();
        productPanel.add(nameLabel);
        productPanel.add(nameTextField);

        descLabel = new JLabel("Description: ");
        descTextField = new JTextField();
        productPanel.add(descLabel);
        productPanel.add(descTextField);

        priceLabel = new JLabel("Price: ");
        priceTextField = new JTextField();
        productPanel.add(priceLabel);
        productPanel.add(priceTextField);
        
        addButton = new JButton("Save");
        addButton.addActionListener(this);
        add(addButton);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}