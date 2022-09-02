package com.iu.start.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	//getConnection
	
	//1.로그인 정보
	//ID, PW, URL, DRIVER
	
	public static Connection getConnection() throws Exception {
		//id
		String user = "hr";
		//pw
		String password = "hr";
		//ip : port
		String url = "jdbc:oracle:thin:@192.168.7.15:1521:xe"; //본인 ip
		//driver명
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. driver 메모리에 로딩
		Class.forName(driver);
		
		//3. DB 연결 후 Connection 객체 반환
		Connection con = DriverManager.getConnection(url, user, password);
		
//		System.out.println(con);
		
		return con;

	}
	public static void disConnection(ResultSet rs, PreparedStatement st, Connection con) throws Exception{
		rs.close();
		st.close();
		con.close();
	}
	
	public static void disConnection(PreparedStatement st, Connection con) throws Exception{
		st.close();
		con.close();
	}
	
}
