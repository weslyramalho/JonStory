package com.wr.estoqueapi.exceptions;

public class ClienteRequestException extends Exception{
    public ClienteRequestException(String mensagem){
        super(mensagem);
    }
}
