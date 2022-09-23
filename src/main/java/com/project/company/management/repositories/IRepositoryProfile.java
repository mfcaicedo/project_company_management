package com.project.company.management.repositories;

import com.project.company.management.domain.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryProfile extends JpaRepository<Profile, Long> {
}
