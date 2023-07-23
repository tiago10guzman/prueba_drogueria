package com.prueba_konex_drogueria.exceptions.global;

public class GlobalDataRequiredException extends RuntimeException {

    public GlobalDataRequiredException() {
        super("Enter all the required data");
    }
}
