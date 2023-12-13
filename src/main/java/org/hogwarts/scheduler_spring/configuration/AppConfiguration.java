package org.hogwarts.scheduler_spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling // без неё НЕ будет планировщика задач
public class AppConfiguration {

}