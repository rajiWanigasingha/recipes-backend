package com.example.recipeBackend.Controller;

import com.example.recipeBackend.Model.FavoriteModel;
import com.example.recipeBackend.Service.CreateFavorite;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PublicKey;
import java.util.Objects;

@RestController
public class CreateNewFavoriteApiController {

    private final CreateFavorite createFavorite;

    public CreateNewFavoriteApiController(CreateFavorite createFavorite) {
        this.createFavorite = createFavorite;
    }

    @PostMapping("/api/createNewFavorite")
    public FavoriteModel CreateNewFavorite(@RequestBody FavoriteModel favoriteModel , @RequestHeader HttpHeaders httpHeaders){

        try {

            String jwtBearerToken = Objects.requireNonNull(httpHeaders.get("authorization")).get(0);

            String jwt = jwtBearerToken.split(" ")[1];

            String secretString = "5pAq6zRyX8bC3dV2wS7gN1mK9jF0hL4tUoP6iBvE3nG8xZaQrY7cW2fA";

            SecretKey authKey = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));

            Jws<Claims> parsed = Jwts.parser().verifyWith(authKey).build().parseSignedClaims(jwt);

            Claims claims = parsed.getPayload();

            System.out.println(claims);

            return createFavorite.CreateNewFavorite(favoriteModel);
        }catch (SignatureException error){
            throw new IllegalArgumentException("Error"+error);
        }
    }

}
