package org.example;

import javax.annotation.PostConstruct;
import java.sql.*;

public class StudentDao {

    private String driver;

    private String url;

    private String userName;


    private String password;

    Connection con;


    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PostConstruct
    public void createStudentDBconnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        con = DriverManager.getConnection(url, userName, password);
    }

    public void selectAllRows() throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from Student");

        while (rs.next()) {
            int studentId = rs.getInt(1);
            String studentName = rs.getString(2);
            double hostelFees = rs.getDouble(3);
            String foodType = rs.getString(4);

            System.out.println(studentId + " " + studentName + " " + " " + " " + hostelFees + " " + foodType);
        }

    }


    public void deleteRows(int studentId) throws ClassNotFoundException, SQLException {

        Statement stmt = con.createStatement();
        stmt.executeUpdate("delete from Student where studentId=" + studentId);

        System.out.println("Record deleted with Id" + studentId);

    }

    public void closeConnection() throws SQLException {
        con.close();
    }
}
