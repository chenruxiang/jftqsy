package com.jftshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.validation.Validator;
import java.util.Set;

/**
 * Created by ThinkPad on 2018/1/31.
 */
public class BaseController {

    @Autowired
    private Validator validator;


    protected boolean validator(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass)
    {

        Set localSet = this.validator.validateValue(paramClass, paramString, paramObject, paramArrayOfClass);
        if (localSet.isEmpty())
            return true;
        RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
        localRequestAttributes.setAttribute("constraintViolations", localSet, 0);
        return false;
    }

    protected boolean validator(Class<?> paramClass, String paramString, Object paramObject)
    {

        Set localSet = this.validator.validateValue(paramClass, paramString, paramObject,
                new Class[] { javax.validation.groups.Default.class});
        if (localSet.isEmpty())
            return true;
        RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
        localRequestAttributes.setAttribute("constraintViolations", localSet, 0);
        return false;
    }

}
