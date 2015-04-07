package ch.presentit.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ch.presentit.model.Version;

@Repository("versionRepository")
public class VersionRepositoryImpl implements VersionRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Version findByID(Long versionID) {
		// Returns the version for the given versionID.
		return em.find(Version.class, versionID);
	}

	@Override
	public Version save(Version version) {
		// Saves the given version object and returns the same.
        em.persist(version);
        em.flush();
        return version;
	}

	@Override
	public Version update(Version version, Long versionID) {
		// Updates the given version with new data.
		version.setId(versionID);
        Version updatedVersion = em.merge(version);
        em.flush();
        return updatedVersion;
	}

	@Override
	public Version delete(Long versionID) {
		// Deletes the version with the given versionID.
        Version deletedVersion = em.find(Version.class, versionID);
        em.remove(deletedVersion);
        em.flush();
        return deletedVersion;
	}

}
