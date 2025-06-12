package com.paytrack.iam.interfaces.rest.transform;

import com.paytrack.iam.domain.model.aggregates.User;
import com.paytrack.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
