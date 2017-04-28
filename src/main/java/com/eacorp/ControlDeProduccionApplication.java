package com.eacorp;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jndi.JndiObjectFactoryBean;


@SpringBootApplication
public class ControlDeProduccionApplication {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.url}")
	private String url;
	
	public static void main(String[] args) {
		SpringApplication.run(ControlDeProduccionApplication.class, args);
				
	}
	
	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
	    return new TomcatEmbeddedServletContainerFactory() {

	        @Override
	        protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
	                Tomcat tomcat) {
	            tomcat.enableNaming();
	            return super.getTomcatEmbeddedServletContainer(tomcat);
	        }
	    };
	}
	
	

@Bean
public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
    return new EmbeddedServletContainerCustomizer() {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory = (TomcatEmbeddedServletContainerFactory) container;
                tomcatEmbeddedServletContainerFactory.addContextCustomizers(new TomcatContextCustomizer() {
                    @Override
                    public void customize(Context context) {
                    	ContextResource mydatasource = new ContextResource();
                        mydatasource.setName("jdbc/prueba");
                        mydatasource.setAuth("Container");
                        mydatasource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
                        mydatasource.setType("javax.sql.DataSource");
                        mydatasource.setScope("Sharable");
                        mydatasource.setProperty("driverClassName", driverClassName);
                        mydatasource.setProperty("url", url);
                        mydatasource.setProperty("username", user);
                        mydatasource.setProperty("password", password);

                        context.getNamingResources().addResource(mydatasource);

                    }
                });
            }
        }
    };
}

@Lazy
@Bean(destroyMethod="")
public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
    JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
    bean.setJndiName("java:comp/env/jdbc/prueba");
    bean.setProxyInterface(DataSource.class);
    bean.setLookupOnStartup(false);
    bean.afterPropertiesSet();
    return (DataSource)bean.getObject();
}
}
