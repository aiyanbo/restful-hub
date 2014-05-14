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
        INCORRECT_CLIENT_CREDENTIALS(Response.Status.UNAUTHORIZED.getStatusCode(),
                "incorrect_client_credentials", "The client_id and/or client_secret passed are incorrect"),
        REDIRECT_URI_MISMATCHED(Response.Status.BAD_REQUEST.getStatusCode(),
                "redirect_uri_mismatched", "The redirect_uri MUST match the registered callback URL for this application"),
        BAD_VERIFICATION_CODE(Response.Status.UNAUTHORIZED.getStatusCode(),
                "bad_verification_code", "The code passed is incorrect or expired"),
        CLIENT_SUSPENDED(Response.Status.FORBIDDEN.getStatusCode(),
                "client_suspended", "The client has been suspended"),
        SERVER_SUSPENDED(Response.Status.FORBIDDEN.getStatusCode(),
                "server_suspended", "The server has been suspended"),
        ACCESS_DENIED(Response.Status.FORBIDDEN.getStatusCode(), "access_denied", "The user has denied your application access"),
        INVALID_TOKEN(Response.Status.BAD_REQUEST.getStatusCode(), "invalid_token", "Invalid token"),
        TOKEN_EXPIRED(Response.Status.BAD_REQUEST.getStatusCode(), "token_expired", "Token expired"),
        UNKNOWN_SCOPE(Response.Status.UNAUTHORIZED.getStatusCode(), "unknown_scope", "Unknown scope"),
        UNKNOWN_CLIENT(Response.Status.UNAUTHORIZED.getStatusCode(), "unknown_client", "Unknown client"),
        SCOPE_NOT_ALLOWED(Response.Status.FORBIDDEN.getStatusCode(), "scope_not_allowed", "Scope not allowed"),
        AUDIENCE_MISMATCHED(Response.Status.FORBIDDEN.getStatusCode(), "audience_mismatched", "Audience not matched"),
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
