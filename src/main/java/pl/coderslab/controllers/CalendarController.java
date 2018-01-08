package pl.coderslab.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class CalendarController {
	
//	@Autowired
//	CalendarRepository calendarRepository;
	
	@RequestMapping("/calendar")
	public String calendar() {
		return "calendar";
		
	}

}
