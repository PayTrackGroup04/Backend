package com.paytrack.iam.application.internal.commandservices;

import com.paytrack.iam.application.internal.outboundservices.hashing.HashingService;
import com.paytrack.iam.application.internal.outboundservices.tokens.TokenService;
import com.paytrack.iam.domain.model.aggregates.User;
import com.paytrack.iam.domain.model.commands.SignInCommand;
import com.paytrack.iam.domain.model.commands.SignUpCommand;
import com.paytrack.iam.domain.services.UserCommandService;
import com.paytrack.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username()))
            throw new RuntimeException("Username already exists");
        var user = new User(command.username(), hashingService.encode(command.password()), command.nombre());
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!hashingService.matches(command.password(), user.getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.getUsername());
        return Optional.of(new ImmutablePair<>(user, token));
    }
}
