package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Challenge;
import pl.coderslab.repository.ChallengeRepository;

public class ChallengeConverter implements Converter<String, Challenge> {

	@Autowired
	ChallengeRepository challengeRepository;
	
	public Challenge convert(String source) {
		
		Challenge challenge = challengeRepository.findOne(Long.parseLong(source));
		
		return challenge;
	}

}
