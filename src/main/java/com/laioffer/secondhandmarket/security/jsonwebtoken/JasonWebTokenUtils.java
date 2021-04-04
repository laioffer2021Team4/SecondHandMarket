package com.laioffer.secondhandmarket.security.jsonwebtoken;

import com.laioffer.secondhandmarket.cache.RedisUtil;
import com.laioffer.secondhandmarket.payload.request.LogoutRequest;
import com.laioffer.secondhandmarket.security.services.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JasonWebTokenUtils {
    private static final Logger logger = LoggerFactory.getLogger(JasonWebTokenUtils.class);
    private static final String REDIS_SET_ACTIVE_SUBJECTS = "active-subjects";

    @Value("${secondhandmarket.app.jwtSecret}")
    private String jwtSecret;

    @Value("${secondhandmarket.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication, String userEmail) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        RedisUtil.INSTANCE.addToCache(REDIS_SET_ACTIVE_SUBJECTS, userEmail);

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserEmailFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return RedisUtil.INSTANCE.isInCache(REDIS_SET_ACTIVE_SUBJECTS, getUserEmailFromJwtToken(authToken));

        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public static void invalidateRelatedTokens(LogoutRequest logoutRequest) {
        RedisUtil.INSTANCE.removeFromCache(REDIS_SET_ACTIVE_SUBJECTS, logoutRequest.getUsername());
    }
}
