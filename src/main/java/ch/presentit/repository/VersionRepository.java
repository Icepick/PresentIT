package ch.presentit.repository;

import ch.presentit.model.Version;

public interface VersionRepository {

	Version findByID(Long versionID);
	Version save(Version version);
	Version update(Version version, Long versionID);
	Version delete(Long versionID);
	
}
