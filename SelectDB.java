import java.sql.*;
import java.util.*;

class SelectDB {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        try{

            // Connection variables
            String url = "jdbc:mysql://localhost:3306/Database_Name";
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
            //Update query


            String q="select * from table1";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while(set.next())
            {
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                System.out.println(id + " : " + name + " : "+city);
            }


            // Close connection to end the session
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("There is an error in connection!");

        }

    }
}

