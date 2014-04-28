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
public class Builder {
    private String message;
    private List<Detail> errors = new ArrayList<>();

    private Builder() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Builder error(String code, String message) {
        Detail error = new Detail();
        error.setCode(code);
        error.setMessage(message);
        return error(error);
    }

    public Builder error(Detail error) {
        errors.add(error);
        return this;
    }

    public Builder message(String message) {
        this.message = message;
        return this;
    }

    public Builder errors(List<Detail> errors) {
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
}
