package com.example;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * 
 * @author HEWEI
 *
 */
public class Signature {
	private final static String ENCRYPTION_KEY = "1pcXdQUobqtu3TBldnSERVICE";
	
	/**
	 * 加密key------------------参数封装完成调用给方法，返回JOSN格式字符串
	 * 
	 * @param origin
	 * @param charsetName
	 * @return
	 */
	public static String MD5Key(String json) {
		String resultString = null;
		try {
			Gson gson = new Gson();
			Map<String,String> map = (Map<String,String>)gson.fromJson(json,HashMap.class);
			String sign = generateSign(map);
			map.put("sign", sign);
			return gson.toJson(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}
	public static Map<String,String> MD5KeyMap(String json) {
		try {
			Gson gson = new Gson();
			Map<String,String> map = (Map<String,String>)gson.fromJson(json,HashMap.class);
			String sign = generateSign(map);
			map.put("sign", sign);
			return map;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取参数进行签名验证，验证成功后返回JONS（参数中去除签名）
	 * 如：{a:1,b:2,c:3,sign:dasfasd}验证通过后返回{a:1,b:2,c:3}如果验证失败，返回null
	 * 
	 * @return
	 */
	public static String verify(String json){
		Gson gson = new Gson();
		Map<String,String> map = (Map<String,String>)gson.fromJson(json,HashMap.class);
		String sign_old = map.get("sign");
		map.remove("sign");
		String sign_new = generateSign(map);
		if (sign_new.equals(sign_old)) {
			return gson.toJson(map);
		}
		return null;
	}
	
	
	
	
	
/*------------------上面为主方法-------------下面为附属方法------------------------------------------------------*/
	/**
	 * json 排序
	 * @return
	 */
	
	public static String sort(String json) {
		Gson gson = new Gson();
		Map<String,String> map = order((Map<String,String>)gson.fromJson(json,HashMap.class));
		return gson.toJson(map);
	}
	/**
	 * 获取签名
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String generateSign(Map<String, String> map){
    	Map<String, String> orderMap = order(map);
		
    	String result = mapJoin(orderMap,false,false);
        result += "&key=" + ENCRYPTION_KEY;
        result = MD5Encode(result).toUpperCase();
        return result;
    }
	/**
	 * J 编码
	 * 
	 * @param origin
	 * @return
	 */

	// MessageDigest 为 JDK 提供的加密类
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
		} catch (Exception ex) {
		}
		return resultString;
	}
	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	/**
	 * J 转换byte到16进制
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
	 String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
				"e", "f" };
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	/**
	 * UTILS----------------------------------------------Service
	 */
	/**
	 * Map key 排序
	 * @param map
	 * @return
	 */
	public static Map<String,String> order(Map<String, String> map){
		HashMap<String, String> tempMap = new LinkedHashMap<String, String>();
		List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(	map.entrySet());

		Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1,Map.Entry<String, String> o2) {
				return (o1.getKey()).toString().compareTo(o2.getKey());
			}
		});

		for (int i = 0; i < infoIds.size(); i++) {
			Map.Entry<String, String> item = infoIds.get(i);
			tempMap.put(item.getKey(), String.valueOf(item.getValue()));
		}
		return tempMap;
	}
	/**
	 * url 参数串连
	 * @param map
	 * @param keyLower
	 * @param valueUrlencode
	 * @return
	 */
	public static String mapJoin(Map<String, String> map,boolean keyLower,boolean valueUrlencode){
		StringBuilder stringBuilder = new StringBuilder();
		for(String key :map.keySet()){
			if(map.get(key)!=null&&!"".equals(map.get(key))){
				try {
					String temp = (key.endsWith("_")&&key.length()>1)?key.substring(0,key.length()-1):key;
					stringBuilder.append(keyLower?temp.toLowerCase():temp)
								 .append("=")
								 .append(valueUrlencode?URLEncoder.encode(map.get(key),"utf-8").replace("+", "%20"):map.get(key))
								 .append("&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		if(stringBuilder.length()>0){
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String token = "{\"f2erMobile\": \"string\",\"fserMobile\": \"string\",\"dserMobile\": \"string\", \"userMobile\": \"string\",\"accessToken\": \"adfadfadsfadf\",\"agentNo\": \"string\",\"amount\": 0,\"channel\": \"string\",\"companyAgency\": \"string\",\"effectiveDate\": \"string\",\"expirationDate\": \"string\",\"insurancePolicyNo\": \"string\", \"integral\": 0,\"integralType\": \"string\",\"marketActivity\": \"string\", \"orderNo\": \"string\", \"userAddress\": \"string\", \"userIdCard\": \"string\",\"userName\": \"string\"}";
		String token2 = "{\"agentNo\": \"string\",\"fserMobile\": \"string\",\"f2erMobile\": \"string\",\"dserMobile\": \"string\", \"userMobile\": \"string\",\"accessToken\": \"adfadfadsfadf\",\"amount\": 0,\"channel\": \"string\",\"companyAgency\": \"string\",\"effectiveDate\": \"string\",\"expirationDate\": \"string\",\"insurancePolicyNo\": \"string\", \"integral\": 0,\"integralType\": \"string\",\"marketActivity\": \"string\", \"orderNo\": \"string\", \"userAddress\": \"string\", \"userIdCard\": \"string\",\"userName\": \"string\"}";
		
		System.out.println(sort(token));
		System.out.println(sort(token2));
		System.out.println(sort(token).equals(sort(token2)));
		
		String rest = MD5Key(token2);
		System.out.println("rest..." + rest);
		// 校验并返回json
		String ver = verify(rest);
		System.out.println("json..." + ver);
		
		String rest2=MD5Key(ver);
		System.out.println("rest2..." + rest2);
		String ver2 = verify(rest2);
		System.out.println("json2..." + ver2);

		// **************************加密******************************

	}
	/**
	 * MD5签名加密
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public static String MD5(String sourceStr) throws Exception {
		String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
	}
	
	/*public static void main(String[] args) throws Exception {
		System.out.println(MD5Utils.MD5("yixiumao18616904220"));
	}*/
}

