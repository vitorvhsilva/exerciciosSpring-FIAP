package br.com.fiap.exception;

public class CommitException extends RuntimeException{

    public CommitException() {
        super();
    }

    public CommitException(String message) {
        super(message);
    }
}
