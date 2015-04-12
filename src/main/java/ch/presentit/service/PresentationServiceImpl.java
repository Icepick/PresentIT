/**
 * 
 */
package ch.presentit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.presentit.model.Presentation;
import ch.presentit.repository.PresentationRepository;

@Service("presentationService")
public class PresentationServiceImpl implements PresentationService {

	@Autowired
	private PresentationRepository presentationRepository;
	
	@Override
	public Presentation find(Long presentationID) {
		// Returns the presentation for the given presentationID.
		return presentationRepository.findOne(presentationID);
	}

	@Override
	public List<Presentation> findAll() {
		// Returns all presentations.
		return presentationRepository.findAll();
	}

	@Override
	public Page<Presentation> findAll(int index, int limit) {
		// Returns all presentations with paging restriction.
		Sort defaultSort = new Sort(Sort.Direction.ASC, "id");
		return findAll(index, limit, defaultSort);
	}
	
	@Override
	public Page<Presentation> findAll(int index, int limit, Sort sort) {
		// Returns all presentations with paging and sort restriction.
		Pageable pageSpecification = new PageRequest(index, limit, sort);
		return presentationRepository.findAll(pageSpecification);
	}

	@Override
	@Transactional
	public Presentation save(Presentation presentation) {
		// Saves the given presentation object and returns the same.
		return presentationRepository.saveAndFlush(presentation);
	}

	@Override
	@Transactional
	public Presentation update(Presentation presentation) {
		// Updates the presentation with the given presentationID;
        return presentationRepository.save(presentation);
	}

	@Override
	@Transactional
	public Presentation delete(Long presentationID) {
		// Deletes the presentation with the give presentationID and returns the same.
		Presentation deletedPresentation = find(presentationID);
        presentationRepository.delete(presentationID);
        return deletedPresentation;
	}

}
