package com.deeparishi.javaapp.corejavaconcepts.jdbc;

import java.sql.*;

public class JavaWithJDBC {

    /**
        1. Download MySQL JDBC Driver
                Go to: MySQL Connector/J download page
                Download the latest .zip or .tar.gz
                Extract it and find the .jar file

        2. Add the JAR to Your Java Project's Classpath
                Right-click your project → Open Module Settings
                Go to Libraries → click +
                Choose Java, then locate and select the .jar file you downloaded
                Click OK to apply
     */

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:33006/rishi_app", "root", "root"
        );

        String query = "SELECT * FROM rishi_app.user";

        Statement statement = con.createStatement();
        ResultSet resultset = statement.executeQuery(query);

        while (resultset.next()) {
            String name = resultset.getString("email");
            String salary = resultset.getString("provider");
            System.out.println("Name: " + name + ", Salary: " + salary);
        }

        resultset.close();
        statement.close();
        con.close();
    }
}
