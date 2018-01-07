package com.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.pojo.Attribute;

public class AttributesDAO {
	private JdbcTemplate JdbcTemplate ;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.JdbcTemplate = jdbcTemplate;
	}
	
	public int createAttribute(Attribute doc){
		String query="insert into attributestable(name,description) values('"+doc.getName()+"','"+doc.getDescription()+"')";
		return JdbcTemplate.update(query);
	}
	
	public List<Attribute> getAllAttributes(){
		String query="select * from  attributestable";
		List<Attribute> rows = JdbcTemplate.query(query,ParameterizedBeanPropertyRowMapper.newInstance(Attribute.class));
		return rows;
	}

	public int deleteAttributes(String ids) {
		String query="delete from attributestable where id in ("+ids+")";
		return JdbcTemplate.update(query);
	}

}
