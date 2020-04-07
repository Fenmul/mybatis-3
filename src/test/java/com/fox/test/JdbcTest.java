package com.fox.test;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;

/**
 * 复习 JDBC 的应用
 */
public class JdbcTest {

  // 静态代码块加载驱动
  static {
    try {
      Class.forName(Driver.class.getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void jdbcTest() throws Exception {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
    PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
    preparedStatement.setInt(1, 1);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      String columnName = resultSet.getMetaData().getColumnName(1);
      String columnName2 = resultSet.getMetaData().getColumnName(2);
      String columnName3 = resultSet.getMetaData().getColumnName(3);

      System.out.println(columnName + ":" + resultSet.getString(1));
      System.out.println(columnName2 + ":" + resultSet.getString(2));
      System.out.println(columnName3 + ":" + resultSet.getString(3));
    }

  }
}
