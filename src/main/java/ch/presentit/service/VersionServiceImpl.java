package ch.presentit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.presentit.model.Version;
import ch.presentit.repository.VersionRepository;

@Service("versionService")
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionRepository versionRepository;

	@Override
	public Version find(Long versionID) {
		// Returns the version for the given versionID.
		return versionRepository.findOne(versionID);
	}

	@Override
	@Transactional
	public Version save(Version version) {
		// Saves the given version object and returns the same.
		return versionRepository.save(version);
	}

	@Override
	@Transactional
	public Version update(Version version, Long versionID) {
		// Updates the version with the given versionID;
		return versionRepository.save(version);
	}

	@Override
	@Transactional
	public Version delete(Long versionID) {
		// Deletes the version with the give versionID and returns the same.
		Version deletedVersion = find(versionID);
		versionRepository.delete(versionID);
		return deletedVersion;
	}

}
