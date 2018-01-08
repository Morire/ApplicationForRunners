package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.DreamRun;

public interface DreamRunRepository extends JpaRepository<DreamRun, Long> {

}
