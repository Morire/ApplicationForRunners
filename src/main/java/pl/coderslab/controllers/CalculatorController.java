package pl.coderslab.controllers;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entity.Challenge;
import pl.coderslab.entity.Checkpoints;
import pl.coderslab.entity.DreamRun;
import pl.coderslab.repository.CalculatorRepository;
import pl.coderslab.repository.CheckpointsRepository;
import pl.coderslab.repository.DreamRunRepository;

@Controller
public class CalculatorController {

	@Autowired
	CalculatorRepository calculatorRepository;

	@Autowired
	DreamRunRepository dreamRunRepository;

	@Autowired
	CheckpointsRepository checkpointsRepository;

	@ModelAttribute("challenges")
	public List<Challenge> getChallenges() {
		return calculatorRepository.findAll();
	}

	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
	public String calculateCheckpoints(Model model) {
		DreamRun dreamRun = new DreamRun();
		model.addAttribute("dreamRun", dreamRun);
		return "calculator";
	}

	@RequestMapping(value = "/calculator", method = RequestMethod.POST)
	public String reciveCheckpoints(@ModelAttribute DreamRun dreamRun, Model model) {
		Pattern time = Pattern.compile("[0-4][0-9]:[0-5][0-9]");
		Pattern distance = Pattern.compile("[0-9]+\\.[0-9]");
		String distanceStr = Double.toString(dreamRun.getDistance());
		String message = "";
		if (time.matcher(dreamRun.getTime()).matches()) {
			if (distance.matcher(distanceStr).matches()) {
				dreamRunRepository.save(dreamRun);

				List<Checkpoints> checkpoints = checkpointsRepository.findAllByChallengeIdCheckpointDistCheckPointTime(
						dreamRun.getChallenge().getId(), dreamRun.getChallenge().getDistance(), dreamRun.getTime());
				int personId = checkpoints.get(0).getPersonId();
				List<Checkpoints> checkpointPerson = checkpointsRepository.findAllCheckpointsByChallengeIdPersonId(dreamRun.getChallenge().getId(), personId);
				model.addAttribute("checkpoints", checkpointPerson);
				return "result";
			} else {
				message = "Wrong distance format";
			}
		} else {
			message = "Wrong time format";
		}
		model.addAttribute("information", message);

		return "calculator";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String addChallenge(Model model) {
		Challenge challenge = new Challenge();
		model.addAttribute("challenge", challenge);
		return "admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String addChallenge(@ModelAttribute Challenge challenge, Model model) {
		Pattern distance = Pattern.compile("[0-9]+\\.[0-9]");
		Pattern place = Pattern.compile("[A-Z][a-z]+");
		String distanceStr = Double.toString(challenge.getDistance());
		String error = "";
		if (distance.matcher(distanceStr).matches()) {
			if (place.matcher(challenge.getPlace()).matches()) {
				calculatorRepository.save(challenge);
				return "redirect:/admin";
			} else {
				error = "Wrong place format";
			}
		} else {
			error = "Wrong distance format";
		}

		model.addAttribute("information", error);

		return "/admin";
	}

	@RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
	public String editChallenge(@PathVariable long id, Model model) {
		Challenge challenge = calculatorRepository.findOne(id);
		model.addAttribute(challenge);
		return "editChallenge";
	}

	@RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.POST)
	public String editChallenge(@ModelAttribute Challenge challenge) {
		calculatorRepository.save(challenge);
		return "redirect:/admin";
	}

	@RequestMapping("/admin/delete/{id}")
	public String deleteChallenge(@PathVariable long id) {
		Challenge challenge = calculatorRepository.findOne(id);
		calculatorRepository.delete(challenge);
		return "redirect:/admin";
	}

}
