package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Checkpoints;

public interface CheckpointsRepository extends JpaRepository<Checkpoints, Long> {
	
	@Query("Select c from Checkpoints c where c.challenge.id =:challengeId and c.checkpointDist=:checkpointDist and c.checkpointTime=:checkpointTime")
	List<Checkpoints> findAllByChallengeIdCheckpointDistCheckPointTime(@Param("challengeId") long challengeId, @Param("checkpointDist") double checkpointDist, @Param("checkpointTime") String checkpointTime);
	
	@Query("Select c from Checkpoints c where c.challenge.id =:challengeId and c.personId=:personId")
	List<Checkpoints> findAllCheckpointsByChallengeIdPersonId(@Param("challengeId") long challengeId, @Param("personId") int personId);

	
}
