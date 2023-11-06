package configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import patterns.HeroService;

public class HeroMain {
    public static void main(String[] args) {
        var appContext = new AnnotationConfigApplicationContext(HeroConfiguration.class);
        HeroService heroService = appContext.getBean(HeroService.class);
        System.out.println(heroService.getHero(1));
    }
}
