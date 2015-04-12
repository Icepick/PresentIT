package ch.presentit.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.presentit.model.Presentation;
import ch.presentit.model.Slide;
import ch.presentit.model.Template;
import ch.presentit.model.Version;

public class MockedObject {

	public MockedObject() { }
	
	public Version getVersion() {
		Version mock = new Version();
		mock.setName("Present IT - Test");
		mock.setAuthor("Hans Muster");
		mock.setRelease("1.0.1-test");
		mock.setLicense("MIT");
		mock.setCreated(new Date());
		return mock;
	}
	
	public Template getTemplate() {
		Template template = new Template();
		template.setMaster(true);
		return template;
	}
	
	public Slide getSlide() {
		return null;
	}
	
	public Presentation getPresentation(Template template) {
		Presentation mock = new Presentation();
		mock.setTitle("Presentation Test Object");
		mock.setDescription("This presentation object is for testing purposes only");
		mock.setAccess(false);
		//mock.setCreated(new Date());
		mock.setTemplate(template);
		String token = "sd1çaç%&(fDS232AF&(43232S";
		mock.setToken(token);
		List<Slide> slides = new ArrayList<Slide>();
		Slide slide = new Slide();
		slide.setPosition(1);
		slide.setTemplate(template);
		slide.setPresentation(mock);
		slides.add(slide);
		mock.setSlides(slides);	
		return mock;
	}
	
	public List<Presentation> getPresentations() {
		List<Presentation> mock = new ArrayList<Presentation>();
		for (int i = 1; i <= 10; i++) {
			Presentation p = getPresentation(getTemplate());
			p.setTitle("Multiple presentation test objects: " + i);
			mock.add(p);
			System.err.println(p.toString());
		}
		return mock;
	}
}
