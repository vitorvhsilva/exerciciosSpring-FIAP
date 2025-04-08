package br.com.tranquilotech.aula05.exception;

public class IdNaoEncontradoException extends RuntimeException{
    public IdNaoEncontradoException(String message) {
        super(message);
    }
}
