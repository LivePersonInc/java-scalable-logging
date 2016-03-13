import org.slf4j.Logger;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class ScalableLogger implements ScalableLogging {
    private LongAdder logCounter = new LongAdder();

    public ThrottlingStatusEnum trace(Logger logger, String format, Object... arguments) {
        if (hasThrottlingConditionPassed(logCounter)) {
            logger.trace(format, arguments);
            logCounter.increment();
            return ThrottlingStatusEnum.LOGGED;
        } else {
            return ThrottlingStatusEnum.THROTTLED;
        }
    }

    public boolean hasThrottlingConditionPassed(final LongAdder logCounter) {
        if (logCounter.longValue() % 1000 == 0) {
            return true;
        } else {
            return false;
        }
    }
}