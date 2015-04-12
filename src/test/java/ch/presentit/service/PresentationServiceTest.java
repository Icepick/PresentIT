package ch.presentit.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import ch.presentit.model.Presentation;
import ch.presentit.model.Template;
import ch.presentit.util.MockedObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testContext.xml")
@Transactional
public class PresentationServiceTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private PresentationService presentationService;

	private Presentation mockedPresentation;
	
	private Presentation presentation;

	@Before
	public void setUp() {
		Template template = new MockedObject().getTemplate();
		mockedPresentation = new MockedObject().getPresentation(template);
	}

	@After
	public void tearDown() {

	}

	@Test
	public void savePresentation() {
		Assert.notNull(mockedPresentation, "Mocked presentation should not be null");

		presentation = presentationService.save(mockedPresentation);
		Assert.notNull(presentation, "Presentation should not be null");

		assertEquals(presentation.getTitle(), mockedPresentation.getTitle());
		assertEquals(presentation.getDescription(), mockedPresentation.getDescription());
		assertEquals(presentation.getToken(), mockedPresentation.getToken());
	}

	@Test
	public void updatePresentation() {
		Assert.notNull(mockedPresentation, "Mocked presentation should not be null");

		presentation = presentationService.save(mockedPresentation);
		Assert.notNull(presentation, "Presentation should not be null");

		Presentation myPresentation = presentationService.find(presentation.getId());
		Assert.notNull(myPresentation, "My presentation should not be null");

		String updatedTitle = "Updated Presentation Test Object";
		String updatedDescription = "This updated presentation object is for testing purposes only";
		
		myPresentation.setTitle(updatedTitle);
		myPresentation.setDescription(updatedDescription);
		
		presentationService.update(myPresentation);
		Presentation updatedPresentation = presentationService.find(myPresentation.getId());
		Assert.notNull(updatedPresentation);
		assertEquals(updatedTitle, updatedPresentation.getTitle());
		assertEquals(updatedDescription, updatedPresentation.getDescription());
	}
	
	@Test
	public void deletePresentation() {
		Assert.notNull(mockedPresentation, "Mocked presentation should not be null");

		presentation = presentationService.save(mockedPresentation);
		Assert.notNull(presentation, "Presentation should not be null");
		
		Long ID = presentation.getId();
		presentationService.delete(presentation.getId());
		
		Presentation deletedPresentation = presentationService.find(ID);
		Assert.isNull(deletedPresentation, "retrieved presentation should be removed");
	}

	@Test
	public void findAllPresentation() {
		List<Presentation> presentations1 = presentationService.findAll();
		assertEquals(presentations1.isEmpty(), true);
		assertEquals(presentations1.size(), 0);

		List<Presentation> mockedPresentations = new MockedObject().getPresentations();
		Assert.notNull(mockedPresentations, "Mocked presentation list should not be null");
		for (Presentation presentation : mockedPresentations) {
			presentationService.save(presentation);
		}
		
		List<Presentation> presentations2 = presentationService.findAll();
		assertEquals(presentations2.isEmpty(), false);
		assertEquals(presentations2.size(), 10);
	}
	
	@Test
	public void findAllPaginatedPresentation() {
		List<Presentation> presentations1 = presentationService.findAll();
		assertEquals(presentations1.isEmpty(), true);
		assertEquals(presentations1.size(), 0);
		
		List<Presentation> mockedPresentations = new MockedObject().getPresentations();
		Assert.notNull(mockedPresentations, "Mocked presentation list should not be null");
		for (Presentation presentation : mockedPresentations) {
			presentationService.save(presentation);
		}
		
		List<Presentation> presentations2 = presentationService.findAll(0, 5).getContent();
		assertEquals(presentations2.isEmpty(), false);
		assertEquals(presentations2.size(), 5);
	}
}
