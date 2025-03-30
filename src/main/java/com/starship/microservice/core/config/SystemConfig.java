package com.starship.microservice.core.config;

public interface SystemConfig {
    public static final String REX_NUMBER = "^[0-9]*$";
    public static final String REX_EMAIL = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
    public static final String REX_UUID = "^[a-fA-F0-9\\-]{36}$";
}
