package courseManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DbManager {
    private Connection conn;
    private Statement stmt;
    private static DbManager instance;
    public static DbManager getInstance() throws Exception {
        if (instance == null) {
            try {
                instance = new DbManager("jdbc:mysql://localhost:3306", "root", "12345");
            } catch (Exception e) {
                System.out.println("An error occurred while connecting to the database: " + e.getMessage());
            }

        }
        return instance;
    }

    public DbManager(String path, String username, String password) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // <-- Add this line
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        this.conn = DriverManager.getConnection(path, username, password);
        this.stmt = conn.createStatement();
        System.out.println("Connected to database");
        createDatabase("course_management_system");
        String query = "USE course_management_system";
        stmt.executeUpdate(query);
        createPopulateTable();
    }

    public void createDatabase(String dbName) throws SQLException {
        try {
            stmt.executeUpdate("CREATE DATABASE " + dbName);
            System.out.println("Database created!");
        } catch (SQLException e) {
            if (e.getErrorCode() == 1007)
                System.out.println("Database exists!");
            else
                throw e;
        }
    }
    
    private void createPopulateTable() throws SQLException {
        try {
        	String createAuthTableSQL = """
					CREATE TABLE auth (
						id INT AUTO_INCREMENT PRIMARY KEY,
						name VARCHAR(100),
						email VARCHAR(100),
						password VARCHAR(100),
						role VARCHAR(25),
						phoneNo VARCHAR(25),
						course VARCHAR(20))
					""";
        	stmt.executeUpdate(createAuthTableSQL);
            String coursesTableSQL = """
					CREATE TABLE courses (
						course_id INT PRIMARY KEY AUTO_INCREMENT,
						course_name VARCHAR(100) NOT NULL)
					""";
			stmt.executeUpdate(coursesTableSQL);
			String insertIntoCoursesSQL = """
					INSERT INTO courses(course_name) VALUES
					  ('OOP'),
					  ('DB'),
					  ('STS');
					""";
			stmt.executeUpdate(insertIntoCoursesSQL);
			String modulesTableSQL = """
					CREATE TABLE modules (
						module_id INT PRIMARY KEY AUTO_INCREMENT,
						module_name VARCHAR(100) NOT NULL,
						module_type VARCHAR(100) NOT NULL,
						course_id INT NOT NULL,
						FOREIGN KEY (course_id) REFERENCES courses(course_id))
					""";
			stmt.executeUpdate(modulesTableSQL);
			String insertIntoModulesSQL = """
					INSERT INTO modules (module_name,module_type, course_id) VALUES
						('Computational Mathematics','core', 1),
						('Fundamentals of Computing','core', 1),
						('Internet Software Architecture','core', 1),
						('Academic Skills and Team-Based Learning','optional', 1),
						('Embedded System Programming','core', 1),						
						('Introductory Programming and Problem Solving','core', 1),
						('Database','optional', 1),
						('OOP','core', 1),
						('21st Century Management','core', 2),
						('Preparing for Success at University','optional', 2),
						('Principles of Business','core', 2),
						('Project Based Learning','core', 2),
						('The Digital Business','core', 2),
						('The Innovative Business','optional', 2),
						('The Responsible Business','optional', 2),
						('The Sustainable Business','core', 2),
						('Strategic Global Marketing','core', 3),
						('Financial Decision Making','core', 3),
						('The Masters Research Project I','optional', 3),
						('The Masters Professional Project II','optional', 3),
						('Contemporary Issues in Human Resources An International Perspective','core', 3),
						('Strategic Operations Management','core', 3),
						('The Masters Professional Project II','optional', 3),
						('The Masters Professional Project II','optional', 3)
					""";
			stmt.executeUpdate(insertIntoModulesSQL);
			String resultTableSQL = """
					CREATE TABLE results (
					    student_id INT NOT NULL,
					    module_id INT NOT NULL,
					    marks INT NOT NULL,
					    FOREIGN KEY (student_id) REFERENCES auth(id),
					    FOREIGN KEY (module_id) REFERENCES modules(module_id),
					    PRIMARY KEY (student_id, module_id))
					""";
			stmt.executeUpdate(resultTableSQL);
        
            System.out.println("Tables were created and populated successfully!");
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 1050)
                System.out.println("Table exists!");
            else
                throw e;
        }
        
        // Insert Muslim names into auth table
        String insertIntoAuthSQL = """
            INSERT INTO auth (name, email, password, role, phoneNo, course) VALUES
                ('Ahmed Ali', 'ahmed.ali@gmail.com', 'pass123', 'student', '03001234567', 'OOP'),
                ('Fatima Zahra', 'fatima.zahra@gmail.com', 'pass456', 'student', '03007654321', 'DB'),
                ('Yasir Khan', 'yasir.khan@gmail.com', 'pass789', 'teacher', '03009876543', 'STS'),
                ('Ayesha Siddiqui', 'ayesha.siddiqui@gmail.com', 'pass321', 'student', '03005432198', 'OOP'),
                ('Bilal Ahmed', 'bilal.ahmed@gmail.com', 'pass654', 'student', '03002345678', 'DB');
            """;
        stmt.executeUpdate(insertIntoAuthSQL);
        
        // Insert sample results for these students (assuming module_id 1,2,3 exist)
        String insertIntoResultsSQL = """
            INSERT IGNORE INTO results (student_id, module_id, marks) VALUES
                (1, 1, 85),
                (1, 2, 78),
                (2, 1, 90),
                (2, 3, 88),
                (4, 2, 92),
                (5, 3, 80);
            """;
        stmt.executeUpdate(insertIntoResultsSQL);
    }
    

    public Connection getConnection() {
        return conn;
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
    
    
}


