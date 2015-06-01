package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import payment.AbstractPaymentProcessor;
import payment.RegisteredUserPaymentProcessor;
import payment.RegularUserPaymentProcessor;
import security.UserLookupInterceptor;
import web.CurrentRequestInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ugo on 02/05/2015.
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"config","controllers","security","service","payment"})
public class WebConfig extends WebMvcConfigurerAdapter{

    private static double DISCOUNT_PERCENTAGE = 25;
    private static  double NO_DISCOUNT_PERCENTAGE = 0;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926);

    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(5242880);
        return commonsMultipartResolver;
    }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("/WEB-INF/messages");
        return resourceBundleMessageSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addWebRequestInterceptor(currentRequestInterceptor());
        registry.addWebRequestInterceptor(userLookupInterceptor());
//        registry.addInterceptor(new WebRequestHandlerInterceptorAdapter()).addPathPatterns("")
    }

    @Bean
    public CurrentRequestInterceptor currentRequestInterceptor(){
        return new CurrentRequestInterceptor();
    }

    @Bean
    public UserLookupInterceptor userLookupInterceptor(){
        return new UserLookupInterceptor();
    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).
                favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(true).
                useJaf(false).
                defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Bean(name = "abstractPaymentProcessors")
    public List<AbstractPaymentProcessor> abstractPaymentProcessors(){
        List<AbstractPaymentProcessor>abstractPaymentProcessors = new ArrayList<>();
        abstractPaymentProcessors.add(registeredUserPaymentProcessor());
        abstractPaymentProcessors.add(regularUserPaymentProcessor());
        return abstractPaymentProcessors;
    }

    @Bean
    public RegisteredUserPaymentProcessor registeredUserPaymentProcessor(){
        return new RegisteredUserPaymentProcessor(DISCOUNT_PERCENTAGE);
    }

    @Bean
    public RegularUserPaymentProcessor regularUserPaymentProcessor(){
        return new RegularUserPaymentProcessor(NO_DISCOUNT_PERCENTAGE);
    }


}
