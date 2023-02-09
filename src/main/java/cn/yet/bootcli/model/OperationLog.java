package cn.yet.bootcli.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description OperationLog
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("tb_operation_log")
public class OperationLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String optUrl;

    private String optModule;

    private String optType;

    private String optMethod;

    private String optDesc;

    private String requestMethod;

    private String requestParam;

    private String responseData;

    private Integer userId;

    private String nickname;

    private String ipAddress;

    private String ipSource;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
