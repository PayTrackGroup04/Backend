package com.paytrack.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}
