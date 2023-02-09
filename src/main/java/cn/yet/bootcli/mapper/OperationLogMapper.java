package cn.yet.bootcli.mapper;

import cn.yet.bootcli.model.OperationLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description OptLogMapper
 */
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {
}
