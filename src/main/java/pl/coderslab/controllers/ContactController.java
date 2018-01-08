package pl.coderslab.controllers;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entity.Contact;
import pl.coderslab.repository.ContactRepository;

@RequestMapping("/contact")
@Controller
public class ContactController {

	@Autowired
	ContactRepository contactRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String contactGet(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String contactPost(@ModelAttribute Contact contact, Model model) {
		Pattern name = Pattern.compile("[A-Z][a-z]+");
		Pattern email = Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]{1,})*\\.([a-zA-Z]{2,}){1}$");
		Pattern subject = Pattern.compile("[A-Z][a-z]+");
		String error = "";
		if(name.matcher(contact.getName()).matches()) {
			if(email.matcher(contact.getEmail()).matches()) {
				if(subject.matcher(contact.getSubject()).matches()) {
					contactRepository.save(contact);
					return "redirect:/contact";
				} else {
					error = "Subject should have max 10 characters and start with big letter";
				}
			} else {
				error = "Wrong email adress";
			}
		} else {
			error = "Name should have max 10 characters and start with big letter";
		}
		
		model.addAttribute("information", error);
		
		return "/contact";
	}
	
}
