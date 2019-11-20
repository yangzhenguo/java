package bootstrap;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/11/19.
 */
@Configuration
@ComponentScans({
        @ComponentScan(value = "com.yangzg.service", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class)),
        @ComponentScan(value = "com.yangzg.aspect", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class)),
})
@EnableAspectJAutoProxy
@ImportResource("classpath:aop1.xml")
public class Application {
}
