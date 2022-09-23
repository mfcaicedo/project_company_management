package com.project.company.management.services;

import com.project.company.management.domain.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProfileService {

    public List<Profile> getProfiles();

    public Profile getProfile(Long id) throws Exception;

    public Profile saveProfile(Profile profile_param);

    public Profile patchProfie(Profile profile_param, Long id) throws Exception;

    public String delete(Long id);
}
