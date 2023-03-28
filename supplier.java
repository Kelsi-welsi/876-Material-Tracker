import javax.swing.*;

public class supplier extends JFrame {
    
    private JButton editMaterialsButton;
    private JButton talkToUserButton;
    
    public supplier() {
        initComponents();
    }
    
    private void initComponents() {
        editMaterialsButton = new JButton("Edit Materials");
        talkToUserButton = new JButton("Message a Quanity Surveyer");
        
        // add action listeners to the buttons
        editMaterialsButton.addActionListener(e -> openEditMaterialsDialog());
        talkToUserButton.addActionListener(e -> openChatWindow());
        
        // create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editMaterialsButton);
        buttonPanel.add(talkToUserButton);
        
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
    
    private void openChatWindow() {
        // code to open the chat window
    }
    
    public static void main(String[] args) {
        new supplier();
    }
}