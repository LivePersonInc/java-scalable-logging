import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

public class ScalableLoggerTest {
    @Test public void hasThrottlingConditionPassed() throws Exception {
        Assert.assertFalse(new ScalableLogger().hasThrottlingConditionPassed(new AtomicLong(543)));
        Assert.assertTrue(new ScalableLogger().hasThrottlingConditionPassed(new AtomicLong(1000)));
    }
}