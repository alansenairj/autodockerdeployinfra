package com.example.ec;
import com.example.ec.service.MktSentimentService;
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

import static com.example.ec.SentimentApplication.sentiFile.importsenti;


@SpringBootApplication
public class SentimentApplication implements CommandLineRunner {

	@Autowired
	private MktSentimentService mktSentimentService;

	public static void main(String[] args) {
		SpringApplication.run(SentimentApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		importsenti().forEach(t-> mktSentimentService.createTour(
                t.code,
				t.title,
				Integer.parseInt(t.Popularity),
				Integer.parseInt(t.NumberOfOpening)));
		System.out.println("Number of cources =" + mktSentimentService.total());


	}


	static class sentiFile {
		//attributes as listed in the .json file
		private String code, title, Popularity, NumberOfOpening;

		static List<sentiFile> importsenti() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(sentiFile.class.getResourceAsStream("/sentiment.json"),new TypeReference<List<sentiFile>>(){});
		}
	}

}
