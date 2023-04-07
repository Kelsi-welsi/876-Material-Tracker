package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class clientGUI extends JFrame {
    private JLabel titleLabel;
    private JTable projectTable;
    private JScrollPane scrollPane;
    private JButton acceptButton;
    private JButton declineButton;
    private JTextField project;
    private JTextField description;
    private int user_id;
    public int project_id;

    private DefaultTableModel tableModel;
    public clientGUI(int user_id)
    {
        super("Client GUI");
        this.user_id = user_id;

        // Initialize the components
        titleLabel = new JLabel("Project List");
        acceptButton = new JButton("Accept");
        declineButton = new JButton("Decline");

        // Set the button action listeners
        //acceptButton.addActionListener(this);
        //declineButton.addActionListener(this);

        // Initialize the project table
    

        // Add the components to the frame
    

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,120,600,400);
        add(mainPanel);

        JLabel projectname = new JLabel("Project Name:");
        projectname.setBounds(20, 120, 80, 50);

        project = new JTextField();
        project.setBounds(120, 130, 170, 25);

        JLabel descriptionname = new JLabel("Description:");
        descriptionname.setBounds(20, 180, 80, 50);
        description = new JTextField();
        description.setBounds(120, 190, 170, 25);

        JButton request = new JButton("Request project");
        request.setBounds(120, 260, 150, 25);

        request.addActionListener(new requestlistener());

        mainPanel.add(projectname);
        mainPanel.add(project);
        mainPanel.add(descriptionname);
        mainPanel.add(description);
        mainPanel.add(request);

        String[] columnNames = {"Project id", "Project Name", "Description", "Status"};
  

        tableModel = new DefaultTableModel(columnNames, 0);
        JTable projectTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(projectTable);
        scrollPane.setBounds(30,0,500,100);

        mainPanel.add(scrollPane);

        // Set the frame properties
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        setLayout(null);
        getprojects();
    }


    public class requestlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Statement sqlSt;
            String SQL = "insert into projects(user_id, project_name, project_description, project_status)" +" values (?, ?, ?, ?);";
            System.out.println(SQL);
    
            try{
    
                //opening a connection to the database
                Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/materials_db";
                Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
    
    
                sqlSt = dbConnect.createStatement();//allows SQL to be executed
                PreparedStatement preparedStmt = dbConnect.prepareStatement(SQL);
                preparedStmt.setInt (1, user_id);
                preparedStmt.setString (2, project.getText());
                preparedStmt.setString (3, description.getText());
                preparedStmt.setString (4, "Pending");
             
             
                preparedStmt.execute();//magic
                sqlSt.close();

                JFrame f=new JFrame();  
                JOptionPane.showMessageDialog(f,"Project received"); 
                Object [] data = {project_id, project.getText(), description.getText(),"Pending"}; 
                project_id+=1;
                tableModel.addRow(data);
            }
            catch(ClassNotFoundException ex){
                System.out.println("DIDNT LOAD JAR");
            }
            catch (SQLException ex){
                System.out.println("SQL IS BAD" +ex.getMessage());
            }
        }

    }

    public void getprojects()
    {
        Statement sqlSt;
        String output = "";
        ResultSet result;
        String SQL = "select * from projects JOIN login_credentials on projects.user_id = login_credentials.user_id WHERE login_credentials.user_id = "+ Integer.toString(user_id)+";";




        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:5501/materials_db";
            Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "tensy456");
            sqlSt = dbConnect.createStatement();//allows SQL to be executed
            result = sqlSt.executeQuery(SQL);
            while(result.next() != false)
            {
                 String id = result.getString(1);
                 String name = result.getString(3);
                 String description=result.getString(4);
                 String type=result.getString(5);   
                 
                 Object [] data = {id, name, description, type}; 
                tableModel.addRow(data);
                project_id = Integer.parseInt(id)+ 1;

                
    
            
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
    
    
}
