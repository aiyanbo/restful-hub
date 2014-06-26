package org.jmotor.restful.response;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Component:
 * Description:
 * Date: 14-4-28
 *
 * @author Andy Ai
 */
public class ErrorBuilder {
    private String message;
    private List<Stack> errors = new ArrayList<>();

    private ErrorBuilder() {
    }

    public static ErrorBuilder newBuilder() {
        return new ErrorBuilder();
    }

    public ErrorBuilder error(String code, String message) {
        Stack error = new Stack();
        error.setCode(code);
        error.setMessage(message);
        return error(error);
    }

    public ErrorBuilder error(Stack error) {
        errors.add(error);
        return this;
    }

    public ErrorBuilder message(String message) {
        this.message = message;
        return this;
    }

    public ErrorBuilder errors(List<Stack> errors) {
        this.errors = errors;
        return this;
    }

    public Error build() {
        Error error = new Error();
        error.setMessage(message);
        if (null != errors && 0 < errors.size()) {
            error.setErrors(errors);
        }
        return error;
    }

    public Response build(Response.Status status) {
        Error error = build();
        return Response.status(status).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    public Response build(int status) {
        Error error = build();
        return Response.status(status).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
