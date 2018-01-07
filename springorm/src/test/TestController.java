package test;

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

@Path("/test")
public class TestController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllAttributes() throws Exception{
		System.out.println("+=======================");
		Employee e=new Employee();
		e.setId(100);
		e.setFirstName("Manju");
		e.setLastName("Reddy");
		EmployeeDao dao=(EmployeeDao) SpringUtil.getBean("test", "applicationContext.xml");
		dao.saveEmployee(e);
		
		return Response.ok("WelCome").build();
	}
	
	
	
}
