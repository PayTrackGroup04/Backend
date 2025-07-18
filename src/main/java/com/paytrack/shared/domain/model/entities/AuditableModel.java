package com.paytrack.shared.domain.model.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditableModel {
    //@Getter
    //@CreatedDate
    //@Column(nullable = false, updatable = false)
    //private Date createdAt;
//
    //@Getter
    //@LastModifiedDate
    //@Column(nullable = false)
    //private Date updatedAt;
}
