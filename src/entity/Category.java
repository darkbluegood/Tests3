package entity;

import util.ConnectionUtils;
import java.sql.*;
import java.util.ArrayList;






public class Category {
	private int id;
	private int fid;
	private String name;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getFid(){
		return this.fid;
	}
	public void setFid(int fid){
		this.fid = fid;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public ArrayList<Category> getClasses(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Category> categorys = new ArrayList<Category>();
		try{
			conn = ConnectionUtils.getConnection();
			String sql = "select * from news_class";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Category category = new Category();
				category.setName(rs.getString("name"));
				category.setFid(rs.getInt("fid"));
				category.setId(rs.getInt("id"));
				categorys.add(category);
			}
			return categorys;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	public void del(String id,String type){
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		try{
			conn = ConnectionUtils.getConnection();
			if(type.equals("del_p")){
				sql = "delete from news_class where id="+id+" or fid ="+id;
			}
			System.out.println(type.equals("type_s"));
			if(type.equals("del_s")){
				sql = "delete from news_class where id="+id;
			}
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	public void add(String name,String type,String fid){
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		try{
			conn = ConnectionUtils.getConnection();
			if(type.equals("parentclass")){
				 sql = "insert into news_class (name,fid) values('"+name+"',0)";
			}
			if(type.equals("subclass")){
				 sql = "insert into news_class (name,fid) values('"+name+"','"+fid+"')";
			}
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
}
