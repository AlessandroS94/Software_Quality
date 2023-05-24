package com.nnt.data.springbootrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceNotFoundException extends RuntimeException {

    // serve a garantire la corretta deserializzazione degli oggetti e a mantenere la
    // compatibilità tra diverse versioni della classe serializzata.
    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);

    public ResourceNotFoundException(String msg) {
        super(msg);
        this.logger.error("Exception"+ msg);
    }
}