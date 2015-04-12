package ch.presentit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.presentit.model.Presentation;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

}
