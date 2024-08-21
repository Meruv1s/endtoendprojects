package com.sumanth.backendconcepts.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)// 404 error
public class UserNotFoundException  extends RuntimeException{
  String s;

    public UserNotFoundException(String s)
    {
      super(s);
   this.s=s;
    }

}
