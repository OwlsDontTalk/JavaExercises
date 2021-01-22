package lesson_2;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;


    public static void main(String[] args) throws SQLException {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        createTable();
        //addUsers();
        //deleteUsers(2);
        //insertUser("Bob5", 67);
        selectUsers();

        disconnect();
    }




    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = connection.createStatement();

    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() throws SQLException {
       stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students_new (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "score TEXT)");
    }

    public static void addUsers() throws SQLException {
        stmt.executeUpdate("INSERT INTO students_new (name, score) VALUES ('Bob1', 55)");
        stmt.executeUpdate("INSERT INTO students_new (name, score) VALUES ('Bob2', 56)");
        stmt.executeUpdate("INSERT INTO students_new (name, score) VALUES ('Bob3', 65)");
        stmt.executeUpdate("INSERT INTO students_new (name, score) VALUES ('Bob4', 66)");
    }

    private static void deleteUsers(int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM students_new WHERE id = " + id);
    }

    private static void insertUser(String username, int score) throws SQLException {
        stmt.executeUpdate("INSERT INTO students_new (name, score) VALUES ('" + username + "'," + score + ")");
    }

    private static void selectUsers() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM students_new" );
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
    }

}
