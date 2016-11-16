package org.damage.info;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException(Class<?> entityClass, String id) {
        super(String.format("Entity %s with id '%s' already present.",
                            entityClass.getCanonicalName(), id));
    }
}
