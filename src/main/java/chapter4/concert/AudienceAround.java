package chapter4.concert;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

@Aspect
public class AudienceAround {

    @Pointcut("execution(** chapter4.concert.Performance.perform(..))")
    public void performance() {
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {

        System.out.println("Silencing cell phones");
        System.out.println("Taking seats");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Demand Refund");
        }
        System.out.println("CLAP CLAP CLAP !!!");

    }
}
