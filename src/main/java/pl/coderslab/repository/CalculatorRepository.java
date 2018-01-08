package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Challenge;

public interface CalculatorRepository extends JpaRepository<Challenge, Long> {

}
