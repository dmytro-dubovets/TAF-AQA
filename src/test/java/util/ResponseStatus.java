package util;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {

    SUCCESS(HttpStatus.OK),
    SUCCESS_NO_CONTENT(HttpStatus.NO_CONTENT),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND(HttpStatus.NOT_FOUND),
    CREATED(HttpStatus.CREATED),
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE),
    FORBIDDEN(HttpStatus.FORBIDDEN);

    private String status;

    private String message;

    ResponseStatus(HttpStatus status) {
        this.status = String.valueOf(status.value());
        this.message = status.getReasonPhrase();
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
