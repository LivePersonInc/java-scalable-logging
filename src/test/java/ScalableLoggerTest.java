import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class ScalableLoggerTest {
    @Test public void hasThrottlingConditionPassed() throws Exception {
        LongAdder long434 = new LongAdder();
        long434.add(434);

        LongAdder long1000 = new LongAdder();
        long1000.add(1000);

        Assert.assertFalse(new ScalableLogger().hasThrottlingConditionPassed(long434));
        Assert.assertTrue(new ScalableLogger().hasThrottlingConditionPassed(long1000));
    }
}