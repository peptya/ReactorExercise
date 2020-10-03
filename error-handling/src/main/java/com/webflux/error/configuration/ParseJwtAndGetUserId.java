package com.webflux.error.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Base64;

public class ParseJwtAndGetUserId implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    private static final String SIGNING_KEY = "PR@NITKEY";

    private static final byte[] BYTE_ARRAY = SIGNING_KEY.getBytes();

    private static final String SECRET_KEY = Base64.getEncoder().encodeToString(BYTE_ARRAY);

    /**
     * 1. parse the token and return the mono.
     * 2. if error in the parsing return empty mono.
     */
    public static String getUserIdFromToken(String token) {

        String id = null;
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            id = claims.getId();
            if (id == null) {
                throw new JwtProcessingException(HttpStatus.UNAUTHORIZED,
                        "Unauthorize Access! Report To Application Health Monitoring Team");
            }
        } catch (ExpiredJwtException e) {
            throw new JwtProcessingException(HttpStatus.UNAUTHORIZED, "JWT Expired! Please Login To Continue...");
        } catch (SignatureException e) {
            throw new JwtProcessingException(HttpStatus.UNAUTHORIZED, "JWT malformed!");
        }
        return id;

        // return Jwts.parser().setSigningKey(SECRET_KEY)
        // .parseClaimsJws(token).getBody().getId();
    }


    /**
     * 1. from the request header get the token 2. parse the token (write the
     * processing logic in the same class) 3. at the time of parsing if an exception
     * occurs create server response with unauthorize status 4. if parsing is
     * successful get the userid and set it in the request header and forward that
     * request to that particular handler function.
     **/
    @Override
    public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
        String userId = getUserIdFromToken(request.headers().header("token").get(0));
        if (userId instanceof String && userId != null) {
            request.attributes().put("userId", userId);
            return next.handle(request);
        }
        return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
    }

}
