import javax.swing.*;

public class QS extends JFrame {
    
    private JButton ViewMaterialsButton;
    private JButton talkToUserButton;
    
    public QS() {
        initComponents();
    }
    
    private void initComponents() {
        ViewMaterialsButton = new JButton("View Materials");
        ViewMaterialsButton.setBounds(80,30,200,40) ;
        talkToUserButton = new JButton("Message a Supplier");
        
        // add action listeners to the buttons
        ViewMaterialsButton.addActionListener(e -> openEditMaterialsDialog());
        talkToUserButton.addActionListener(e -> openChatWindow());
         
        // create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ViewMaterialsButton);
        buttonPanel.add(talkToUserButton);
        
        // add the panel to the frame
        this.getContentPane().add(buttonPanel);
        
        // set the frame properties
        this.setTitle("QS");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void openEditMaterialsDialog() {
        // code to open the "Edit Materials" dialog
        new edit();
    }
    
    private void openChatWindow() {
        // code to open the chat window
    }
    
    public static void main(String[] args) {
        new QS();
    }
}