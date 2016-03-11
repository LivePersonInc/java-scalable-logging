import org.slf4j.Logger;

public interface ScalableLogging {
    /**
     *
     * @param format The message format to log
     * @param arguments formatting the message wtih these arguments
     * @return If logged the string representing this log.
     */
    ThrottlingStatusEnum trace(Logger logger, String format, Object... arguments);
}