package com.itg.supplychainmanagement.util;

import java.sql.*;

public class DBUtil {
    public static Connection connection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "ataugurkaratas", "my-secret-password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try{
            if(connection != null){
                connection.close();
            }if (preparedStatement != null){
                preparedStatement.close();
            }if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
