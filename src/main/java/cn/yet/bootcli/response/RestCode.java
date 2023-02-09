package cn.yet.bootcli.response;

import lombok.Getter;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description RestCode
 */
public enum RestCode {

    RC200(200, "操作成功"),
    RC500(500, "操作失败"),

    INVALID_TOKEN(2001, "访问令牌不合法"),
    ACCESS_DENIED(2003, "没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式");

    @Getter
    private final int code;

    @Getter
    private final String message;

    RestCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
