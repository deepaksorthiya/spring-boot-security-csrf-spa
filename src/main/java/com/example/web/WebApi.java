package com.example.web;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.Map;

@RestController
public class WebApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebApi.class);


    @GetMapping("/api/principal")
    public Principal principal(Principal principal) {
        LOGGER.info("Principal Object :: {} ", principal);
        return principal;
    }

    @GetMapping("/api/authentication")
    public Authentication authentication(Authentication authentication) {
        LOGGER.info("Authentication Object :: {} ", authentication);
        return authentication;
    }

    @RequestMapping(value = {"/api/user", "/api/user/me"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<User> userAccess(@AuthenticationPrincipal User user) {
        LOGGER.info("You have USER level access USER :: {} ", user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/api/admin")
    public ResponseEntity<User> adminAccess(@AuthenticationPrincipal User user) {
        LOGGER.info("You have ADMIN level access USER ::{} ", user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = {"/server-info"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getRequestInfo(@RequestHeader Map<String, String> httpHeaders, HttpServletRequest httpServletRequest) {
        httpHeaders.put("remoteHost", httpServletRequest.getRemoteHost());
        httpHeaders.put("localAddress", httpServletRequest.getLocalAddr());
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            httpHeaders.put("hostName", localHost.getHostName());
            httpHeaders.put("hostAddress", localHost.getHostAddress());
            httpHeaders.put("canonicalHostName", localHost.getCanonicalHostName());
        } catch (UnknownHostException e) {
            throw new InvalidEndpointRequestException(e.getMessage(), e.getMessage());
        }
        LOGGER.info("request headers :: {}", httpHeaders);
        return httpHeaders;
    }
}