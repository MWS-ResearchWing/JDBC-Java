import java.sql.*;
class Prepared_Statement_Insertion {
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
            String q="insert into table1(tName, tCity, tAge) values (?,?,?)";

            //get prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

            //set value to query
            pstmt.setString(1,"Utkarsh");
            pstmt.setString(2,"Hyderabad");
            pstmt.setInt(3,22);

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

