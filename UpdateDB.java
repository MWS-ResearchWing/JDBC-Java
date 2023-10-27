import java.sql.*;
import java.util.*;

class UpdateDB {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        try{

            // Connection variables
            String url = "jdbc:mysql://localhost:3306/Mainak";
            String user = "root";
            String password = "spsRijuBalur0706";

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
            //Update query
            String q="update table1 set tName=?, tCity=? where tId=?";

            System.out.println("Enter a new name");
            String name = sc.nextLine();

            System.out.println("Enter a new city");
            String city = sc.nextLine();

            System.out.println("Enter the Id");
            int Id = sc.nextInt();

            PreparedStatement pstmt = con.prepareStatement(q);


            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, Id);

            pstmt.executeUpdate();

            System.out.println("Updated!");

            // Close connection to end the session
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("There is an error in connection!");

        }

    }
}

