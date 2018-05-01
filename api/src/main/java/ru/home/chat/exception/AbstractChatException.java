package ru.home.chat.exception;

public class AbstractChatException extends RuntimeException {

    public AbstractChatException() {

    }

    AbstractChatException(final String message) {
        super(message);
    }

    AbstractChatException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
