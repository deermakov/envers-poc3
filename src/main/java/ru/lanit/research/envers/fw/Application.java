package ru.lanit.research.envers.fw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "ru.lanit")
@EnableJpaRepositories(value = {"ru.lanit.research.envers.adapter.jpa"},
    repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EntityScan("ru.lanit.research.envers.domain")
@EnableTransactionManagement
// непонятно зачем нужно - @EnableEnversRepositories
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        var application = Application.createSpringApplication();
        application.addInitializers(new TestContainersInitializer.Initializer());
        application.run(args);
    }

    public static SpringApplication createSpringApplication() {
        return new SpringApplication(Application.class);
    }
}
