package fr.simplon.testApi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UndefiniedException extends RuntimeException{
    public UndefiniedException(){
        super();
    }
    public UndefiniedException(String message){
        super(message);
    }
    public UndefiniedException(Throwable exception){
        super(exception);
    }
}
