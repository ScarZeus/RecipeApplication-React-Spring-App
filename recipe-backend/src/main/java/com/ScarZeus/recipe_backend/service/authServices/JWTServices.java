package com.ScarZeus.recipe_backend.service.authServices;


import com.ScarZeus.recipe_backend.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JWTServices {

    private final UserService userService;

    private final String secretKey="";

    public String  getJwtToken(Map<String,Object> extraClaims , UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+8*60*60*1000))
                .signWith(SignatureAlgorithm.HS256,getSignInKey())
                .compact();

    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String extractEmailFromJwt(String jwtToken) {
        return null;
    }

    public boolean isValidToken(String jwtToken, UserDetails userDetails) {
        return false;
    }
}
