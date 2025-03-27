package com.project.taskmanagement.security.jwt;


import com.project.taskmanagement.security.services.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value( "${jwt.expiration}")
    private int jwtExpiration;

    public String generateJwtToken(Authentication authentication) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

        return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000)).signWith(SignatureAlgorithm.ES256, jwtSecret).compact();
    }
    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e){
            logger.error("invalid JWT token",e);

        }catch (ExpiredJwtException e){
            logger.error("Expired JWT token -> Message{}:",e);
        }catch (UnsupportedJwtException e){
            logger.error("Unsupported JWT Token -> Message {}:",e);

        }catch (IllegalArgumentException e){
            logger.error("JWT Token -> Message {}:",e);
        }

        return false;
    }
    public String getUserNameFromJwtToken(String authToken){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody().getSubject();
    }
}
