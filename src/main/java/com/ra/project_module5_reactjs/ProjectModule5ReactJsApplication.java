package com.ra.project_module5_reactjs;

import com.ra.project_module5_reactjs.security.jwt.JwtProvider;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;

@SpringBootApplication
public class ProjectModule5ReactJsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProjectModule5ReactJsApplication.class, args);
    }

}
