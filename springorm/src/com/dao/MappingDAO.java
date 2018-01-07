package com.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.pojo.Attribute;
import com.pojo.Document;

public class MappingDAO {
	private JdbcTemplate JdbcTemplate ;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.JdbcTemplate = jdbcTemplate;
	}


	public List<Attribute> getAllAttributes(String docId) {
		 String query="select * from  attributestable ";
		List<Attribute> rows = JdbcTemplate.query(query,ParameterizedBeanPropertyRowMapper.newInstance(Attribute.class));
		return rows;
	}
	
	public List getAllMappedAttributes(String docId) {
		String query="select attributeid from  docs_rel_attributes where docid=?";
		List<Map<String, Object>> rw=JdbcTemplate.queryForList(query,Integer.parseInt(docId));
		List al=new ArrayList();
		for(int a=0;a<rw.size();a++){
			Integer m= (Integer) ((Map) rw.get(a)).get("attributeid");
			al.add(m);
		}
		return al;
	}

	

	public void updateAttributesForDocument(final Integer docId,String attrs) {
		
		String query="delete from  docs_rel_attributes where docid=?";
		 JdbcTemplate.update(query,docId);
		  query="insert into docs_rel_attributes values(?,?)";
		  
		  final String[] batchList=attrs.split(",");
		  
		  JdbcTemplate.batchUpdate(query,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement pStmt, int j)
								throws SQLException {
							pStmt.setInt(1, docId);
							pStmt.setInt(2, Integer.parseInt(batchList[j]));
						}

						@Override
						public int getBatchSize() {
							return batchList.length;
						}
					});
	}
	

}
