package tcLogin;

import java.sql.Connection;
import java.sql.Statement;
import org.testng.annotations.*;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class database {
	// SQL
	// CREATECR DATABASE testDB;
	// USE testDB;
	//
	// CREATE TABLE CUSTOMERS(
	// ID INT NOT NULL,
	// NAME VARCHAR (20) NOT NULL,
	// AGE INT NOT NULL,
	// ADDRESS CHAR (25) ,
	// SALARY DECIMAL (18, 2),
	// PRIMARY KEY (ID)
	// );
	//
	//
	// INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Ramesh',
	// 32, 'Ahmedabad', 2000.00 );
	//
	// INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (2, 'Khilan',
	// 25, 'Delhi', 1500.00 );
	//
	// INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (3, 'kaushik',
	// 23, 'Kota', 2000.00 );
	//
	// INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (4, 'Chaitali',
	// 25, 'Mumbai', 6500.00 );
	//
	// INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (5, 'Hardik',
	// 27, 'Bhopal', 8500.00 );
	//
	// INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (6, 'Komal',
	// 22, 'MP', 4500.00 );
	//
	// SELECT * FROM CUSTOMERS;

	// Config information
	static Connection con = null;
	private static Statement stmt;
	public static String DB_URL = "jdbc:mysql://localhost:3306/testdb";
	public static String DB_USER = "root";
	public static String DB_PASSWORD = "";

	// SQL queries
	String queryShowCustomers = "SELECT * FROM CUSTOMERS";
	String queryInsertCustomer = "INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (7, 'Hieutran', 01, 'DaNang', 2000.00)";
	String queryUpdateCustomer = "UPDATE Customers SET ADDRESS = 'VN', SALARY= '10000' WHERE ID = 6";
	String queryVerifySalaryWithID = "SELECT SALARY FROM CUSTOMERS WHERE ID = 6";

	@BeforeTest
	public void setUp() throws Exception {
		try {
			// Make the database connection
			// String dbClass = "com.mysql.jdbc.Driver";
			// Class.forName(dbClass).newInstance();
			
			System.out.println("Connecting to Database...");
			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		if (con != null) {
                    System.out.println("Connected to the Database...");
                }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// print all
	@Test(enabled = true)
	public void testqueryShowCustomers() {
		try {
			// Get the contents of table from DB
			ResultSet res = stmt.executeQuery(queryShowCustomers);

			// Print the all result
			while (res.next()) {
				String cusID = res.getString(1);
				String cusName = res.getString(2);
				String cusAge = res.getString(3);
				String cusAddress = res.getString(4);
				String cusSalary = res.getString(5);

				System.out.println(cusID + "\t" + cusName + "\t" + cusAge + "\t" + cusAddress + "\t" + cusSalary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// update column 6
	@Test(enabled = true)
	public void queryUpdateCustomer() {
		try {

			// Update data value
			stmt.executeUpdate(queryUpdateCustomer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// insert column
	@Test(enabled = false)
	public void queryInsertCustomers() {
		try {
			// Insert data value
			stmt.executeUpdate(queryInsertCustomer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// compare value
	@Test(enabled = true)
	public void testqueryShowCustomersWithID() {
		try {
			// Get the contents of table from DB
			ResultSet res = stmt.executeQuery(queryVerifySalaryWithID);

			// Print the all result
			while (res.next()) {
				String cusSalary = res.getString(1);

				if (cusSalary.equals("4500.00")) {
					System.out.println("Pass");
				}
				System.out.println("Failed, the actual value is " + cusSalary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}

}
