import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

    //Database Created
    public void createDatabase() throws SQLException {
        //1) Driver Load - This setp not necessary in after jdbc 4

        //2) Connecton Establish
        String url = "jdbc:postgresql://localhost:5432/";
        String userName = "postgres";
        String password = "Nikhil123";
        Connection conn = DriverManager.getConnection(url, userName, password);

        //3) Statement Creation
        Statement stm = conn.createStatement();

        //4) Execute Query
        String query = "create database studentdb";
        boolean bl = stm.execute(query);

        if (!bl) {
            System.out.println("Database Created Successfully");
        } else {
            System.out.println("Error while Creating Database");
        }

        //5) Connection closed
        conn.close();
    }

    //Table Created
    public void createTable() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String userName = "postgres";
        String password = "Nikhil123";
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stm = conn.createStatement();

        String query = "create table student (id SERIAL PRIMARY KEY, name varchar(50), email varchar(50) UNIQUE)";
        stm.execute(query);
        System.out.println("Table Created Successfully");

        conn.close();
    }

    //Data Created
    public void insertData() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String userName = "postgres";
        String password = "Nikhil123";
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stm = conn.createStatement();

        String query = "insert into student (id, name, email) values (1, 'Megha Joshi', 'meghajoshi842@gmail.com'), (2, 'Ritesh Jadhav', 'riteshjadhv59@gmail.com'), (3, 'Ram Kadam', 'ramkadam412@gmail.com'), (4, 'Meera Patil', 'meerapatil486@gmail.com'), (5, 'Nikhil Biradar', 'nikhilbiradar878@gmail.com')";

        stm.execute(query);
        System.out.println("Data Inserted Successfully");
        conn.close();
    }

    //Read Data
    public void readData() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String userName = "postgres";
        String password = "Nikhil123";
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stm = conn.createStatement();

        String query = "select * from student";

        ResultSet rs = stm.executeQuery(query);
        while(rs.next()){
            System.out.println("Id : " + rs.getInt(1));
            System.out.println("Name : " + rs.getString(2));
            System.out.println("Email : " + rs.getString(3));
            System.out.println();
        }
        System.out.println("Data Read Successfully" + rs);
        conn.close();
    }

    //Update Data
    public void updateData() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String userName = "postgres";
        String password = "Nikhil123";
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stm = conn.createStatement();

        String query = "update student set(name, email) = ('Nitin Biradar', 'nitinbiradar76@gmail.com') where id = 5";

        stm.execute(query);
        System.out.println("Data Updated Successfully");
        conn.close();
    }

    //Delete Data
    public void deleteData() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String userName = "postgres";
        String password = "Nikhil123";
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement stm = conn.createStatement();

        String query = "delete from student where id = 5";
        stm.execute(query);
        System.out.println("Data Deleted Successfully");
        conn.close();
    }
}