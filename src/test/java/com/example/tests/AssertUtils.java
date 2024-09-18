package com.example.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertUtils {

    /**
     * Checks that a field of an object exists and can be null..
     *
     * @param fieldValue The value of the field to check.
     * @param allowNull Indicates whether the field can be null.
     */
    public static void assertFieldExistsAndCanBeNull(Object fieldValue, boolean allowNull) {
        if (fieldValue == null) {
            assertTrue(allowNull, "The field should not be null since it is expected that it cannot be null.");
        } else {
            assertTrue(true, "The field exists and has a non-null value.");
        }
    }
}

