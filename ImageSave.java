import java.sql.*;
import java.io.*;

class ImageSave {
    public static void main(String []args)
    {

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
            String q = "insert into images(pic) values(?)";

            PreparedStatement pstmt = con.prepareStatement(q);

            FileInputStream fis = new FileInputStream("C:\\Users\\maina\\OneDrive\\Desktop\\Java\\sample.jpg");

            pstmt.setBinaryStream(1,fis,fis.available());

            pstmt.executeUpdate();

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


