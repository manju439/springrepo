package com.controllers;

import java.util.Hashtable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.DocumentsDAO;
import com.pojo.Document;
import com.util.SpringUtil;


@Path("/docs")
public class DocsController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllDocuments() throws Exception{
		DocumentsDAO dao=(DocumentsDAO)SpringUtil.getBean("docDao","Spring-JDBC.xml");
		List<Document> result=dao.getAllDocuments();
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDocument(Hashtable request) throws Exception{
		String docName=(String) request.get("name");
		String desc=(String) request.get("description");
		Document doc=new Document();
		doc.setDescription(desc);
		doc.setName(docName);
		
		DocumentsDAO dao=(DocumentsDAO)SpringUtil.getBean("docDao","Spring-JDBC.xml");
		int status=dao.createDocument(doc);
		
		return Response.ok(status).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDocument(Hashtable request) throws Exception{
		String ids=(String) request.get("ids");
		
		DocumentsDAO dao=(DocumentsDAO)SpringUtil.getBean("docDao","Spring-JDBC.xml");
		int status=dao.deleteDocuments(ids);
		
		return Response.ok(status).build();
	}
}
