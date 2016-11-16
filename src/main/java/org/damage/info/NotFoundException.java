package org.damage.info;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(Class<?> entityClass, String id) {
        super(String.format("Entity %s with id %s not found.",
                            entityClass.getCanonicalName(), id));
    }
}
