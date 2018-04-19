package tcLogin;

import java.sql.Connection;
import java.sql.Statement;
import org.testng.annotations.*;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class database {
	// Config information
	static Connection con = null;
	private static Statement stmt;
	public static String DB_URL = "jdbc:mysql://localhost:3306/testdb";
	public static String DB_USER = "root";
	public static String DB_PASSWORD = "";

	// SQL queries
	String queryShowCustomers = "SELECT * FROM CUSTOMERS";
	String queryInsertCustomer = "INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY) VALUES (7, 'Sang', 01, 'AB', 2000.00)";
	String queryUpdateCustomer = "UPDATE Customers SET ADDRESS = 'VN', SALARY= '10000' WHERE ID = 6";
	String queryVerifySalaryWithID = "SELECT SALARY FROM CUSTOMERS WHERE ID = 6";

	@BeforeTest
	public void setUp() throws Exception {
		try {
			// Make the database connection
//			String dbClass = "com.mysql.jdbc.Driver";
//			Class.forName(dbClass).newInstance();

			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	@Test(enabled = false)
	public void queryUpdateCustomer() {
		try {

			// Update data value
			stmt.executeUpdate(queryUpdateCustomer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = false)
	public void queryInsertCustomers() {
		try {
			// Insert data value
			stmt.executeUpdate(queryInsertCustomer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = false)
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
				System.out.println("Fail, the actual value is " + cusSalary);
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
