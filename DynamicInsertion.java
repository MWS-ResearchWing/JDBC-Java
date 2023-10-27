import java.sql.*;
import java.util.*;

class DynamicInsertion {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        try{

            // Connection variables
            String url = "jdbc:mysql://localhost:3306/Mainak";
            String user = "root";
            String password = "";

            //calling the connection driver for writing the SQL commands
            Connection con = DriverManager.getConnection(url,user,password);

            if(con.isClosed())
            {
                System.out.println("Connection is closed..");
            }
            else
            {
                System.out.println("Connection is established successfully!");
            }

            // String query to pass SQL commands as a query string
            String q="insert into table1(tName, tCity, tAge) values (?,?,?)";

            //get prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

            System.out.println("Enter a Name");
            String name = sc.nextLine();
            System.out.println("Enter a City");
            String city = sc.nextLine();
            System.out.println("Enter an Age");
            int age = sc.nextInt();

            //set value to query
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setInt(3,age);

            pstmt.executeUpdate();

            // Message on successful data push
            System.out.println("Inserted..");

            // Close connection to end the session
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("There is an error in connection!");

        }

    }
}

