package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entity.DreamRun;
import pl.coderslab.repository.DreamRunRepository;

@Controller
public class DreamRunController {

	@Autowired
	DreamRunRepository dreamRunRepository;
	
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String calculateCheckpoints(Model model) {
//		DreamRun dreamRun = new DreamRun();
//		model.addAttribute("dreamRun", dreamRun);
		return "result";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String calculateCheckpoints(@ModelAttribute DreamRun dreamRun) {
//		dreamRunRepository.save(dreamRun);
		return "redirect:/result";
	}
	
}
