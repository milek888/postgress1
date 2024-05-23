package com.example.postgress1.utils;

import static java.lang.String.format;
import static org.apache.commons.lang3.RegExUtils.replaceAll;

public class StudentValidationException extends RuntimeException {

    StudentValidationException(String message, Object ... args) {
        super(format(replaceAll(message, "\\{\\}", "%s"), args));
    }

}
