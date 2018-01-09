package com.bridgeit.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.todo.model.DocDetails;
import com.bridgeit.todo.service.NoteService;

public class DocController {
	@Autowired
	NoteService noteService;
	
	
	@RequestMapping("/insertDetails")
	public ModelAndView login() {
		//modelMap.put("details",new DocDetails());
		DocDetails details=new DocDetails();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("insertDetails");
		modelAndView.addObject("details",details);
		return modelAndView;
	}
	
	@RequestMapping(value="/savedetails",method = RequestMethod.POST)
	public String saveDetails(DocDetails docdetails) {
		ModelMap modelMap = new ModelMap();
		if(docdetails == null) {
			modelMap.put("docDetails", docdetails);
			return "insertDetails";
		}
		noteService.saveDetails(docdetails);
		modelMap.put("docDetails", docdetails);
		return "redirect:/docDetails";
	}
	
	@RequestMapping(value="/docDetails")
	public ModelAndView docDetails() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("docDetails");
		List<DocDetails> allDoc = noteService.getAllDoc();
		modelAndView.addObject("allDoc", allDoc);
		return modelAndView;
	}
	
	@RequestMapping(value="/viewTax/{id}", method = RequestMethod.GET)
	public ModelAndView viewTax(@PathVariable("id") int id ,HttpServletRequest request) {
		
		DocDetails docDetails =  new DocDetails();
		docDetails.setDocId(id);
		DocDetails taxDetailsById = noteService.getDocDetails(docDetails.getDocId());
		System.out.println("All DocDetails is : "+taxDetailsById);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("taxDetailsById", taxDetailsById);
		modelAndView.setViewName("viewTaxDetails");
		return modelAndView;
	}
}
