package ch.presentit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.presentit.model.Version;

public interface VersionRepository extends JpaRepository<Version, Long> {

}
