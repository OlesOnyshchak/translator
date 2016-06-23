package com.translator.config;

import com.translator.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Application.class)
public class JpaConfig  {

    @Autowired
    private Environment env;

    @Bean
    public SharedEntityManagerBean productionEntityManager()
    {
        SharedEntityManagerBean entityManagerBean = new SharedEntityManagerBean();
        entityManagerBean.setEntityManagerFactory(productionEntityManagerFactory().getObject());
        return entityManagerBean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productionEntityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(productionDataSource());
        entityManagerFactoryBean.setPackagesToScan(env.getProperty("entities.to.scan"));
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager productionTransactionManager()
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(productionEntityManagerFactory().getObject());
        transactionManager.setDataSource(productionDataSource());
        return transactionManager;
    }

    @Bean
    public DriverManagerDataSource productionDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    private Map<String, String> jpaProperties()
    {
        Map<String, String> jpaProperties = new HashMap<String, String>();
        jpaProperties.put("hibernate.dialect", env.getProperty("hb.dialect"));
        jpaProperties.put("hibernate.show_sql", env.getProperty("hb.showSql"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("hb.formatSql"));
        jpaProperties.put("hibernate.use_sql_comments", env.getProperty("hb.sqlComment"));
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hb.hbm2ddl.auto"));
        jpaProperties.put("hibernate.enable_lazy_load_no_trans", env.getProperty("hb.enableLazyLoadNoTrans"));

        return jpaProperties;
    }

}