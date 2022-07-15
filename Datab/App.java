package Datab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/testdb";
        String user="root";
        String password="Mtt0720K@";
        int rowsAffected=0;
        
        try {
        // Wheneveer create a connection, wrap in a try and catch block. to handle exception

        Connection con = DriverManager.getConnection(url, user, password);

        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM test.testtable");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("dept"));
            System.out.println(resultSet.getString("salary"));
            // System.out.println(resultSet.getString("ID"));
            
        }
        
        //create new employee

        // rowsAffected = statement.executeUpdate("INSERT INTO test.testtable(name,dept,salary) VALUES ('Mark', 'Marketing', 5000)");
        // System.out.println("Executed an INSERT statement = Rows affected: "+ rowsAffected);
        
        //UPDATE 
        // rowsAffected =  statement.executeUpdate("UPDATE test.testtable SET salary = 100000 WHERE id =2");
        // System.out.println("Executed an UPDATE statement = Rows affected: "+ rowsAffected);

        // // DELETE
        // rowsAffected =  statement.executeUpdate("DELETE FROM test.testtable WHERE id =3");
        // System.out.println("Executed a DELETE statement = Rows affected: "+ rowsAffected);


        // statement.executeQuery("Select * from")

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }

}   
