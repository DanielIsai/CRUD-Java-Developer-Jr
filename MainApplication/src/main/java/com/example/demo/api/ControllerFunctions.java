package com.example.demo.api;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.example.demo.model.Address;
import com.example.demo.util.PersonResponse;

@Component
public class ControllerFunctions {
	
	public void putMethod(ModelMap modelMap, PersonResponse personResponse) {
		modelMap.put("message", personResponse.getMessage());
	}
	
	public void putObtained(Model model, PersonResponse personResponse) {
		model.addAttribute("listPeople",personResponse.getListResult());
		model.addAttribute("message",personResponse.getMessage());
	}
	
	public void putAddress(Model model, Address address) {
		model.addAttribute("id", address.getId());	
		model.addAttribute("UUID", address.getUuid());
		model.addAttribute("street",address.getStreet());
		model.addAttribute("number",address.getNumber());
		model.addAttribute("city",address.getCity());
		model.addAttribute("country",address.getCountry());
		
	}
}
