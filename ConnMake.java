import java.sql.*;
class ConnMake {
    public static void main(String []args)
    {
        try{
            String url = "jdbc:mysql://localhost:3306/Mainak";
            String user = "root";
            String password = "spsRijuBalur0706";
            Connection con = DriverManager.getConnection(url,user,password);

            if(con.isClosed())
            {
                System.out.println("Connection is closed..");
            }
            else
            {
                System.out.println("Connection is established successfully!");
            }
        }
        catch(Exception e)
        {
            System.out.println("There is an error in connection!");

        }

    }
}

