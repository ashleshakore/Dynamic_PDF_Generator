package com.shivatube.mapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.shivatube.model.Employee;

@Service
public class DataMapper {

	public Context setData(Employee transaction_data) {
		
		Context context = new Context();
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("employees", transaction_data);
		
		context.setVariables(data);
		
		return context;
	}
//	private static final ObjectMapper mapper = new ObjectMapper();
//
//    public static Employee mapJsonTotrans(String json) throws IOException {
//        return mapper.readValue(json, Employee.class);
//    }
}
