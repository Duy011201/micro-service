package com.starship.microservice.core.config;

public interface ResponseConfig {
    public static final String LOGIN_SUCCESS = "Đăng nhập thành công";
    public static final String LOGIN_FAIL = "Đăng nhập thất bại";

    public static final String SING_UP_SUCCESS = "Đăng ký thành công";

    public static final String ADD_SUCCESS = "Thêm thành công";

    public static final String UPDATE_SUCCESS = "Cập nhật thành công";

    public static final String DELETE_SUCCESS = "Xóa thành công";

    public static final String GET_SUCCESS = "Lấy dữ liệu thành công";
    public static final String GET_FAIL = "Lấy dữ liệu thất bại";


    public static final String INVALID_JWT_SIGNATURE = "Chữ ký JWT không hợp lệ";
    public static final String INVALID_JWT_TOKEN = "Token JWT không hợp lệ";
}
