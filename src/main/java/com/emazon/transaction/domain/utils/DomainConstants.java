package com.emazon.transaction.domain.utils;

public class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String  PRODUCT_NOT_FOUND_MESSAGE = "Product with id '%d' not found";

    public static final String PRODUCT_ID_FIELD_NULL_MESSAGE = "Product id cannot be null";
    public static final String QUANTITY_FIELD_NULL_MESSAGE = "Quantity cannot be null";
}
