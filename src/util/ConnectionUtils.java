package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/website?useUnicode=true&characterEncoding=UTF8";
	private static final String username = "root";
	private static final String password = "123";
	private static Connection conn = null;
	
	static{
		try{
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		if(conn == null){
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String args[]){
		try{
			Connection conn = ConnectionUtils.getConnection();
			if(conn == null){
				System.out.println("连接失败");
			}else{
				System.out.println("连接成功");
			}
		}catch(Exception e){
			
		}
		
	}
}
