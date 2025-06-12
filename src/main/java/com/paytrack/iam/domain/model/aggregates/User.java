package com.paytrack.iam.domain.model.aggregates;

import com.paytrack.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
public class User extends AuditableAbstractAggregateRoot<User> {
    @Getter
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @Getter
    @NotBlank
    @Size(max = 120)
    private String password;

    @Getter
    private String nombre;

    public User(){}

    public User(String username, String password, String nombre) {
        this();
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

}
