package com.project.company.management.controllers;

import com.project.company.management.domain.entities.Profile;
import com.project.company.management.services.IServiceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHome {

    @Autowired
    IServiceProfile serviceProfile;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null){
            Profile profile = this.serviceProfile.getOrCreateProfile(principal.getClaims());
        }
        return "index";
    }
}
