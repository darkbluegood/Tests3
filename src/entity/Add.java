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
		Statement statement1 = null;
		String sql = null;
		String sql1 = null;

		try{
			connection = ConnectionUtils.getConnection();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = new Date();
			String dateValue = simpleDateFormat.format(now);
			sql = "insert into news_base(fid,title,date,author) values("+fid+",'"+title+"','"+dateValue+"','Admin')";
			sql1 = "insert into news_content (cid,content) values("+fid+",'"+content+"')";
			statement1 = connection.createStatement();
			statement1.executeUpdate(sql1);
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(statement1 != null){
				try{
					statement1.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
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
