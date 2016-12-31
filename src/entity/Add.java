package entity;

import java.sql.Connection;
import java.util.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import util.ConnectionUtils;

public class Add {
	public void add(String fid,String title,String content){
		Connection connection = null;
		Statement statement = null;
		String sql = null;

		try{
			connection = ConnectionUtils.getConnection();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String dateValue = simpleDateFormat.format(now);
			sql = "insert into news_base(fid,title,date,author) values("+fid+",'"+title+"','"+dateValue+"','Admin')";
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(statement != null){
				try{
					statement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
