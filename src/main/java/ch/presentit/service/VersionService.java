package ch.presentit.service;

import ch.presentit.model.Version;

public interface VersionService {
	
	Version findByID(Long versionID);
	Version save(Version version);
	Version update(Version version, Long versionID);
	Version delete(Long versionID);

}
