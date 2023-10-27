import java.sql.*;
class CreateDB {
    public static void main(String []args)
    {
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

            // String query to pass SQL commands as a query string
            String q="create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400) not null, tAge int(20))";

            // Creating a statement to be passed
            Statement stmt = con.createStatement();

            // Pass the query string inside the statement as an update
            stmt.executeUpdate(q);

            // Message on successful data push
            System.out.println("Pushed to  database..");

            // Close connection to end the session
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("There is an error in connection!");

        }

    }
}

