package task26;

import java.sql.*;
import java.util.ArrayList;

public class Requests {
    public Connection getConnection() {
        String user = "root";
        String password = "root";
        Connection connection = null;
        try {
            String serverName = "localhost";
            String portNumber = "3306";
            String conf = "sys?useSSL=false&serverTimezone=UTC";
            String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + conf;
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Ошибка соединения: \n" + e.getMessage());
        }
        return connection;
    }

    public void createDatabase() {
        Statement statement;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            try {
                statement.executeUpdate(
                        "CREATE SCHEMA test_database;");
                statement.executeUpdate(
                        "CREATE TABLE test_database.data_test(\n" +
                                "  id INT NOT NULL AUTO_INCREMENT,\n" +
                                "  nameParam VARCHAR(45) NULL,\n" +
                                "  valueParam VARCHAR(45) NULL,\n" +
                                "  PRIMARY KEY (id));\n");
            } catch (SQLException e) {
                System.out.println("Ошибка создания БД: \n" + e.getMessage());
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("ошибка в Statement: " + e);
        }
    }


    public void fillDatabase(String name, String value) {
        Statement statement;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(
                    "insert into test_database.data_test (nameParam, valueParam)" +
                            " values ('" + name + "','" + value + "')");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка заполнения данных в БД: \n" + e.getMessage());
        }
    }

    public String getValueParam(String nameParam) {
        Statement statement;
        Connection connection = null;
        ResultSet resultSet;
        String result = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "select valueParam from test_database.data_test " +
                            "where nameParam = '" + nameParam + "'");
            System.out.println("From DataBase: ");
            while (resultSet.next()) {
                result = resultSet.getString(1);
                System.out.println(result);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка загрузки данных из БД: \n" + e.getMessage());
        }
        return result;
    }

    public void dropDatabase() {
        Statement statement;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(
                    "drop schema test_database;");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка удаления БД: \n" + e.getMessage());
        }
    }
}