package config;

import hibernate.HibernateNamingStrategy;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Ugo on 30/05/2015.
 */

@EnableTransactionManagement
@Configuration
public class RepositoryConfiguration {

    @Autowired private DataSource dataSource;
    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        final LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(vendorAdapter);
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("repositories", "model");
        bean.afterPropertiesSet();
        bean.setJpaProperties(properties());
        bean.setPersistenceXmlLocation("META-INF/persistence.xml");
        return bean.getObject();
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() throws NamingException{
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        transactionManager.setPersistenceUnitName("inventory");
        return transactionManager;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.getJpaPropertyMap().put("database","MYSQL");
        adapter.getJpaPropertyMap().put("generateDdl", "true");
        adapter.getJpaPropertyMap().put("showSql", "true");
        return adapter;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator(){
        HibernateExceptionTranslator hibernateExceptionTranslator = new HibernateExceptionTranslator();
        return hibernateExceptionTranslator;
    }

    public Properties properties(){
        Properties properties = new Properties();
        properties.put("hibernate.format_sql",true);
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.ejb.naming_strategy",new HibernateNamingStrategy());
        properties.put("hibernate.dialect",new MySQLDialect());
        return properties;
    }
}
