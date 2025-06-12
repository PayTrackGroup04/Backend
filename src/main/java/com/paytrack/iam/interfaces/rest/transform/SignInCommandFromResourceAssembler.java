package com.paytrack.iam.interfaces.rest.transform;

import com.paytrack.iam.domain.model.commands.SignInCommand;
import com.paytrack.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
