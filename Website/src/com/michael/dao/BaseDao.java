package com.michael.dao;

import java.sql.*;

/**
 * Created by Michael Lee on 2016-12-28.
 * 数据库连接基类
 */
public class BaseDao {
    //连接数据库
    public Connection getConnection(){
        Connection connection = null;
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/vehiclemoniter";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    //关闭数据库
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
        //关闭结果集对象
        if (rs != null){
            try {
                rs.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        //关闭编译执行SQL对象
        if (pstmt != null){
            try {
                pstmt.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        //关闭建立连接对象
        if (conn != null){
            try {
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
