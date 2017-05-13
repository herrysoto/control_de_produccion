package com.eacorp;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



@SpringBootApplication
public class ControlDeProduccionApplication  extends SpringBootServletInitializer{
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.url}")
	private String url;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	       return application.sources(ControlDeProduccionApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ControlDeProduccionApplication.class, args);
				
	}
	
//	@Bean
//	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
//	    return new TomcatEmbeddedServletContainerFactory() {
//
//	        @Override
//	        protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
//	                Tomcat tomcat) {
//	            tomcat.enableNaming();
//	            return super.getTomcatEmbeddedServletContainer(tomcat);
//	        }
//	    };
//	}
//	
//	
//
//@Bean
//public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
//    return new EmbeddedServletContainerCustomizer() {
//        @Override
//        public void customize(ConfigurableEmbeddedServletContainer container) {
//            if (container instanceof TomcatEmbeddedServletContainerFactory) {
//                TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory = (TomcatEmbeddedServletContainerFactory) container;
//                tomcatEmbeddedServletContainerFactory.addContextCustomizers(new TomcatContextCustomizer() {
//                    @Override
//                    public void customize(Context context) {
//                    	ContextResource mydatasource = new ContextResource();
//                        mydatasource.setName("jdbc/prueba");
//                        mydatasource.setAuth("Container");
//                        mydatasource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
//                        mydatasource.setType("javax.sql.DataSource");
//                        mydatasource.setScope("Sharable");
//                        mydatasource.setProperty("driverClassName", driverClassName);
//                        mydatasource.setProperty("url", url);
//                        mydatasource.setProperty("username", user);
//                        mydatasource.setProperty("password", password);
//
//                        context.getNamingResources().addResource(mydatasource);
//
//                    }
//                });
//            }
//        }
//    };
//}

	@Lazy
	@Bean(destroyMethod="")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	    dataSourceBuilder.url(url);
	    dataSourceBuilder.username(user);
	    dataSourceBuilder.password(password);
	    dataSourceBuilder.driverClassName(driverClassName);
	    return dataSourceBuilder.build();  
	}

	@Component
	public class CorsFilter extends OncePerRequestFilter {

	    @Override
	    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
	                                    final FilterChain filterChain) throws ServletException, IOException {
	        response.addHeader("Access-Control-Allow-Origin", "*");
	        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
	        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
	        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
	        response.addHeader("Access-Control-Allow-Credentials", "true");
	        response.addIntHeader("Access-Control-Max-Age", 10);
	        filterChain.doFilter(request, response);
	    }
	}
}
