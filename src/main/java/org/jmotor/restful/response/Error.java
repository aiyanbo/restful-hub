package org.jmotor.restful.response;

import java.util.List;

/**
 * Component:
 * Description:
 * Date: 14-4-28
 *
 * @author Andy Ai
 */
public class Error {
    private String message;
    private List<Stack> errors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Stack> getErrors() {
        return errors;
    }

    public void setErrors(List<Stack> errors) {
        this.errors = errors;
    }
}
