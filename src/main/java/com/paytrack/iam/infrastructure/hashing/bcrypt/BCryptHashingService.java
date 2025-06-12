package com.paytrack.iam.infrastructure.hashing.bcrypt;

import com.paytrack.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}

//PasswordEncoder