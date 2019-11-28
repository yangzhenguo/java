package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Sam on 2019/6/27.
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        LOGGER.info("用户开始访问...");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        LOGGER.info("用户访问结束.");
    }
}
