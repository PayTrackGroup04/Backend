package com.paytrack.iam.interfaces.rest.transform;

import com.paytrack.iam.domain.model.aggregates.User;
import com.paytrack.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(), entity.getUsername(), entity.getNombre());
    }
}
