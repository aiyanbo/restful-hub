package org.jmotor.restful.exception;

/**
 * Component:
 * Description:
 * Date: 14-4-30
 *
 * @author Andy Ai
 */
public class AuthenticationException extends RuntimeException {
    private Code code;

    public AuthenticationException(Code code) {
        super(code.message());
        this.code = code;
    }

    public Code code() {
        return code;
    }

    public static enum Code {
        MISSING_HEADER_AUTHORIZATION(401, "unauthorized", "Missing http header[Authorization] or is empty"),
        AUDIENCE_NOT_MATCHED(401, "audience_not_matched", "Audience not matched"),
        SCOPE_NOT_ALLOWED(403, "scope_not_allowed", "Scope not allowed"),
        TOKEN_EXPIRED(403, "token_expired", "Token expired"),
        UNKNOWN_CLIENT(401, "unknown_client", "Unknown client"),
        UNKNOWN_SCOPE(401, "unknown_scope", "Unknown scope");

        private int status;
        private String code;
        private String message;

        private Code(int status, String code, String message) {
            this.status = status;
            this.code = code;
            this.message = message;
        }

        public int status() {
            return status;
        }

        public String code() {
            return code;
        }

        public String message() {
            return message;
        }
    }
}
