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
import com.dao.AttributesDAO;
import com.pojo.Attribute;
import com.util.SpringUtil;

@Path("/attributes")
public class AttributesController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllAttributes() throws Exception{
		AttributesDAO dao=(AttributesDAO)SpringUtil.getBean("attrDao","Spring-JDBC.xml");
		List<Attribute> result=dao.getAllAttributes();
		return Response.ok(result).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAttribute(Hashtable request) throws Exception{
		String docName=(String) request.get("name");
		String desc=(String) request.get("description");
		Attribute doc=new Attribute();
		doc.setDescription(desc);
		doc.setName(docName);
		
		AttributesDAO dao=(AttributesDAO)SpringUtil.getBean("attrDao","Spring-JDBC.xml");
		int status=dao.createAttribute(doc);
		
		return Response.ok(status).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDocument(Hashtable request) throws Exception{
		String ids=(String) request.get("ids");
		
		AttributesDAO dao=(AttributesDAO)SpringUtil.getBean("attrDao","Spring-JDBC.xml");
		int status=dao.deleteAttributes(ids);
		
		return Response.ok(status).build();
	}
	
}
