package org.damage.info;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Class<?> entityClass, String id) {
        super(String.format("Entity %s with id %s not found.", entityClass, id));
    }
}
