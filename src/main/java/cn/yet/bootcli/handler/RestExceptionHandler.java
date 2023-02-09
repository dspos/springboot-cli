package cn.yet.bootcli.handler;

import cn.yet.bootcli.exception.BusinessException;
import cn.yet.bootcli.response.RestCode;
import cn.yet.bootcli.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description RestExceptionHandler
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public RestResponse<String> bizExceptionHandler(BusinessException e) {
        log.error("业务异常！原因是：{}", e.getErrorMsg());
        return RestResponse.failed(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public RestResponse<String> exceptionHandler(NullPointerException e) {
        log.error("空指针异常！原因是:", e);
        return RestResponse.failed(RestCode.RC500.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public RestResponse<String> exceptionHandler(Exception e) {
        log.error("未知异常！原因是:", e);
        return RestResponse.failed(RestCode.RC500.getCode(), e.getMessage());
    }
}
