package org.jmotor.restful.exception;

import javax.ws.rs.core.Response;

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
        TOKEN_EXPIRED(Response.Status.FORBIDDEN.getStatusCode(), "token_expired", "Token expired"),
        UNKNOWN_SCOPE(Response.Status.UNAUTHORIZED.getStatusCode(), "unknown_scope", "Unknown scope"),
        UNKNOWN_CLIENT(Response.Status.UNAUTHORIZED.getStatusCode(), "unknown_client", "Unknown client"),
        SCOPE_NOT_ALLOWED(Response.Status.FORBIDDEN.getStatusCode(), "scope_not_allowed", "Scope not allowed"),
        AUDIENCE_NOT_MATCHED(Response.Status.FORBIDDEN.getStatusCode(), "audience_not_matched", "Audience not matched"),
        MISSING_HEADER_AUTHORIZATION(Response.Status.UNAUTHORIZED.getStatusCode(), "unauthorized", "Missing http header[Authorization] or is empty");

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
