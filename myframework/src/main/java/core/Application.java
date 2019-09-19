package core;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * Created by Sam on 2019/9/19.
 */
@HandlesTypes(MyWebInitializer.class)
public class Application implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("框架启动...");
        set.stream().forEach(clazz -> {
            try {
                MyWebInitializer initializer = (MyWebInitializer) clazz.newInstance();
                initializer.onStartup(servletContext);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("框架装配完成");
    }
}
