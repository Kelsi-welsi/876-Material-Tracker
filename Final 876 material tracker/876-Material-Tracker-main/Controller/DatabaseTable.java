package Controller;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DatabaseTable {
    private static ArrayList<String> names;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // explicitly load the MySQL driver
            String dbURL = "jdbc:mysql://localhost:3306/materials_db";
            String username = "root";
            String password = "godlove1";

            Connection conn = DriverManager.getConnection(dbURL, username, password);
            String sql = "SELECT * FROM mytable";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            JTable table = new JTable(buildTableModel(result));
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        Object[][] data = new Object[100][columnCount];
        int rowCount = 0;
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                data[rowCount][i - 1] = rs.getObject(i);
            }
            rowCount++;
        }

        return new DefaultTableModel(data, columnNames);
    }

    public  ArrayList<String> get()
    {
        names = new ArrayList<>();
        Statement sqlSt;
            String output = " ";
            ResultSet result;
            String SQL = "Select * FROM materials;";
    
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbURL = "jdbc:mysql://localhost:3306/materials_db";
                Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "godlove1");
                sqlSt = dbConnect.createStatement();//allows SQL to be executed
                result = sqlSt.executeQuery(SQL);
                while(result.next() != false)
                {
               
                     String name = result.getString(2);

                     names.add(name);
                
                  
    
                     System.out.println(name);
        
                
                }

                
    
                sqlSt.close();
            }
            catch(ClassNotFoundException ex){
                System.out.println("DIDNT LOAD JAR");
            }
            catch (SQLException ex){
                System.out.println("SQL IS BAD" +ex.getMessage());
            }
            return names;
        }

}
