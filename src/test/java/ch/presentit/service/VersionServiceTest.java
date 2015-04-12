package ch.presentit.service;

import junit.framework.TestCase;

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

import ch.presentit.model.Version;
import ch.presentit.util.MockedObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testContext.xml")
@Transactional
public class VersionServiceTest extends TestCase {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private VersionService versionService;

	private Version mockedVersion;

	private Version version;

	@Before
	public void setUp() {
		mockedVersion =  new MockedObject().getVersion(); 
	}

	@After
	public void tearDown() {
		
	}

	@Test
	public void saveVersion() {
		version = versionService.save(mockedVersion);
		Assert.notNull(version, "Version should not be null");

		assertEquals(version.getName(), mockedVersion.getName());
		assertEquals(version.getAuthor(), mockedVersion.getAuthor());
		assertEquals(version.getRelease(), mockedVersion.getRelease());
		assertEquals(version.getLicense(), mockedVersion.getLicense());
	}

	@Test
	public void updateVersion() {
		version = versionService.save(mockedVersion);
		Assert.notNull(version, "Version should not be null");

		Version myVersion = versionService.find(version.getId());
		Assert.notNull(myVersion, "My version should not be null");

		String author = "Freddy Cap";
		myVersion.setAuthor(author);
		versionService.update(myVersion, myVersion.getId());

		Version updatedVersion = versionService.find(myVersion.getId());
		assertNotNull(updatedVersion);
		assertEquals(author, updatedVersion.getAuthor());
	}

	@Test
	public void deleteVersion() {
		Version savedVersion = versionService.save(mockedVersion);
		Long tmpID = savedVersion.getId();
		Assert.notNull(savedVersion, "Version should not be null");

		versionService.delete(savedVersion.getId());
		
		Version selectDeletedVersion = versionService.find(tmpID);
		Assert.isNull(selectDeletedVersion, "retrieved version should be removed");
	}

}
