package com.claridoug.tccspring.Exceptions;

public class ErroAutenticacao extends RuntimeException{

    public ErroAutenticacao(String message){
        super(message);
    }
}
