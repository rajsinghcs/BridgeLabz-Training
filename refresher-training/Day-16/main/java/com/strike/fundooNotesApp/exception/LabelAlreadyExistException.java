package com.strike.fundooNotesApp.exception;

public class LabelAlreadyExistException extends RuntimeException{
    public LabelAlreadyExistException(String message){
        super(message);
    }
}
