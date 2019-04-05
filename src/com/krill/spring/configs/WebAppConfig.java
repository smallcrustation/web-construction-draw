package com.krill.spring.configs;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("com.krill.spring")
@EnableWebMvc
@EnableTransactionManagement // so you don't have to start and commit every transaction
@PropertySource({"classpath:persistence-mysql.properties"}) // adds it to the spring 'Environment'
public class WebAppConfig implements WebMvcConfigurer{
	
	@Autowired // @PropertySource supplies the location of the req properties
	private Environment env;
	
	// shows logs in console
	private Logger logger = Logger.getLogger(getClass());
	
	@Bean // allows a sessionFactory to be autowired where needed for TransactionManagement
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// configure the sessionFactory
		sessionFactory.setDataSource(dataSource());
		
		// set area for packages to scan entities?
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		
		// set hibernate properties
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		// return the sessionFactory
		return sessionFactory;
	}
	
	@Bean // give information to connect to database
	public DataSource dataSource() {
		// ComboPooled... is used to configure c3po dataSource
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		}
		catch(PropertyVetoException exc){
			throw new RuntimeException(exc);
		}
		
		// for sanity's sake, log url and user .. just to make sure we are reading the data
		logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		
		// set database connection properties
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return dataSource;
	}
	
	public Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		// "hibernate.packagesToScan" is in beanFactory()
		
		return hibernateProperties;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		// set the prefix/suffix for views
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// tells spring where our resource file is, /** goes through each file beneath
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	// ********** Hibernate Transaction Manager ********** Autowired to work with sessionFactory... not sure on details...
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		// setup transaction manager based on sessionFactory
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
	
}
