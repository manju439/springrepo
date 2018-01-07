package com.controllers;

import java.util.Hashtable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.AttributesDAO;
import com.dao.MappingDAO;
import com.pojo.Attribute;
import com.pojo.Document;
import com.util.SpringUtil;

@Path("/mapping")
public class MapperController {

	 
	@GET
	@Path("/attributes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllAttributes(@PathParam("id")String id) throws Exception{
		MappingDAO dao=(MappingDAO)SpringUtil.getBean("mapDao","Spring-JDBC.xml");
		List<Attribute> result=dao.getAllAttributes(id);
		List mappedattrs=dao.getAllMappedAttributes(id);
		Hashtable retVal=new Hashtable();
		retVal.put("ATTRIBUTES", result);
		retVal.put("MAPPEDATTRIBUTES", mappedattrs);
		return Response.ok(retVal).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAttributesForDocument(@PathParam("id")String docId,Hashtable request) throws Exception{
		MappingDAO dao=(MappingDAO)SpringUtil.getBean("mapDao","Spring-JDBC.xml");
		String Ids=(String)request.get("ids");
		dao.updateAttributesForDocument(Integer.parseInt(docId),Ids);
		return Response.ok().build();
	}
	
}
