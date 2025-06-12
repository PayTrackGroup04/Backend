package com.paytrack.iam.interfaces.rest.transform;

import com.paytrack.iam.domain.model.commands.SignUpCommand;
import com.paytrack.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.password(), resource.nombre());
    }
}
