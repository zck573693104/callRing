package com.callRing.Log;

/**
 * Created by kcz on 2017/4/29.
 */
import org.apache.commons.lang.reflect.FieldUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Aspect
public class LogAspect {
    private static final String LOG_SESSION_END = "%1$s, %2$s end.";
    private static final String LOG_SESSION_START = "%1$s, %2$s begin.";
    private static final String METHOD_ID_WITHOUT_NAME = "%s.%s";
    private static final String POINTCUT_PUBLIC_SERVICE = "inLwService() && serviceBean() && anyPublicMethod()";
    private static final String POINTCUT_PUBLIC_CONTROLLER = "anyPublicMethod() && inController() && controllerBean()";
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public LogAspect() {
    }


    // @Pointcut("execution(* com.lwiot.data.service.AppData.TestService.readySend(..)) || execution(* com.lwiot.data.service.AppData.ShowDetailsService.readySend(..)) || execution(* com.lwiot.data.service.AppData.AppDataService.pushMessage(..))")
    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod() {
    }

    @Pointcut("within(com..*) || within(com..*) || within(com..*) || within(com.framework..*) || within(com.compnent..*)")
    public void inLwService() {
    }

    @Pointcut("bean(*Service) || bean(*ServiceImpl) ||bean(ConsumerService) ")
    public void serviceBean() {
    }

    @Pointcut("within(com.*..*)")
    public void inController() {
    }

    @Pointcut("bean(*Controller)")
    public void controllerBean() {
    }

    @Around("anyPublicMethod() && inController() && controllerBean()")
    public Object doControllerLog(ProceedingJoinPoint proceed) throws Throwable {
        String methodIdentifier = this.getMethodIdentifier(proceed);
        long start = System.nanoTime();

        Object var5;
        try {
            logger.debug(String.format("%1$s, %2$s begin.", new Object[]{this.getSessionId(), methodIdentifier}));
            var5 = proceed.proceed();
        } finally {
            logger.debug(String.format("%1$s, %2$s end.", new Object[]{this.getSessionId(), methodIdentifier}));
            logger.debug("METRIC:{} {}", methodIdentifier, Long.valueOf((System.nanoTime() - start) / 1000000L));
        }

        return var5;
    }

    @Around("inLwService() && serviceBean() && anyPublicMethod()")
    public Object doServiceLog(ProceedingJoinPoint proceed) throws Throwable {
        long start = System.nanoTime();
        boolean var11 = false;

        Object var5;
        try {
            var11 = true;
            this.writeBeginLog(proceed);
            Object e = proceed.proceed();
            this.writeEndLog(proceed, e);
            var5 = e;
            var11 = false;
        } catch (Exception var12) {
            this.writeExceptionLog(proceed, var12);
            throw var12;
        } finally {
            if (var11) {
                String methodIdentifier1 = this.getMethodIdentifier(proceed);
                logger.error("METRIC:{} {}", methodIdentifier1, Long.valueOf((System.nanoTime() - start) / 1000000L));
            }
        }

        String methodIdentifier = this.getMethodIdentifier(proceed);
        logger.error("METRIC:{} {}", methodIdentifier, Long.valueOf((System.nanoTime() - start) / 1000000L));
        return var5;
    }

    private void writeBeginLog(JoinPoint joinPoint) {

    }

    private void writeEndLog(JoinPoint joinPoint, Object returnValue) {

    }

    private void writeExceptionLog(JoinPoint joinPoint, Exception e) {
        String methodIdentifier = this.getMethodIdentifier(joinPoint);
        if (!(e instanceof Exception) && !this.isValidateException(e)) {
            logger.error("结束【{}】，结果异常，异常信息为：{}", methodIdentifier, e.getMessage());
            logger.debug(String.format("调用%s时异常结束", new Object[]{methodIdentifier}), e);
        } else {
            logger.debug("结束【{}】，结果异常，异常信息为：{}", methodIdentifier, e.getMessage());
        }

        logger.debug(String.format("%1$s, %2$s end.", new Object[]{this.getSessionId(), methodIdentifier}));
    }

    private String getMethodIdentifier(JoinPoint joinPoint) {
        try {
            return String.format("%s.%s", new Object[]{joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()});
        } catch (Exception var3) {
            return "Get Method Name Exception." + var3.getMessage();
        }
    }

    private String getSessionId() {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        return attrs == null ? "session is null." : attrs.getSessionId();
    }

    private boolean isValidateException(Exception ex) {
        return ex != null && FieldUtils.getField(ex.getClass(), "isLwValidateException", true) != null;
    }
}