package pl.coderslab.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Challenge;
import pl.coderslab.entity.Checkpoints;
import pl.coderslab.repository.ChallengeRepository;
import pl.coderslab.repository.CheckpointsRepository;

@Controller
@RequestMapping("/file")
public class UploadFilesToDbController {

	@Autowired
	CheckpointsRepository checkpointRepository;
	
	@Autowired
	ChallengeRepository challengeRepository;
	
	@GetMapping("/babia")
	@ResponseBody
	public String maratonBabia() {
		
		int personId = 1;
		Challenge babiaGora = challengeRepository.findOne(3l);
		
		try {
	        //Gets the CSV file under src/main/resources folder
			File file = new ClassPathResource("csv/Maraton_Babia_Gora.csv").getFile();
			
			try (Scanner scan = new Scanner(file)) {
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] tokens = line.split(";");
					String km9 = tokens[1];
					String km16 = tokens[2];
					String km37 = tokens[3];
					String finish = tokens[4];
					checkpointRepository.saveAndFlush(new Checkpoints(babiaGora, 9.0, km9, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(babiaGora, 16.0, km16, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(babiaGora, 37.0, km37, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(babiaGora, 42.5, finish, personId));
					personId++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("No file");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added to database";
	}
	
	@GetMapping("/bieszczady")
	@ResponseBody
	public String ultraBieszczady() {
		
		int personId = 1;
		Challenge ultraBieszczady = challengeRepository.findOne(4l);
		
		try {
	        //Gets the CSV file under src/main/resources folder
			File file = new ClassPathResource("csv/Ultramaraton_Bieszczadzki.csv").getFile();
			try (Scanner scan = new Scanner(file)) {
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] tokens = line.split(";");
					String km12 = tokens[1];
					String km26 = tokens[2];
					String km38 = tokens[3];
					String finish = tokens[4];
					checkpointRepository.saveAndFlush(new Checkpoints(ultraBieszczady, 12.0, km12, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(ultraBieszczady, 26.0, km26, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(ultraBieszczady, 37.8, km38, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(ultraBieszczady, 52.4, finish, personId));
					personId++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("No file");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added to database";
	}
	
	@GetMapping("/gliwice")
	@ResponseBody
	public String halfmaratonGliwice() {
		
		int personId = 1;
		Challenge halfmaratonGliwice = challengeRepository.findOne(2l);
		
		try {
	        //Gets the CSV file under src/main/resources folder
			File file = new ClassPathResource("csv/Polmaraton_Gliwicki.csv").getFile();
			try (Scanner scan = new Scanner(file)) {
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] tokens = line.split(";");
					String km5 = tokens[1];
					String km10 = tokens[2];
					String km15 = tokens[3];
					String finish = tokens[4];
					checkpointRepository.saveAndFlush(new Checkpoints(halfmaratonGliwice, 5.0, km5, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(halfmaratonGliwice, 10.0, km10, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(halfmaratonGliwice, 15.0, km15, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(halfmaratonGliwice, 21.1, finish, personId));
					personId++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("No file");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added to database";
	}
	
	@GetMapping("/zimowy")
	@ResponseBody
	public String winterBieszczady() {
		
		int personId = 1;
		Challenge winterBieszczady = challengeRepository.findOne(1l);
		
		try {
	        //Gets the CSV file under src/main/resources folder
			File file = new ClassPathResource("csv/Zimowy_Maraton_Bieszczadzki.csv").getFile();
			try (Scanner scan = new Scanner(file)) {
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] tokens = line.split(";");
					String km26 = tokens[1];
					String km34 = tokens[2];
					String km40 = tokens[3];
					String finish = tokens[4];
					checkpointRepository.saveAndFlush(new Checkpoints(winterBieszczady, 26.5, km26, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(winterBieszczady, 34.2, km34, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(winterBieszczady, 40.7, km40, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(winterBieszczady, 44.6, finish, personId));
					personId++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("No file");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added to database";
	}
	@GetMapping("/gold")
	@ResponseBody
	public String goldMaraton() {
		
		int personId = 1;
		Challenge goldMaraton = challengeRepository.findOne(5l);
		
		try {
	        //Gets the CSV file under src/main/resources folder
			File file = new ClassPathResource("csv/Zloty_Maraton.csv").getFile();
			try (Scanner scan = new Scanner(file)) {
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] tokens = line.split(";");
					String km10 = tokens[1];
					String km22 = tokens[2];
					String km33 = tokens[3];
					String finish = tokens[4];
					checkpointRepository.saveAndFlush(new Checkpoints(goldMaraton, 10.5, km10, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(goldMaraton, 22.0, km22, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(goldMaraton, 33.0, km33, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(goldMaraton, 44.9, finish, personId));
					personId++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("No file");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added to database";
	}
	@GetMapping("/butcher")
	@ResponseBody
	public String butcherRun() {
		
		int personId = 1;
		Challenge butcherRun = challengeRepository.findOne(8l);
		
		try {
	        //Gets the CSV file under src/main/resources folder
			File file = new ClassPathResource("csv/Bieg_Rzeznika.csv").getFile();
			try (Scanner scan = new Scanner(file)) {
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					String[] tokens = line.split(";");
					String km17 = tokens[1];
					String km32 = tokens[2];
					String km49 = tokens[3];
					String km66 = tokens[4];
					String finish = tokens[5];
					checkpointRepository.saveAndFlush(new Checkpoints(butcherRun, 16.7, km17, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(butcherRun, 32.1, km32, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(butcherRun, 48.9, km49, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(butcherRun, 65.9, km66, personId));
					checkpointRepository.saveAndFlush(new Checkpoints(butcherRun, 82.1, finish, personId));
					personId++;
				}
			} catch (FileNotFoundException e) {
				System.out.println("No file");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added to database";
	}
}
