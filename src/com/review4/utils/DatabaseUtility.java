package com.review4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtility {
	private static Connection conn;
	private static Statement st = null;
	private static ResultSet rset = null;

	public static void createConnection() {

		try {
			conn = DriverManager.getConnection(ConfigReader.getProperty("dbUrl"),
					ConfigReader.getProperty("dbUsername"), ConfigReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> readFromDB(String sqlQuery) {
		List<Map<String, String>> listData = null;

		try {
			st = conn.createStatement();
			rset = st.executeQuery(sqlQuery);
			ResultSetMetaData rsetData = rset.getMetaData();
			listData = new ArrayList<>();

			while (rset.next()) {

				// for every row you need to create a map
				Map<String, String> rowMap = new LinkedHashMap<>();

				for (int i = 1; i <= rsetData.getColumnCount(); i++) {
					rowMap.put(rsetData.getColumnName(i), rset.getObject(i).toString());
				}
				listData.add(rowMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listData;
	}

	public static void closeConnection() {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
