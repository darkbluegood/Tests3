package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import util.ConnectionUtils;

public class List {
	private int id;
	private String title;
	private int fid;
	private String date;
	private String author;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public int getFid(){
		return this.fid;
	}
	public void setFid(int fid){
		this.fid = fid;
	}
	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getAuthor(){
		return this.author;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public ArrayList<List> getList(){
		Connection conn = null;
		String sql = "";
		ResultSet rSet = null;
		ArrayList<List> arrayList = new ArrayList<List>();
		try{
			conn = ConnectionUtils.getConnection();
			Statement statement = conn.createStatement();
			sql = "select * from news_base";
			rSet = statement.executeQuery(sql);
			while(rSet.next()){
				List list = new List();
				list.setId(rSet.getInt("id"));
				list.setFid(rSet.getInt("fid"));
				list.setTitle(rSet.getString("title"));
				list.setDate(rSet.getString("date"));
				list.setAuthor(rSet.getString("author"));
				arrayList.add(list);
			}
			return arrayList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public static void main(String args[]){
		int [] arrayint = {21,3,4,5,6,2};
		Arrays.sort(arrayint);
		System.out.println(Arrays.toString(arrayint));
	}
}
