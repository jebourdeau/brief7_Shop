package fr.simplon.testApi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidCredentialException extends RuntimeException{
    public InvalidCredentialException(){
        super ();
    }
    public InvalidCredentialException(String message){
        super(message);
    }
    public InvalidCredentialException(Throwable exception){
        super(exception);
    }
    
}
