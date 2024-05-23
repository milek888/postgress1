package com.example.postgress1.utils;

import static com.example.postgress1.utils.ExceptionUtils.studentValidationExceptionOf;

public class EnsureUtils {

    public static void ensureThat(boolean condition, String errorMessage, Object ...args) {
        if(!condition) {
            throw studentValidationExceptionOf(errorMessage, () -> args);
        }
    }

}
