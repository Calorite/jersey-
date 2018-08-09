package com.yidi.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.yidi.interfactoty.AboutParametersDAO;
import com.yidi.entity.Parameter;


public class AboutParameterImpl implements AboutParametersDAO {

	@Override
	public Map<Integer, Parameter> getparams() throws SQLException {
		Map<Integer,Parameter> allparamenters=new HashMap<>();
		ResultSet rs;
		DBService helper=new DBService();
		String sql="SELECT * FROM ai_qanda.parameter_tb;";
		rs=helper.executeQueryRS(sql, null);
		while(rs.next()) {
			Parameter p=new Parameter(rs.getInt(1),rs.getInt(2),rs.getString(4),rs.getInt(6));
			allparamenters.put(rs.getInt(1), p);
		}
		return allparamenters;
	}

	@Override
	public boolean checkandpara(String para,String text) {
		if(para.contains("&")) {
			String[] pararray=para.split("&");
			int count=0;
			for(String parameter:pararray) {
				if(parameter.contains("!")){
					if(text.contains(parameter)) {

					}else {
						count++;
					}
				}
				else if(text.contains(parameter)) {
					count++;
				}
			}
			if(count==pararray.length) {
				return true;
			}
		}else {
			if(text.contains(para)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String checkParameterLine(String parameline,String text) {
		if(parameline.contains("/")) {//有多个参
			String[] paramelist=parameline.split("/");
			for(String parameter:paramelist) {
				if(checkandpara(parameter,text)) {
					return parameter;
				}
			}
		}else {
			if(checkandpara(parameline,text)) {
				return parameline;
			}
		}
		return null;
	}

	public Parameter insertParametergetID(String paramenter) throws SQLException{
		DBService helper=new DBService();
		String sql1="INSERT INTO ai_qanda.parameter_tb (paramenter,rank) VALUES (?,0);";

		Connection conn=helper.getConnection();
		PreparedStatement statement=conn.prepareStatement(sql1);
		statement.setString(1, paramenter);
		int rows=statement.executeUpdate();
		if(rows>0){
			String sql2="SELECT LAST_INSERT_ID();";
			ResultSet rs=statement.executeQuery(sql2);
			try {
				if (rs.next()) {
					int id=rs.getInt(1);
					Parameter newparameter=new Parameter(id, 0, paramenter, 0);
					return newparameter;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	public int insertQuestionID(String question,String parameterid,String parameterstr) throws SQLException{
		DBService helper=new DBService();
		String sql1="INSERT INTO ai_qanda.paramenterques_tb (question,chioces,answer,returnparameter) VALUES (?,1,?,?);";
		Connection conn=helper.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql1);
		statement.setString(1, question);
		statement.setString(2, parameterstr);
		statement.setString(3, parameterid);
		int rows=statement.executeUpdate();
		if(rows>0){
			String sql2="SELECT LAST_INSERT_ID();";
			ResultSet rs=statement.executeQuery(sql2);
			try {
				if (rs.next()) {
					int id=rs.getInt(1);
					return id;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return 0;

	}

	public boolean updateParameterquestionid(int parameterid,int questionid) {
		DBService helper=new DBService();
		String sql="UPDATE ai_qanda.parameter_tb SET quesid=? WHERE id=?;";
		Integer[] parame={questionid,parameterid};
		int rows=helper.executeUpdate(sql, parame);
		if (rows>0) {
			return true;
		}
		return false;
	}
}
