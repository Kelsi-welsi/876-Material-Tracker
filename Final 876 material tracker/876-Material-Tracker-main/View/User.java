package View;
import java.sql.*;

public class User {
    private String username;
    private String password;
    private String name;
    public int user_id = 0;
    private String type = "";
    public User(String username,String password){
         this.username=username;
         this.password=password;
    }

    
    public String login(String usernam,String passwor){
     Statement sqlSt; 
     String output = "";
     ResultSet result;
     String SQL = "SELECT * from login_credentials";

     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         String dbURL = "jdbc:mysql://localhost:3306/materials_db";
         Connection dbConnect =  DriverManager.getConnection(dbURL, "root", "godlove1");
         sqlSt = dbConnect.createStatement();//allows SQL to be executed
         result = sqlSt.executeQuery(SQL);
         while(result.next() != false)
         {
              int userid = result.getInt(1);
              String username = result.getString(2);
              String password=result.getString(3);
              String type=result.getString(4);      

             
             if (usernam.equals(username) && password.equals(passwor))
             {
                this.user_id = userid;
                return this.type = type;
            }
        }}
       
     catch(ClassNotFoundException ex){
         System.out.println("DIDNT LOAD JAR");
     }
     catch (SQLException ex){
         System.out.println("SQL IS BAD" +ex.getMessage());
     }

     System.out.println("succesful");
           return "error";  
     }
    
  }
    
  

    

