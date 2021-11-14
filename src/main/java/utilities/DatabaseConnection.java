package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import base.BaseTest;

public class DatabaseConnection extends BaseTest {
	public static String url = "jdbc:oracle:thin:@qadb2.aur.test.ziprealty.com:1521:qa2db";
	public static String user = "bdr";
	public static String password = "Zap#QA#2018";
	public Connection con;
	public Statement smt;
	public ResultSet dbresults;
	public Properties dataprop;
	String path = System.getProperty("user.dir");
	public String query;

	public void create_dbconnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed");
			e.printStackTrace();
		}

	}

	public ResultSet executequery_dbconnection(String queryname) throws SQLException, IOException {
		dataprop = dataproperties();
		
		String query = prop.getProperty(queryname);

		// String path2 = System.getProperty("user.dir");
		// FileInputStream fis=new FileInputStream(path1+"//data.properties");
		// prop.load(fis);
		//query = System.getProperty(query);
		smt = con.createStatement();
		dbresults = smt.executeQuery(query);
		return dbresults;
	}

	public void close_dbconnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
