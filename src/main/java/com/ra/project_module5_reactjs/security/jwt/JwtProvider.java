package com.ra.project_module5_reactjs.security.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@Slf4j
public class JwtProvider
{
    @Value("${access_token_expiration}")
    private Integer accessTokenExpiration;
    public final SecretKey secretKey = Jwts.SIG.HS512.key().build();

    public String createToken(UserDetails userDetails)
    {
        Date today = new Date();
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(today)
                .expiration(new Date(today.getTime() + accessTokenExpiration))
                .signWith(secretKey)
                .compact();
    }

    public boolean validateToken(String token)
    {
        try
        {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
            return true;
        } catch (UnsupportedJwtException e)
        {
            throw new UnsupportedJwtException("Unsupported Jwt/ Wrong Jwt Claims");
        } catch (JwtException e)
        {
            log.error("JWT Exception {}", e.getMessage());
            throw new JwtException("Jwt parse failed");
        } catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Jwt is empty or contains only white space");
        }
    }

    public String getUsernameFromToken(String token)
    {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
    }
}
