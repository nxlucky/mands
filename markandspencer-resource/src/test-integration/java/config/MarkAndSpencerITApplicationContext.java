package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created by Ugo on 30/05/2015.
 */
@Lazy
@Configuration
@ComponentScan(basePackages = {"acceptance.*","acceptance.*","config.*"})
public class MarkAndSpencerITApplicationContext {
}
