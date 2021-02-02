package ru.randomfqdn.homework.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"ru.randomfqdn.homework.repo"})
@ComponentScan(basePackages = {"ru.randomfqdn.homework.service", "ru.randomfqdn.homework.model"})
public class JpaConfiguration {

    public static final Logger logger = LoggerFactory.getLogger(JpaConfiguration.class);

//    @SuppressWarnings("unchecked")
    @Bean
    public DataSource dataSource() {
        try {
            var dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder
                    .setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:schema.sql")
                    .build();

        } catch (Exception e) {
            logger.error("DataSource bean cannot be created!", e);
            return null;
        }
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }
    @Bean
    public Properties hibernateProperties() {

        Properties hibernateProp = new Properties();

        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.format_sql", false);
        hibernateProp.put("hibernate.show_sql", false);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);

        return hibernateProp;

    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        var factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setPackagesToScan("ru.randomfqdn.homework.model");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.afterPropertiesSet();

        return factoryBean.getNativeEntityManagerFactory();

    }



}
