package com.jftshop.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Service
public final class SpringUtils
  implements DisposableBean, ApplicationContextAware
{
  private static ApplicationContext applicationContext;

  public void setApplicationContext(ApplicationContext applicationContext)
  {
    this.applicationContext = applicationContext;
  }

  public void destroy()
  {
    applicationContext = null;
  }

  public static ApplicationContext getApplicationContext()
  {
    return applicationContext;
  }

  public static Object getBean(String name)
  {
    return applicationContext.getBean(name);
  }

  public static <T> T getBean(String name, Class<T> type)
  {
    return applicationContext.getBean(name, type);
  }

  public static String getMessage(String code, Object[] args)
  {
    LocaleResolver localLocaleResolver = (LocaleResolver)getBean("localeResolver", LocaleResolver.class);
    Locale localLocale = localLocaleResolver.resolveLocale(null);
    return applicationContext.getMessage(code, args, localLocale);
  }
}
