package com.cap.anurag.dao;

@SuppressWarnings("serial")
public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String msg){
        super(msg);
    }

    public RecordNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}