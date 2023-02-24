package cn.yet.bootcli.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description RestResponse
 */
@Data
@Accessors(chain = true)
public class RestResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public static <T> RestResponse<T> success() {
        return success(null);
    }

    public static <T> RestResponse<T> success(T data) {
        return success(RestCode.RC200.getMessage(), data);
    }

    public static <T> RestResponse<T> success(String message) {
        return success(message, null);
    }

    public static <T> RestResponse<T> success(String message, T data) {
        return success(RestCode.RC200.getCode(), message, data);
    }

    public static <T> RestResponse<T> success(int code, String message) {
        return success(code, message, null);
    }

    public static <T> RestResponse<T> success(int code, String message, T data) {
        RestResponse<T> RestResponse = new RestResponse<T>();
        RestResponse.setCode(code);
        RestResponse.setMsg(message);
        RestResponse.setData(data);
        return RestResponse;
    }

    public static <T> RestResponse<T> failed() {
        return failed(RestCode.RC200.getMessage());
    }

    public static <T> RestResponse<T> failed(String message) {
        return failed(message, null);
    }

    public static <T> RestResponse<T> failed(String message, T data) {
        return failed(RestCode.RC500.getCode(), message, data);
    }

    public static <T> RestResponse<T> failed(int code, String message) {
        return failed(RestCode.RC500.getCode(), message, null);
    }

    public static <T> RestResponse<T> failed(int code, String message, T data) {
        RestResponse<T> RestResponse = new RestResponse<T>();
        RestResponse.setCode(code);
        RestResponse.setMsg(message);
        RestResponse.setData(data);
        return RestResponse;
    }
}
