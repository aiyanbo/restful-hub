package org.jmotor.restful;

import org.jmotor.restful.provider.mapper.AuthenticationExceptionMapper;
import org.jmotor.restful.provider.mapper.ConstraintViolationExceptionMapper;
import org.jmotor.restful.provider.mapper.EntityExistsExceptionMapper;
import org.jmotor.restful.provider.mapper.EntityNotFoundExceptionMapper;
import org.jmotor.restful.provider.mapper.ForbiddenExceptionMapper;
import org.jmotor.restful.provider.mapper.IllegalArgumentExceptionMapper;
import org.jmotor.restful.provider.mapper.NotAllowedExceptionMapper;
import org.jmotor.restful.provider.mapper.NotAuthorizedExceptionMapper;
import org.jmotor.restful.provider.mapper.NotFoundExceptionMapper;
import org.jmotor.restful.provider.mapper.NotImplementedExceptionMapper;
import org.jmotor.restful.provider.mapper.ThrowableMapper;
import org.jmotor.restful.provider.mapper.WebApplicationExceptionMapper;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Component:
 * Description:
 * Date: 14-4-29
 *
 * @author Andy Ai
 */
public class RestfulhubFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(ThrowableMapper.class);
        featureContext.register(NotFoundExceptionMapper.class);
        featureContext.register(ForbiddenExceptionMapper.class);
        featureContext.register(NotAllowedExceptionMapper.class);
        featureContext.register(EntityExistsExceptionMapper.class);
        featureContext.register(NotAuthorizedExceptionMapper.class);
        featureContext.register(EntityNotFoundExceptionMapper.class);
        featureContext.register(WebApplicationExceptionMapper.class);
        featureContext.register(NotImplementedExceptionMapper.class);
        featureContext.register(AuthenticationExceptionMapper.class);
        featureContext.register(IllegalArgumentExceptionMapper.class);
        featureContext.register(ConstraintViolationExceptionMapper.class);
        return true;
    }
}
