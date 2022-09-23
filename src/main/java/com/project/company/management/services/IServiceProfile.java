package com.project.company.management.services;

import com.project.company.management.domain.entities.Enterprise;
import com.project.company.management.domain.entities.Profile;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface IServiceProfile {

    /**
     * Listar todas los perfiles creados
     * @return
     */
    public List<Profile> findAll();

    public Profile getOrCreateProfile(Map<String, Object> profileData);

    public Profile create(Profile profile);

    public Profile findByUserName(String userName);

}
