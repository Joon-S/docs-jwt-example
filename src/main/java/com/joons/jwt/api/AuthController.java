package com.joons.jwt.api;

import com.joons.jwt.share.JwtContext;
import com.joons.jwt.share.JwtElement;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String getRequest(@RequestParam(required = true) String id) {
        JwtContext context = JwtContext.getInstance();
        String jwt = context.makeJwt(id);
        return jwt;
    }

    @RequestMapping(value = "/response", method = RequestMethod.GET)
    public String getResponse(@RequestParam(required = true) String jws) {
        try {
            JwtContext context = JwtContext.getInstance();
            String id = Jwts.parser().setSigningKey(context.getSigningKey()).parseClaimsJws(jws).getBody().get("id").toString();
            return "Hello " + id;
        } catch (JwtException e) {
            return "Fail";
        }
    }
}
