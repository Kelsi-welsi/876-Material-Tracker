package View;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminGUI extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JTable projectTable;
    private JScrollPane scrollPane;
    private JButton acceptButton;
    private JButton declineButton;
    private DefaultTableModel tableModel;
    private JTextField proj;
    public adminGUI() {
        super("Admin GUI");

        // Initialize the components
        titleLabel = new JLabel("Project List");
        acceptButton = new JButton("Accept");
        declineButton = new JButton("Decline");

        // Set the button action listeners
        acceptButton.addActionListener(new acceptlistener());
        declineButton.addActionListener(new declinelistener());

        // Initialize the project table
        String[] columnNames = {"Project ID", "Project Name", "Status", "Description", "Owner"};
  
        tableModel = new DefaultTableModel(columnNames, 0);
        projectTable = new JTable(tableModel);
        scrollPane = new JScrollPane(projectTable);
        projectTable.getColumnModel().getColumn(0).setPreferredWidth(1);
        projectTable.getColumnModel().getColumn(4).setPreferredWidth(6);

   
        // Add the components to the frame
        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(acceptButton);
        buttonPanel.add(declineButton);

        JLabel projid = new JLabel("Project ID:");
        projid.setBounds(180,160,80,100);
        this.add(projid, BorderLayout.CENTER);

        proj = new JTextField();
        proj.setBounds(250,195,75,30);
        this.add(proj, BorderLayout.CENTER);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame properties
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        get();
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

public void get()
{
    tableModel.setRowCount(0);
    Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "select * from projects JOIN login_credentials on projects.user_id = login_credentials.user_id WHERE project_status = 'Pending';";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/materials_db";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            result = sqlSt.executeQuery(SQL);
            while(result.next() != false)
            {
                int id = result.getInt(1);
                 String name = result.getString(3);
                 String description=result.getString(4);
                 String type=result.getString(5);   
                 String owner=result.getString(7);   
                 
                 Object [] data = {id, name, type, description, owner}; 
                 tableModel.addRow(data);

                
    
            
            }

            

            sqlSt.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println("DIDNT LOAD JAR");
        }
        catch (SQLException ex){
            System.out.println("SQL IS BAD" +ex.getMessage());
        }

        System.out.println("succesful");
        
    }
    
    public class acceptlistener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //DO SOMETHING
            Statement sqlSt;
            String SQL = "UPDATE projects SET project_status = ? WHERE project_id = ?";
       
    
            System.out.println(SQL);
    
            try{
    
                //opening a connection to the database
                Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/materials_db";
                Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
    
    
                sqlSt = dbConnect.createStatement();//allows SQL to be executed
                PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
                preparedStmt.setString (1, "Approved");
                preparedStmt.setInt (2, Integer.parseInt(proj.getText()));
          
                preparedStmt.execute();//magic
                sqlSt.close();
                get();
            }
            catch(ClassNotFoundException ex){
                System.out.println("DIDNT LOAD JAR");
            }
            catch (SQLException ex){
                System.out.println("SQL IS BAD" +ex.getMessage());
            }
        }
    }

    public class declinelistener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //DO SOMETHING
            Statement sqlSt;
            String SQL = "UPDATE projects SET project_status = ? WHERE project_id = ?";
       
    
            System.out.println(SQL);
    
            try{
    
                //opening a connection to the database
                Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/materials_db";
                Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
    
    
                sqlSt = dbConnect.createStatement();//allows SQL to be executed
                PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
                preparedStmt.setString (1, "Not Approved");
                preparedStmt.setInt (2, Integer.parseInt(proj.getText()));
          
                preparedStmt.execute();//magic
                sqlSt.close();
                get();
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