package mainClasses;

import java.sql.*;


public class con1 {
    private String user="root";
    private String password="";
    private  String  address="jdbc:mysql://localhost/gym" ;

    protected String url="jdbc:oracle:thin:@localhost:1521:orcl";
    private static Connection con;

    public static Connection getCon1() {
        return con;
    }

    public con1() throws SQLException {
      /*  try{ Class.forName(address);
        }
        catch(Exception e){System.out.println("Class not found exception !" + e ); }*/
        try{
                con = DriverManager.getConnection(address,user,password);
                System.out.println("Connecting to database ...... ");
            }catch(SQLException  e)
            { System.out.println("Couldnot connect" + e); }
    }

    public ResultSet displayData_db(String query) throws SQLException {

        System.out.println("Function sends query to display data from  database and return rs");
        Statement stat = con1.getCon1().createStatement();
        ResultSet rs = stat.executeQuery(query)  ;                                        //execute query to display

       // stat.close();
        return rs;

    }

    public int alterData_db(String query) throws SQLException {

        int rs;
        System.out.println("Function sends query to display data from  database and return rs");
        Statement stat = con1.getCon1().createStatement();
        rs = stat.executeUpdate(query);

        //execute update to alter


        return rs;
    }

     //   stat.close();


    public static void close_connection() throws SQLException {
        con.close();
    }

    public static void commit_method() throws SQLException {
        con.commit();
        System.out.println("Commit sent to database");
    }





    //step5 close the connection object




}


