package chapter4.concert;


import org.springframework.stereotype.Component;

@Component
public class RockPerformance implements Performance {

    @Override
    public void perform() {
        System.out.println("Performing rock");
    }
}
