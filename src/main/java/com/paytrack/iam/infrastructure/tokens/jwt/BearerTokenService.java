package com.paytrack.iam.infrastructure.tokens.jwt;

import com.paytrack.iam.application.internal.outboundservices.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {
    String getBearerTokenFrom(HttpServletRequest request);
    String generateToken(Authentication authentication);
}
