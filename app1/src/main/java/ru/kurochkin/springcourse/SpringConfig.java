package ru.kurochkin.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //обозначает, что это класс-конфигураци для Spring. Замена applicationContext.xml
@ComponentScan("ru.kurochkin.springcourse") // <context:component-scan base-package="ru.kurochkin.springcourse"/>
@PropertySource("classpath:musicPlayer.properties") //внедрение значений из вненшнего файла
public class SpringConfig {

    //ручное внедрение зависимостей
    //<bean id="musicBean"
    //      class="ru.kurochkin.springcourse.ClassicalMusic">
    //</bean>
    //
    //bean id="musicPlayer"
    //     class="ru.kurochkin.springcourse.MusicPlayer">
    //      <constructor-arg ref="musicBean"/>
    //</bean>
    @Bean
    public ClassicalMusic musicBean(){
        return new ClassicalMusic();
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(musicBean());
    }

}
