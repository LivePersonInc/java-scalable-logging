import org.slf4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

public class ScalableLogger implements ScalableLogging {
    private AtomicLong logCounter = new AtomicLong(0L);

    public ThrottlingStatusEnum trace(Logger logger, String format, Object... arguments) {
        if (hasThrottlingConditionPassed(logCounter)) {
            logger.trace(format, arguments);
            return ThrottlingStatusEnum.LOGGED;
        } else {
            return ThrottlingStatusEnum.THROTTLED;
        }
    }

    public boolean hasThrottlingConditionPassed(final AtomicLong logCounter) {
        if (logCounter.getAndIncrement() % 1000 == 0) {
            return true;
        } else {
            return false;
        }
    }
}