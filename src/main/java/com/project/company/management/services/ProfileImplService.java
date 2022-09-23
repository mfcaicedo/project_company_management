package com.project.company.management.services;

import com.project.company.management.domain.entities.Profile;
import com.project.company.management.repositories.IRepositoryProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileImplService implements IProfileService{

    @Autowired
    private IRepositoryProfile repositoryProfile;

    @Override
    public List<Profile> getProfiles() {
        return repositoryProfile.findAll();
    }

    @Override
    public Profile getProfile(Long id) throws Exception {
        Optional<Profile> profileOptional = repositoryProfile.findById(id);
        if(profileOptional.isPresent()){
            return profileOptional.get();
        }else{
            throw new Exception("Perfil No Existe");
        }
    }

    @Override
    public Profile saveProfile(Profile profile_param) {
        return (Profile) repositoryProfile.save(profile_param);
    }

    @Override
    public Profile patchProfie(Profile profile_param, Long id) throws Exception {
        try {
            Profile perfilDb = getProfile(id);

            if(profile_param.getImage() != null){
                perfilDb.setImage(profile_param.getImage());
            }
            if(profile_param.getPhone() != null){
                perfilDb.setPhone(profile_param.getPhone());
            }

            return saveProfile(perfilDb);

        } catch (Exception e) {
            throw new Exception("Perfil no se actualizo, porque no existe");
        }
    }

    @Override
    public String delete(Long id) {
        repositoryProfile.deleteById(id);
        return "Perfil eliminado Exitosamente";
    }
}
