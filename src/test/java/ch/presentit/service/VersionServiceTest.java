package ch.presentit.service;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import ch.presentit.model.Version;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testContext.xml")
public class VersionServiceTest extends TestCase {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private VersionService versionService;

	private Version mockedVersion;

	private Version version;

	@Before
	public void setUp() {
		mockedVersion = new Version();
		mockedVersion.setName("Present IT - Test");
		mockedVersion.setAuthor("Hans Muster");
		mockedVersion.setRelease("1.0.1-test");
		mockedVersion.setLicense("MIT");
		mockedVersion.setCreated(new Date());
	}

	@After
	public void tearDown() {
		if (version != null)
			versionService.delete(version.getId());
	}

	@Test
	public void saveVersion() {
		version = versionService.save(mockedVersion);
		Assert.notNull(this.version, "Version should not be null");

		assertEquals(version.getName(), mockedVersion.getName());
		assertEquals(version.getAuthor(), mockedVersion.getAuthor());
		assertEquals(version.getRelease(), mockedVersion.getRelease());
		assertEquals(version.getLicense(), mockedVersion.getLicense());
	}

	@Test
	public void updateVersion() {
		version = versionService.save(mockedVersion);
		Assert.notNull(this.version, "Version should not be null");

		Version myVersion = versionService.findByID(version.getId());
		Assert.notNull(myVersion, "My version should not be null");

		String author = "Freddy Cap";
		myVersion.setAuthor(author);
		versionService.update(myVersion, myVersion.getId());

		Version updatedVersion = versionService.findByID(myVersion.getId());
		assertNotNull(updatedVersion);
		assertEquals(author, updatedVersion.getAuthor());
	}

	@Test
	public void deleteVersion() {
		Version savedVersion = versionService.save(this.mockedVersion);
		Long tmpID = savedVersion.getId();
		Assert.notNull(savedVersion, "Version should not be null");

		Version deletedVersion = versionService.delete(savedVersion.getId());
		Assert.notNull(deletedVersion, "deleted Version should be valid");
		
		Version selectDeletedVersion = versionService.findByID(tmpID);
		Assert.isNull(selectDeletedVersion, "retrieved version should be removed");
	}

}
