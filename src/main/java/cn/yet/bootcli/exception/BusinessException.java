package cn.yet.bootcli.exception;

import lombok.*;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description BusinessException
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    protected String errorCode;

    protected String errorMsg;

}
