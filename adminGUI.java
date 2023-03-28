import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminGUI extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JTable projectTable;
    private JScrollPane scrollPane;
    private JButton acceptButton;
    private JButton declineButton;

    public adminGUI() {
        super("Admin GUI");

        // Initialize the components
        titleLabel = new JLabel("Project List");
        acceptButton = new JButton("Accept");
        declineButton = new JButton("Decline");

        // Set the button action listeners
        acceptButton.addActionListener(this);
        declineButton.addActionListener(this);

        // Initialize the project table
        String[] columnNames = {"Project Name", "Owner", "Description"};
        Object[][] data = {
                {"Project A", "Client A", "This is a description of Project A."},
                {"Project B", "Client B", "This is a description of Project B."},
                {"Project C", "Client C", "This is a description of Project C."},
                {"Project D", "Client D", "This is a description of Project D."},
                {"Project E", "Client E", "This is a description of Project E."}
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        projectTable = new JTable(tableModel);
        scrollPane = new JScrollPane(projectTable);

        // Add the components to the frame
        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(acceptButton);
        buttonPanel.add(declineButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame properties
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the button actions
        if (e.getSource() == acceptButton) {
            int selectedRow = projectTable.getSelectedRow();
            if (selectedRow != -1) {
                JOptionPane.showMessageDialog(null, "You accepted the project.");
            }
        } else if (e.getSource() == declineButton) {
            int selectedRow = projectTable.getSelectedRow();
            if (selectedRow != -1) {
                JOptionPane.showMessageDialog(null, "You declined the project.");
            }
        }
    }
public static void main(String[] args) {
        
    new adminGUI();

    
}
}