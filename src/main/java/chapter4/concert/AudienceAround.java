package chapter4.concert;


import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

@Aspect
public class AudienceAround {

    @Pointcut("execution(** chapter4.concert.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CKAP CLAP !!!");
    }

    @AfterThrowing("performance()")

    public void demandRefund() {

        System.out.println("Demanding refund");
    }

    @Bean
    public Performance attendPerformance() {
        return new RockPerformance();
    }


}
