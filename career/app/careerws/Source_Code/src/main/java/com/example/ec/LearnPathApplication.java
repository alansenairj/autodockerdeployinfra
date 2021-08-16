package com.example.ec;

import com.example.ec.domain.Difficulty;
import com.example.ec.service.CareerPathService;
import com.example.ec.service.CourseService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

import static com.example.ec.LearnPathApplication.CoursesFile.importPaths;


@SpringBootApplication
public class LearnPathApplication implements CommandLineRunner {

	@Autowired
	private CareerPathService careerPathService;
	@Autowired
	private CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(LearnPathApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//Create the default tour packages
		careerPathService.createCareerPath("ML", "Machine Learning");
		careerPathService.createCareerPath("AA", "AWS Architect");
		careerPathService.createCareerPath("MA", "MicroService Architect");
		careerPathService.createCareerPath("DO", "Devops");
		careerPathService.createCareerPath("CAE", "Cloud Automation Engineer");
		careerPathService.createCareerPath("FD", "Front-end developer");
		careerPathService.createCareerPath("BD", "Back-end developer");
		careerPathService.createCareerPath("PD", "Python Developer");
		careerPathService.createCareerPath("JD", "Java Developer");
		System.out.println("Number of course paths =" + careerPathService.total());

		importPaths().forEach(t-> courseService.createTour(
				Integer.parseInt(t.coursecode),
				t.title,
				t.description,
				Integer.parseInt(t.price),
				t.Author,
				t.packageType,
				Difficulty.valueOf(t.difficulty)));
		System.out.println("Number of cources =" + courseService.total());


	}

	static class CoursesFile {
		//attributes as listed in the .json file
		private String packageType, coursecode, title, description, price, Author,  difficulty;

		static List<CoursesFile> importPaths() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(CoursesFile.class.getResourceAsStream("/LearnPath.json"),new TypeReference<List<CoursesFile>>(){});
		}
	}

}
