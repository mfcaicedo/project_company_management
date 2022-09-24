package com.project.company.management.services;

import com.project.company.management.domain.entities.Employee;
import com.project.company.management.domain.entities.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    IEmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("email: "+email);
        Employee employee = null;
        try {
            employee = employeeService.getEmployee(email);
        } catch (Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
        return new MyUserDetails(employee);
    }

}
