package com.example.postgress1.utils;

import java.util.function.Supplier;

public class ExceptionUtils {

    public static StudentValidationException studentValidationExceptionOf(String message, Supplier<Object[]> argsSupplier) {
        return new StudentValidationException(message, argsSupplier.get());
    }

}
