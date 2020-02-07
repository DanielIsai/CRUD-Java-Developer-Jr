package com.example.demo.api;

import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@Controller
public class WebPersonController {
	
	private Logger log = LogManager.getLogger(this);
	
	private final PersonService personService;
	private final ControllerFunctions cFunction;
	
	
	@Autowired
	public WebPersonController(PersonService personService, ControllerFunctions cFunction) {
		this.personService = personService;
		this.cFunction = cFunction;
	}
	
	@GetMapping("/Menu")
	public String Menu(Model model) {
		model.addAttribute("UUID",null);
		return "Menu";
	}
	
	@GetMapping("/MenuObtain")
	public String MenuObtain() {
		return "MenuObtain";
	}
	
	@GetMapping("/Create")
	public String Create() {
		return "Create";
	}

	@GetMapping("/UpdateById")
	public String UpdateById() {
		return "UpdatedById";
	}
	
	@GetMapping("/DeleteById")
	public String DeleteById() {
		return "DeleteById";
	}
	
	@GetMapping("/ObtainById")
	public String ObtainById() {
		return "ObtainById";
	}
	
	@GetMapping("/ObtainByName")
	public String ObtainByName() {
		return "ObtainByName";
	}
	
	@GetMapping("/AdvancedSearch")
	public String AdvancedSearch() {
		return "AdvancedSearch";
	}
	
	@GetMapping("/Validation")
	public String Validation(@RequestParam("Page") String page, @RequestParam("UUID") UUID id, Model model) {
		model.addAttribute("Page", page); 	
		model.addAttribute("UUID", id); 	
		return "Validation";
	}
	
	@PostMapping("/detailsCreate")
	public String detailsCreate(@RequestParam("cname") String cname, @RequestParam("cemail") String cemail, @RequestParam("cphone") String cphone,ModelMap modelMap) {
		cFunction.putMethod(modelMap, personService.save(new Person(null,cname,cemail,cphone,true)));
		log.info("Requested Create " + cname);
		return "Status";
	}
	
	@PostMapping("/detailsUpdateById")
	public String detailsUpdateById(@RequestParam("cid") UUID cid, @RequestParam("cname") String cname, @RequestParam("cemail") String cemail, @RequestParam("cphone") String cphone, ModelMap modelMap) {
		cFunction.putMethod(modelMap,personService.update(new Person(cid,cname,cemail,cphone,true)));
		log.info("Requested Update " + cid);
		return "Status";
	}
	
	@PostMapping("/detailsDeleteById")
	public String detailsDeleteById(@RequestParam("cid") UUID cid, Model model) {
		model.addAttribute("Message",personService.hasAddress(cid).getMessage());
		model.addAttribute("Page","DeleteIdAddress");
		model.addAttribute("UUID",cid);
		return "Validation";
	}
	
	@GetMapping("/DeleteIdAddress")
	public String deleteIdAddress(@RequestParam("UUID") UUID cid, Model model) {
		model.addAttribute("message", personService.delete(cid).getMessage());
		return "Status";
	}
	
	@PostMapping("/detailsObtainById")
	public String detailsObtainById(@RequestParam("cid") UUID cid, Model model) {
		cFunction.putObtained(model, personService.findById(cid));
		return "ViewAll";
	}
	
	@PostMapping("/detailsObtainByName")
	public String detailsObtainByName(@RequestParam("cname") String cname, Model model) {
		cFunction.putObtained(model, personService.findByName(cname));
		return "ViewAll";
	}
	
	@PostMapping("/detailsAdvancedSearch")
	public String detailsAdvancedSearch(@RequestParam("cname") String cname, @RequestParam("cemail") String cemail, @RequestParam("cphone") String cphone, Model model) {
		cFunction.putObtained(model, personService.advancedSearch(cname,cemail,cphone));
		return "ViewAll";
	}

	@GetMapping("/ObtainAll")
	public String ObtainAll(Model model) {
		cFunction.putObtained(model, personService.findAll());
		return "ViewAll";
	}
	
	@GetMapping("/DeleteAll")
	public String DeleteAll(@RequestParam("UUID") UUID id, ModelMap modelMap) {
		cFunction.putMethod(modelMap,personService.deleteAll());
		log.info("Requested Delete All");
		return "Status";
	}

	@GetMapping("/Add")
	public String AddAddress(@RequestParam("UUID") UUID uuid, Model model) {
		model.addAttribute("UUID", uuid);
		return "NewAddress";
	}
	
	@PostMapping("/detailsAddress")
	public String detailsAddress(@RequestParam("UUID") UUID id, @RequestParam("cstreet") String cstreet, @RequestParam("cnumber") String cnumber, @RequestParam("ccity") String ccity, @RequestParam("ccountry") String ccountry, Model model) {
		model.addAttribute("message",personService.saveAddress(new Address(null,id,cstreet,cnumber,ccity,ccountry,true)).getMessage());
		return "Status";
	}
	
	@GetMapping("/View")
	public String ViewAddress(@RequestParam("UUID") UUID id, @RequestParam("Name") String name, Model model) {
		model.addAttribute("listAddress",personService.findUUIDAddresses(id).getAddressList());
		model.addAttribute("UUID", id);
		model.addAttribute("Name", name);
		return "ViewAddress";
	}
	
	@GetMapping("/Update")
	public String UpdateAddress(@RequestParam("id") Integer id, Model model) {
		cFunction.putAddress(model, personService.obtainAddress(id).getAddress());
		return "UpdateAddress";
	}
	
	@PostMapping("/detailsAddressUpdate")
	public String detailsAddressUpdate(@RequestParam("UUID") UUID uuid, @RequestParam("id") Integer id, @RequestParam("cstreet") String cstreet, @RequestParam("cnumber") String cnumber, @RequestParam("ccity") String ccity, @RequestParam("ccountry") String ccountry, Model model) {
		model.addAttribute("message",personService.saveAddress(new Address(id,uuid,cstreet,cnumber,ccity,ccountry,true)).getMessage());
		return "Status";
	}
	
	@GetMapping("/Delete")
	public String DeleteAddress(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("message", personService.deleteAddress(id).getMessage());
		return "Status";
	}
	
}
