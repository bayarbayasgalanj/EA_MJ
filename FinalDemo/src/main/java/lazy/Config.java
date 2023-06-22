package lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@ComponentScan ("lazy")
@EnableAspectJAutoProxy
public class Config {}
