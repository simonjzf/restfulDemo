package com.cni.rest.action;



import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.cni.rest.pojo.Employee;


@Controller
public class ClientAction
{
	
	@RequestMapping(method ={RequestMethod.GET}, value = "/client/{id}")
	public String getEmployeeInfoByRest(Model model,@PathVariable String id)
	{
		String url = "http://localhost:8080/RestfulDemo/content/employee/{id}.json";
		RestTemplate restTp = new RestTemplate();

		JSONObject jsonObject = restTp.getForObject(url, JSONObject.class,id);
//		
//		Map <String,String> map = (Map<String,String>)json.get("employee");
//		Iterator iter = map.keySet().iterator();
//		while(iter.hasNext())
//		{
//			String key = (String)iter.next();
//			System.out.println(key);
//			String value = map.get(key);
//			System.out.println(value);
//		}
		
		JSONObject jo = jsonObject.getJSONObject("employee");
		Employee employee = (Employee)JSONObject.toBean(jo, Employee.class);
		System.out.println(employee.getName());
		System.out.println(employee.getEmail());
		System.out.println(employee);
		if(employee != null)
		{
			model.addAttribute("employee",employee);			
		}
		return "employee";


	}
	
//	@RequestMapping(method={RequestMethod.GET,RequestMethod.PUT},value="/client/{id}/update")
//	public String updateEmployeeInfoByRest(Model model,@PathVariable String id)
//	{
//		String name = "Robert.Hu";
//		String email = "Robert.Hu@cni.local";
//		String url = "http://localhost:8080/RestfulDemo/content/employee/update/"+id+"/"+name+"/"+email+".json";
//		if(id!=null)
//		{
//			RestTemplate restTp = new RestTemplate();
//
//			JSONObject jsonObject = restTp.postForObject(url,null,JSONObject.class,id);
//
//			JSONObject jo = jsonObject.getJSONObject("employee");
//			Employee employee = (Employee)JSONObject.toBean(jo, Employee.class);
//			System.out.println(employee.getId());
//			System.out.println(employee.getName());
//			System.out.println(employee.getEmail());
//			System.out.println(employee);
//			if(employee != null)
//			{
//				model.addAttribute("employee",employee);			
//			}
//		}
//		return "employee";
//	}
	
	@RequestMapping(method={RequestMethod.GET,RequestMethod.PUT},value="/client/{id}/update")
	public String updateEmployeeInfoByRestObj(Model model,@PathVariable String id)
	{
		String name = "Robert.Hu";
		String email = "Robert.Hu@cni.local";
		String url = "http://localhost:8080/RestfulDemo/content/employee/update/1";
		if(id!=null)
		{
			RestTemplate restTp = new RestTemplate();
			Employee e = new Employee();
//			e.setId("1");
//			e.setName(name);
//			e.setEmail(email);
			Map<String ,String> map = new HashMap<String,String>();
			map.put("id", "1");
			map.put("name", name);
			map.put("email", email);
			
			restTp.exchange(url, HttpMethod.POST, null, Employee.class, map);
//			restTp.put(url, null,e);
			
//			JSONObject jsonObject = restTp.postForObject(url,null,JSONObject.class,e);

//			JSONObject jo = jsonObject.getJSONObject("employee");
//			Employee employee = (Employee)JSONObject.toBean(jo, Employee.class);
//			System.out.println(employee.getId());
//			System.out.println(employee.getName());
//			System.out.println(employee.getEmail());
//			System.out.println(employee);
//			if(employee != null)
//			{
//				model.addAttribute("employee",employee);			
//			}
		}
		return "employee";
	}
	
	public Object fromJosnToJava(JSONObject json ,Class obj) throws InstantiationException, IllegalAccessException
	{
		Field [] fields = obj.getDeclaredFields();
		Object object = obj.newInstance();
		for(Field field :fields)
		{
			field.setAccessible(true);
			String name = field.getName();
			try
			{
				json.get(name);
			}catch(Exception e)
			{
				continue;
			}
			
			if(json.get(name)!=null && !"".equals(json.get(name)))
			{
				if(field.getType().equals(Long.class) || field.getType().equals(long.class))
				{
					field.setLong(object, Long.parseLong(json.getString(name)));
				}
				else if(field.getType().equals(Integer.class)  || field.getType().equals(int.class))
				{
					field.setInt(object, Integer.parseInt(json.getString(name)));
				}
				else if(field.getType().equals(String.class))
				{
					field.set(object, json.getString(name));
				}
				else if(field.getType().equals(Double.class) || field.getType().equals(double.class))
				{
					field.setDouble(object, Double.parseDouble(json.getString(name)));
				}
				else if(field.getType().equals(java.util.Date.class))
				{
					field.set(object, Date.parse(json.getString(name)));
				}
				else
				{
					continue;
				}
			}
		}
		return object;
		
	}
	
}
