package com.jftshop.util;

import com.jftshop.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ThinkPad on 2017/6/22.
 */
public class JFTStringUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JFTStringUtils.class);

    /*
     StringUtils.isNotBlank(null)      = false
     StringUtils.isNotBlank("")        = false
     StringUtils.isNotBlank(" ")       = false
     StringUtils.isNotBlank("bob")     = true
     StringUtils.isNotBlank("  bob  ") = true
                 */
    public static boolean isNotBlank(String a) {
        return StringUtils.isNotBlank(a);
    }


    /*
    StringUtils.isEmpty(null)      = true
            StringUtils.isEmpty("")        = true
            StringUtils.isEmpty(" ")       = false
            StringUtils.isEmpty("bob")     = false
            StringUtils.isEmpty("  bob  ") = false
            */
    public static boolean isEmpty(CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }


/*         StringUtils.isBlank(null)      = true
         StringUtils.isBlank("")        = true
         StringUtils.isBlank(" ")       = true
         StringUtils.isBlank("bob")     = false
         StringUtils.isBlank("  bob  ") = false*/
    public static boolean isBlank(String a) {
        return StringUtils.isBlank(a);
    }

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static <T> String date2String(T o) {
        if (o instanceof Date) {
            return sdf.format(o);
        }
        return "";
    }

    public static String date2String(String format) {
            return sdf.format(new Date());
    }

    static SimpleDateFormat msdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date string2Date(String string)  {
        if ( string == null ) return  null;
            try {
            string = string.substring(0,19);
                return msdf.parse(  string  );
            } catch (Exception e) {
                e.printStackTrace();
                LOG.error("string2Date:{}",string);
            }
        return null;
    }

    //类型转换
    public static BigDecimal string2BigDecimal(String a) {
        try{
            return new BigDecimal(a);
        }catch (Exception ERR){
            LOG.error( "string2BigDecimal:{}",a);
        }
        return new BigDecimal("0");
    }

    //类型转换
    public static BigDecimal dobule2BigDecimal(Double a) {
        if ( a==null ) return  BigDecimal.ZERO;
        return new BigDecimal(a);
    }

    public static String getStringaUrlDecodeaUTF8(String value) {

        try {
            String string = urlHandle(value);
            if (JFTStringUtils.isEmpty(string)) {
                return null;
            } else {
                return URLDecoder.decode(value, "utf-8");
            }
        } catch (Exception e) {
            LOG.error("URL解码错误:", e);
            return "";
        }
    }

    public static String urlHandle(String value) {

        return urlHandle(value, null);
    }

    public static String urlHandle(String value, String defaultValue) {
        if (value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value)) {
            return defaultValue;
        } else {
            return value;
        }
    }

    /**
     * 获取去掉横线的长度为32的UUID串.
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static Map<String, String> parseHttpBody(HttpServletRequest req  ) {

        if ( req == null ) return  null;

        StringBuilder buff = new StringBuilder();

        try {

            InputStream inputStream = req.getInputStream();

            if (inputStream == null){
                return null;
            }

            BufferedReader in
                    = new BufferedReader(new InputStreamReader(req.getInputStream()));

            String str = null;
            while ((str = in.readLine()) != null) {
                buff.append(str);
            }

            inputStream.close();        // 释放资源
            inputStream = null;

        }catch ( Exception err ) {
            LOG.error( "JFTStringUtils parseHttpBody" , err.getMessage());
            throw BizException.SYSTEM_ERR;
        }

        return parseHttpBody( buff.toString() );
    }

    public static Map<String, String> parseHttpBody(String str) {
        if (str == null) return null;
        Map<String, String> map = new HashMap<String, String>();// 将解析结果存储在HashMap中
        String[] bodyGroup = str.split("&");
        for (int i = 0; i < bodyGroup.length; i++) {
            String[] tmp = bodyGroup[i].split("=", 2);//分两组
            map.put(tmp[0], tmp[1]);
        }
        map.put("httpbody", str);
        return map;
    }

    public static boolean isSameDayWithToday(Date date) {
        if (date == null) {
            return false;
        }
        Calendar todayCal = Calendar.getInstance();
        Calendar dateCal = Calendar.getInstance();

        todayCal.setTime(new Date());
        dateCal.setTime(date);
        int subYear = todayCal.get(Calendar.YEAR) - dateCal.get(Calendar.YEAR);
        int subMouth = todayCal.get(Calendar.MONTH) - dateCal.get(Calendar.MONTH);
        int subDay = todayCal.get(Calendar.DAY_OF_MONTH) - dateCal.get(Calendar.DAY_OF_MONTH);
        if (subYear == 0 && subMouth == 0 && subDay == 0) {
            return true;
        }
        return false;
    }

}
