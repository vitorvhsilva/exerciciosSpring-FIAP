package br.com.fiap.exception;

public class IdNaoEncontradoException extends RuntimeException {

    public IdNaoEncontradoException() {
        super("Id não encontrado!");
    }

    public IdNaoEncontradoException(String message) {
        super(message);
    }
}
