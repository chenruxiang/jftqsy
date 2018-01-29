package com.jftshop.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by ThinkPad on 2017/6/28.
 */
public class PasswordUtil {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";

    private static String hashIteration = "2";

    private static int hashIterations = Integer.valueOf(hashIteration);

    public static  String[] encryptPassword(String login_Name  , String pwd  ) {

        String salt = randomNumberGenerator.nextBytes().toHex() ;

        String newPassword = new SimpleHash(algorithmName, pwd, ByteSource.Util.bytes( login_Name + salt ), hashIterations).toHex();

        return  new String[]{salt, newPassword};
    }

    /**
     * 加密密码
     *
     * @param loginPwd
     *            明文密码
     * @param salt
     * @return
     */
    public static String getPwd(String loginPwd, String salt) {
        String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
        return newPassword;
    }

    static public void  main(String[] arg){
        String[] r = PasswordUtil.encryptPassword("admin","123456");
        //盐
        System.out.println(r[0]);//100319a431619710704fb054beff402b
        //密码
        System.out.println(r[1]);//0ec82a496db653ee3585bbc5ce61d604
    }




}
