package net.javaguides.springboot.handler;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
