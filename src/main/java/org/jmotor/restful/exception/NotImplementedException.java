package org.jmotor.restful.exception;

import javax.ws.rs.core.Response;

/**
 * Component:
 * Description:
 * Date: 14-4-30
 *
 * @author Andy Ai
 */
public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
        super(Response.Status.NOT_IMPLEMENTED.getReasonPhrase());
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
