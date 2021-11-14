package testcase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.DatabaseConnection;

public class testcase1 extends DatabaseConnection {
	// public WebDriver driver;
	public Properties dataprop;
	// DatabaseConnection connection = new DatabaseConnection();

	@BeforeMethod
	public void createconnection() {
		create_dbconnection();
	}

	@Test
	public void database_validation() throws SQLException, IOException {
		// Properties prop= loadproperties();
		//dataprop = dataproperties();
		//String query = prop.getProperty("customerTable_query");
		// String query="select customer_id, login, bdr.customer.FIRST_NAME, LAST=_NAME,
		// PASSWORD ,PASSWORD_RESET_DATE from bdr.customer where
		// customer_id='13743196'";
		String queryname = "customerTable_query";
		ResultSet results = executequery_dbconnection(queryname);
		while (results.next()) {
			String login = results.getString("LOGIN");
			String first_name = results.getString("FIRST_NAME");
			String city_name=results.getString("CITY");
			System.out.println("Login id is: " + login);
			System.out.println("First Name is " + first_name);
			System.out.println("City is " + city_name);
		}
	}

	@AfterMethod
	public void closeconnection() {
		close_dbconnection();
	}

}
