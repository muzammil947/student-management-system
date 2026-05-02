# 🎓 Student Management System (Java + MySQL)

A desktop-based Student Management System developed in Java using Swing, integrated with MySQL for efficient data management. This application provides a user-friendly interface to perform CRUD operations on student records.

---

## 🚀 Features

* ➕ Add Student
* ✏️ Update Student
* ❌ Delete Student
* 📋 View Student Records
* 🔐 Basic Authentication System
* 📊 Manage Courses, Modules, and Teachers

---

## 🛠️ Technologies Used

* Java (Swing)
* MySQL
* JDBC (Java Database Connectivity)

---

## 📂 Project Structure

```
src/
 ├── courseManagementSystem/
 │    ├── Auth.java
 │    ├── Dashboard.java
 │    ├── DbManager.java
 │    ├── StudentView.java
 │    └── ...
 ├── pics/
 └── DP/

sql.sql
```

---

## ⚙️ How to Run

1. Clone the repository:

   ```
   git clone https://github.com/muzammil947/student-management-system.git
   ```

2. Open the project in your IDE (VS Code / Eclipse)

3. Setup MySQL Database:

   * Import the provided `sql.sql` file into MySQL
   * Create database and tables

4. Configure Database Connection:

   * Open `DbManager.java`
   * Update:

     ```
     url = "jdbc:mysql://localhost:3306/your_db_name";
     username = "root";
     password = "your_password";
     ```

5. Run the project:

   * Execute the main class (Dashboard / Auth)

---

## 📸 Screenshots

<img width="1403" height="762" alt="Screenshot 2026-05-02 112418" src="https://github.com/user-attachments/assets/6e7b58be-611c-4532-881e-cc742d75a813" />
<img width="980" height="683" alt="image" src="https://github.com/user-attachments/assets/2cb93b9e-954f-46ce-8d96-7a8a81a21afe" />
<img width="848" height="715" alt="image" src="https://github.com/user-attachments/assets/be57ac57-2efc-49dd-802b-f21553c727ab" />
<img width="993" height="680" alt="image" src="https://github.com/user-attachments/assets/0eda5ae3-8f24-4cd7-9ffd-ee8c79c96770" />
<img width="993" height="293" alt="image" src="https://github.com/user-attachments/assets/20b4b9d7-2cbc-44e1-9afe-e7e18e0e1fec" />






---

## ⚠️ Important Notes

* Make sure MySQL server is running
* Add MySQL Connector JAR in project libraries
* Update database credentials before running

---

## 👨‍💻 Author

**Muzammil**
GitHub: https://github.com/muzammil947

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
