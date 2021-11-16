package ru.spin.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.spin.main")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
}
