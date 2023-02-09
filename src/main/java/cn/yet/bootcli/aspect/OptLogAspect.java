package cn.yet.bootcli.aspect;

import cn.yet.bootcli.annotation.OptLog;
import cn.yet.bootcli.mapper.OperationLogMapper;
import cn.yet.bootcli.model.OperationLog;
import cn.yet.bootcli.util.IpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description OptLogAspect
 */
@Aspect
@Component
public class OptLogAspect {

    @Resource
    private OperationLogMapper operationLogMapper;

    @Pointcut("@annotation(cn.yet.bootcli.annotation.OptLog)")
    public void optLogPointCut() {
    }

    @SneakyThrows
    @AfterReturning(value = "optLogPointCut()", returning = "keys")
    public void saveOptLog(JoinPoint joinPoint, Object keys) {
        ObjectMapper objectMapper = new ObjectMapper();
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes).resolveReference(RequestAttributes.REFERENCE_REQUEST);
        OperationLog operationLog = new OperationLog();
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();
        // 获取操作
        OptLog optLog = method.getAnnotation(OptLog.class);
        // 操作模块
        operationLog.setOptModule(optLog.optModule());
        // 操作类型
        operationLog.setOptType(optLog.operType());
        // 操作描述
        operationLog.setOptDesc(optLog.operDesc());
        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法名
        String methodName = method.getName();
        methodName = className + "." + methodName;
        // 请求方式
        operationLog.setRequestMethod(Objects.requireNonNull(request).getMethod());
        // 请求方法
        operationLog.setOptMethod(methodName);
        // 请求参数
        operationLog.setRequestParam(objectMapper.writeValueAsString(joinPoint.getArgs()));
        // 返回结果
        operationLog.setResponseData(objectMapper.writeValueAsString(keys));
        // 请求用户ID todo
        operationLog.setUserId(1);
        // 请求用户 todo
        operationLog.setNickname("ekko");
        // 请求IP
        String ipAddress = IpUtils.getIpAddress(request);
        operationLog.setIpAddress(ipAddress);
        operationLog.setIpSource(IpUtils.getIpSource(ipAddress));
        // 请求URL
        operationLog.setOptUrl(request.getRequestURI());
        operationLogMapper.insert(operationLog);
    }
}
