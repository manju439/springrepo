package com.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.pojo.Document;

public class DocumentsDAO {
	private JdbcTemplate JdbcTemplate ;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.JdbcTemplate = jdbcTemplate;
	}
	
	public int createDocument(Document doc){
		String query="insert into documentstable(name,description) values('"+doc.getName()+"','"+doc.getDescription()+"')";
		return JdbcTemplate.update(query);
	}
	
	public List<Document> getAllDocuments(){
		String query="select * from  documentstable";
		List<Document> rows = JdbcTemplate.query(query,ParameterizedBeanPropertyRowMapper.newInstance(Document.class));
		return rows;
	}

	public int deleteDocuments(String ids) {
		String query="delete from documentstable where id in ("+ids+")";
		return JdbcTemplate.update(query);
	}

}
