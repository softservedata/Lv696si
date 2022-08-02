package com.softserve.edu;



import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;
    private PreparedStatement preparedStatement;


    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        statement.execute("CREATE SCHEMA " + schemaName + ";");
    }

    public void dropSchema() throws SQLException {
        statement.execute("DROP SCHEMA " + schemaName + ";");
    }

    public void useSchema() throws SQLException {
        statement.execute("USE " + schemaName + ";");
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
        String sql = "INSERT INTO Roles(roleName) VALUES (?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, roleName);
        preparedStatement.executeUpdate();

    }

    public void insertTableDirections(String directionName) throws SQLException {
        String sql = "INSERT INTO Directions(directionName) VALUES (?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, directionName);
        preparedStatement.executeUpdate();
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        String sql = "INSERT INTO Projects(projectName, directionId) VALUES (?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, projectName);
        preparedStatement.setString(2, directionName);
        preparedStatement.executeUpdate();
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        String sql = "INSERT INTO Employees(firstName, roleName, projectName) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, roleName);
        preparedStatement.setString(3, projectName);
        preparedStatement.executeUpdate();
    }

    public int getRoleId(String roleName) throws SQLException {
        String sql = "SELECT id FROM ROLES WHERE roleName VALUES ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, roleName);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int getDirectionId(String directionName) throws SQLException {
        String sql = "SELECT id FROM DIRECTIONS WHERE directionName VALUES ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, directionName);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int getProjectId(String projectName) throws SQLException {
        String sql = "SELECT id FROM PROJECTS WHERE projectName VALUES ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, projectName);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int getEmployeeId(String firstName) throws SQLException {
        String sql = "SELECT id FROM EMPLOYEES WHERE firstName VALUES ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstName);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public List<String> getAllRoles() throws SQLException {
        String sql = "SELECT * FROM ROLES ";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<String> roles = new LinkedList<>();
        while (rs.next()) {
            roles.add(rs.getString("roleName"));
        }
        return roles;
    }

    public List<String> getAllDirestion() throws SQLException {
        String sql = "SELECT * FROM DIRECTIONS";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<String> directions = new LinkedList<>();
        while (rs.next()) {
            directions.add(rs.getString("directionName"));
        }
        return directions;
    }

    public List<String> getAllProjects() throws SQLException {
        String sql = "SELECT * FROM PROJECTS";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<String> projects = new LinkedList<>();
        while (rs.next()) {
            projects.add(rs.getString("projectName"));
        }
        return projects;
    }

    public List<String> getAllEmployee() throws SQLException {
        String sql = "SELECT * FROM EMPLOYEES";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<String> employees = new LinkedList<>();
        while (rs.next()) {
            employees.add(rs.getString("firstName"));
        }
        return employees;
    }

    public List<String> getAllDevelopers() throws SQLException {
        return null;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        return null;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        return null;
    }

    public static void main(String[] args) throws SQLException {
        MyUtils myUtils = new MyUtils();
        myUtils.createConnection();
        myUtils.createStatement();
        myUtils.createSchema("ferf");
        myUtils.useSchema();
        myUtils.closeStatement();
        myUtils.closeConnection();
        System.out.println("done");
    }
}

