package org.example.repository;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String username="root";
    String password="root123";

    public void createUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "Insert INTO students(name,email,age) "+
                    "VALUES('Aaditya','aaditya@gmail.com','21')";

            int result = statement.executeUpdate(sql);
            if(result == 1) {
                System.out.println("Successfully inserted student");
            }
            else {
                System.out.println("Failed to insert student");
            }
            connection.close();
        }

        catch(SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();

        }

    }

    public void updateUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE students SET age ='30'"+
                    "WHERE id = 1";

            int result = statement.executeUpdate(sql);
            if(result == 1) {
                System.out.println("Successfully updated student");
            }
            else {
                System.out.println("Failed to update student");
            }
            connection.close();
        }

        catch(SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();

        }
    }

    public void deleteUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM students WHERE id = 1";

            int result = statement.executeUpdate(sql);
            if(result == 1) {
                System.out.println("Successfully deleted student");
            }
            else {
                System.out.println("Failed to delete student");
            }
            connection.close();
        }

        catch(SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();

        }
    }

    public void getUserById() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT id, name, email, age FROM students WHERE id = 2";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            Student student = mapRow(resultSet);
            System.out.println(student);

            connection.close();
        }

        catch(SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();

        }
    }

    public  void  completeCRUD() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "";


            connection.close();
        }

        catch(SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();

        }

    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;

    }
}
