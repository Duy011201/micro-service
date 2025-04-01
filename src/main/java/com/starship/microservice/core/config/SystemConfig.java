package com.starship.microservice.core.config;

public interface SystemConfig {
    public static final String REX_NUMBER = "^[0-9]*$";
    public static final String REX_EMAIL = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
    public static final String REX_UUID = "^[a-fA-F0-9\\-]{36}$";

    /*
     * Ít nhất một chữ cái in hoa → (?=.*[A-Z])
     * Ít nhất một chữ cái thường → (?=.*[a-z])
     * Ít nhất một chữ số → (?=.*\\d)
     * Ít nhất một ký tự đặc biệt (@$!%*?&) → (?=.*[@$!%*?&])
     * Độ dài tối thiểu 8 ký tự → {8,}
     */
    public static final String REX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
}
