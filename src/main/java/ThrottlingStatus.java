/**
 * @author tomerb
 * on 3/11/16.
 */
public class ThrottlingStatus {
    private final ThrottlingStatusEnum throttlingStatusEnum;

    public ThrottlingStatus(ThrottlingStatusEnum throttlingStatusEnum) {
        this.throttlingStatusEnum = throttlingStatusEnum;
    }

    public ThrottlingStatusEnum getThrottlingStatusEnum() {
        return throttlingStatusEnum;
    }
}
