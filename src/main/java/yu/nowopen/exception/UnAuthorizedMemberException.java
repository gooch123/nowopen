package yu.nowopen.exception;

public class UnAuthorizedMemberException extends RuntimeException {

    public UnAuthorizedMemberException() {
        super();
    }

    public UnAuthorizedMemberException(String message) {
        super(message);
    }

    public UnAuthorizedMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnAuthorizedMemberException(Throwable cause) {
        super(cause);
    }

    protected UnAuthorizedMemberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
