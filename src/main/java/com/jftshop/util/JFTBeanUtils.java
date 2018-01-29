package com.jftshop.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jftshop.exception.BizException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ThinkPad on 2017/6/17.
 */


public class JFTBeanUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JFTBeanUtils.class);

    /*
    *返回指定bean提供读取方法的整个属性集。
    * 格式如 {draw=3, recordsFiltered=0, start=0, length=0, data=null}
    * */

    static Gson gson = new GsonBuilder().registerTypeAdapter( Date.class, new DateConverter() ).create();
    public static String toJson(Object obj ){
  /*      try { return BeanUtils.describe(obj).toString();} catch (Exception err) {
            throw  new RuntimeException( "BeanUtils.describe exception" );}*/
        return  gson.toJson(obj)  ;
    }

    public static String toJson(Map<String, String> m ){
        return  new Gson().toJson( m )  ;
    }

    public static String describe(List l  ){
         return  new Gson().toJson(l)  ;
    }

    public static Map<String, String> toMap(Object o) {
        try {
            return BeanUtils.describe(o);
        } catch (Exception err) {
            LOG.error( err.toString() );
            throw BizException.SYSTEM_ERR;
        }
    }


    public static void populate(Object bean,
                                Map<String, ? extends Object> properties) {
        try {
            BeanUtils.populate(bean, properties);
        } catch (Exception err) {
            LOG.error( err.toString() );
            throw  BizException.SYSTEM_ERR;
        }

    }


    //BEAN 拷贝属性
    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanUtilsBean.getInstance().copyProperties(dest, orig);
        } catch (Exception err) {
            try {
                LOG.error("copyProperties err dest={},orig={}", JFTBeanUtils.toMap(dest), JFTBeanUtils.toMap(orig));
                throw BizException.SYSTEM_ERR;
            } catch (Exception err1) {
                LOG.error("copyProperties err={}", err1.getMessage());
                throw BizException.SYSTEM_ERR;
            }
        }
    }

}
