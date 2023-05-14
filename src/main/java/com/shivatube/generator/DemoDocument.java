package com.shivatube.generator;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.shivatube.document.DocumentGenerator;
import com.shivatube.mapper.DataMapper;
import com.shivatube.model.Employee;

@RestController
public class DemoDocument {

	@Autowired
	private DocumentGenerator documentGenerator;
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	
	@Autowired
	private DataMapper dataMapper;
	
//	@PostMapping(value = "/generate/document")
//    public ResponseEntity<Employee> createInvoice(@RequestBody String json) {
//        try {
//        	Employee trans = DataMapper.mapJsonTotrans(json);
//        	
//            return new ResponseEntity<>(trans, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
	@PostMapping(value = "/generate/document")
	public String generateDocument(@RequestBody Employee trans) {
		
		String finalHtml = null;
		
		Context dataContext = dataMapper.setData(trans);
		
		finalHtml = springTemplateEngine.process("./src/main/resources/templates/template.html", dataContext);
		
		documentGenerator.htmlToPdf(finalHtml);
		
		return "Success";
	}
}
//file object
//extract file contents into string object
//pass the string instead of template
//
//vm template