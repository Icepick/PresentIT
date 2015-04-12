package ch.presentit.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import ch.presentit.model.Presentation;

public interface PresentationService {

	Presentation find(Long presentationID);
	List<Presentation> findAll();
	Page<Presentation> findAll(int index, int limit);
	Page<Presentation> findAll(int index, int limit, Sort sort);
	Presentation save(Presentation presentation);
	Presentation update(Presentation presentation);
	Presentation delete(Long presentationID);
	
}
