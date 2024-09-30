package com.emazon.transaction.adapters.driving.rest.v1.utils;

public class RestConstants {
    private RestConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CODE_OK = "200";
    public static final String CODE_CREATED = "201";
    public static final String CODE_ACCEPTED = "202";
    public static final String CODE_CONFLICT = "409";
    public static final String CODE_BAD_REQUEST = "400";
    public static final String CODE_NOT_FOUND = "404";


    public static final String SWAGGER_VALIDATIONS_DONT_PASS = "Some of the field doesn't pass validations";

public static final String SWAGGER_ADD_SUPPLY_SUMMARY = "add a new supply";
public static final String SWAGGER_ADD_SUPPLY_RESPONSE = "supply has been saved correctly";
public static final String SWAGGER_ADD_SUPPLY_PRODUCT_NOT_FOUND = "Product with the given Id not found";

}
