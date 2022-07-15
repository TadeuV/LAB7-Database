package Datab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://127.0.0.1:3306/testdb";
        String user="root";
        String password="Mtt0720K@";
        String rowsAffected;

        Scanner Sc = new Scanner(System.in);

        try {
        
        Connection cone = DriverManager.getConnection(url, user, password);
        Statement statement = cone.createStatement();
        // ResultSet resultSet = statement.executeQuery("SELECT * FROM test.testtable");

            while(true){

                System.out.println("Select an option:");
                System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                System.out.println(" 1) Print all employees:");
                System.out.println(" 2) Add an employee:");
                System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                int opt = Sc.nextInt();

                
                switch (opt) {
                    case 1:
                    //WHY DOES IT HAVE TO BE HERE?
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM test.testtable");
                        while(resultSet.next()){
                            String name = resultSet.getString("name");
                            String dept = resultSet.getString("dept");
                            float sala = resultSet.getFloat("salary");
                            int ID = resultSet.getInt("ID");

                            System.out.println(name+"-"+dept+" ($"+sala+")\n");
                            

                        }
                        System.out.println("- - - - - - - - - - -  - - - -");
                        continue;
                        
                    case 2:
                        Sc.nextLine();
                        
                        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                        System.out.print("Please enter a name: ");
                        String name = Sc.nextLine();
                        System.out.print("Please enter " + name + "`s departament: ");
                        String dept = Sc.nextLine();
                        System.out.print("Please enter " + name + "`s salary: ");
                        float sala = Sc.nextFloat();
                        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                        rowsAffected = "INSERT INTO test.testtable(name,dept,salary) VALUES (?,?,?)";
                        PreparedStatement stat = cone.prepareStatement(rowsAffected);
                        stat.setString(1, name);
                        stat.setString(2, dept);
                        stat.setFloat(3, sala);

                        stat.executeUpdate();
                        System.out.println("\n");
                            
                           
                        continue;
                
                    default:
                    System.out.println("Wrong input detected. Please choose a valid option.");
                        break;
                }
            
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void clrscr(){
		//Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
				System.out.print("\033\143");
		} catch (IOException | InterruptedException ex) {}
	}




}
