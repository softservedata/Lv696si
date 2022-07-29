package com.softserve.edu;

import com.mysql.cj.jdbc.CallableStatementWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }
    public void closeStatement() throws SQLException {
        statement.close();
    }
    public void createSchema(String schemaName) throws SQLException {
        statement.execute("CREATE SCHEMA " + schemaName);
    }
    public void dropSchema() throws SQLException {
        statement.execute("DROP SCHEMA " + schemaName);
    }
    public void useSchema() throws SQLException {
        statement.execute("USE SCHEMA " + schemaName);
    }
    public void createTableRoles() throws SQLException {
        statement.execute("CREATE TABLE Roles(id int not NULL primary key, roleName varchar )");
    }
    public void createTableDirections() throws SQLException {
        statement.execute("CREATE TABLE Directions(id int not NULL primary key, directionName varchar )");
    }
    public void createTableProjects() throws SQLException {
        statement.execute("CREATE TABLE Projects(id int not NULL primary key, projectName varchar, directionId int foreign key )");
    }
    public void createTableEmployee() throws SQLException {
        statement.execute("CREATE TABLE Employee(id int not NULL primary key, firstName varchar, roleId int foreign key, projectId int foreign key )");
    }
    public void dropTable(String tableName) throws SQLException {
        statement.execute("DROP TABLE " + tableName);
    }
    public void insertTableRoles(String roleName) throws SQLException {
        statement.execute("INSERT INTO Roles");
    }
    public void insertTableDirections(String directionName) throws SQLException {
        // code
    }
    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        // code
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        // code
    }
    public int getRoleId(String roleName) throws SQLException {
        // code
    }
    public int getDirectionId(String directionName) throws SQLException {
        // code
    }
    public int getProjectId(String projectName) throws SQLException {
        // code
    }
    public int getEmployeeId(String firstName) throws SQLException {
        // code
    }
    public List<String> getAllRoles() throws SQLException {
        // code
    }
    public List<String> getAllDirestion() throws SQLException {
        // code
    }
    public List<String> getAllProjects() throws SQLException {
        // code
    }
    public List<String> getAllEmployee() throws SQLException {
        // code
    }
    public List<String> getAllDevelopers() throws SQLException {
        // code
    }
    public List<String> getAllJavaProjects() throws SQLException {
        // code
    }
    public List<String> getAllJavaDevelopers() throws SQLException {
        // code
    }

}

