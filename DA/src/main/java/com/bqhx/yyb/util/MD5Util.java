package com.bqhx.yyb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * MD5加密工具
 *
 */
public class MD5Util {
	private static Logger logger = Logger.getLogger(MD5Util.class);
	//加的盐
	private static final String SALT = "CXWcjvILHE1wI8YTEsLZpS0pWj59A36Kd";

	public static String encryptMD5(String source) {
    	try {
			MessageDigest digist = MessageDigest.getInstance("MD5");
			byte[] rs = digist.digest(source.getBytes());
			StringBuffer digestHexStr = new StringBuffer();
	          for (int i = 0; i < 16; i++) {
	        	  digestHexStr.append(byteHEX(rs[i]));
	          }
	          return digestHexStr.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(),e);
		}
    	return null;

    }
	/**
     * 加盐的md5值。这样即使被拖库，仍然可以有效抵御彩虹表攻击
     * @param inbuf 需做md5的字符串
     * @return
     *
     */
    public static String encryptMD5AndSalt(String source) {
        return encryptMD5(encryptMD5(source) + SALT);
    }

    public static String byteHEX(byte ib) {
    	char[] Digit = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
    	char [] ob = new char[2];
    	ob[0] = Digit[(ib >>> 4) & 0X0F];
    	ob[1] = Digit[ib & 0X0F];
    	String s = new String(ob);
    	return s;
    }
	/*public static String encode(String password) {
		password = password + SALT;
		return processEncode(password);
	}

	public static String processEncode(String password) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		char[] charArray = password.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		//string转char转byte
		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			//1、0xff是16进制（十进制是255），它默认为整形，二进制位为32位，最低八位是“1111 1111”，其余24位都是0。 
			//2、&运算: 如果2个bit都是1，则得1，否则得0； 
			//3、byte[i] & 0xff：首先，这个操作一般都是在将byte数据转成int或者其他整形数据的过程中；使用了这个操作，最终的整形数据只有低8位有数据，其他位数都为0。 
			//4、这个操作得出的整形数据都是大于等于0.
			if (val < 16) {
				hexValue.append("0");
			}
			//Integer.toHexString(val)此方法返回的字符串表示的无符号整数参数所表示的值以十六进制（基数为16）
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}*/

	public static void main(String[] args) {
		System.out.println(MD5Util.encryptMD5("abel"));
		System.out.println(MD5Util.encryptMD5("admin"));
		System.out.println(MD5Util.encryptMD5("admin"));
	}
}
