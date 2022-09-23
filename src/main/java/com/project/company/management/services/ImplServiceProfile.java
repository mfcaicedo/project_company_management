package com.project.company.management.services;

import com.project.company.management.domain.entities.Enum_RoleName;
import com.project.company.management.domain.entities.Profile;
import com.project.company.management.repositories.IRepositoryProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ImplServiceProfile implements IServiceProfile{


    @Autowired
    IRepositoryProfile repositoryProfile;

    /**
     * Servicio para listar todas los perfiles
     * @return lista de los perfiles guardadas en la DB
     */
    @Override
    public List<Profile> findAll() {
        return (List<Profile>) repositoryProfile.findAll();
    }

    @Override
    public Profile getOrCreateProfile(Map<String, Object> profileData) {

        String name = (String) profileData.get("nickname");
        Profile profile = findByUserName(name);
        if(profile == null){
            String image = (String) profileData.get("picture");
        }

        return profile;
    }



    @Override
    public Profile create(Profile profile) {

        return repositoryProfile.save(profile);
    }

    @Override
    public Profile findByUserName(String userName) {
        return repositoryProfile.findByUserName(userName);
    }
    /*
    //ME SIRVE PARA LA BUSQUEDA DEL USUARIO
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = repositoryProfile.findByUserName(username);
        if(profile==null){
            throw new UsernameNotFoundException("Usuario o password invalidos");
        }

        return new User(profile.getUserName(), profile.getPassword(), mapearAutoridadesARoles(Collections.singleton(profile.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesARoles(Collection<Enum_RoleName> roles){
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getEventStatusById(role.getValue()).toString())).collect(Collectors.toList());
    }

     */
}
