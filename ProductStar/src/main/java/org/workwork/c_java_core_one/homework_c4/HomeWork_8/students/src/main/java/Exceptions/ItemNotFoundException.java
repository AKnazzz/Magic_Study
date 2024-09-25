package Exceptions;

import java.io.IOException;

public class ItemNotFoundException extends IOException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
