package yu.nowopen.exception;

public class NotFoundNoticeException extends Exception {

    public NotFoundNoticeException() {
        super();
    }

    public NotFoundNoticeException(String message) {
        super(message);
    }

    public NotFoundNoticeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundNoticeException(Throwable cause) {
        super(cause);
    }

    protected NotFoundNoticeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
