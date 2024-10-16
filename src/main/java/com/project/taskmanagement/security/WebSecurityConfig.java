package com.project.taskmanagement.security;



import com.project.taskmanagement.security.jwt.JwtAuthEntryPoint;
import com.project.taskmanagement.security.jwt.JwtAuthTokenFilter;
import com.project.taskmanagement.security.services.UserDetailsServiceImpl;
import com.project.taskmanagement.utils.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig {


}
