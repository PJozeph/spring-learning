package home.joci.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="home.joci.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired private Environment environment;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public DataSource securtyDataSource() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		try {
			logger.info(">>>>>>>>>>>>>>> jdbc.url"  + environment.getProperty("jdbc.url"));
			logger.info(">>>>>>>>>>>>>>> jdbc.user"  + environment.getProperty("jdbc.user"));
			comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));
		comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		comboPooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		comboPooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		comboPooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return comboPooledDataSource;
	}
	
	private int getIntProperty(String propertyName) {
		return Integer.parseInt(environment.getProperty(propertyName));
	}

}
