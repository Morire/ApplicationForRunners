package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

}
