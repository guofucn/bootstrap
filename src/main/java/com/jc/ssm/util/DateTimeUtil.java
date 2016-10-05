package com.jc.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
* @ClassName: DateTimeUtil  
* @Description: TODO
* @author guofu 81378536.qq.com  
* @date 2016年5月24日 下午2:16:16  
*
 */
public class DateTimeUtil {
	/**
	 * 获取当前日期，不包含时间
	* @Title: currentDate  
	* @Description: TODO
	* @param @return
	* @return Date
	* @throws
	 */
	public static Date currentDate(){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
		}
		return date;
	}
	
	/**
	 * 字符串转日期，不包含时间
	* @Title: StrToDate  
	* @Description: 格式yyyy-MM-dd
	* @param @param str
	* @param @return
	* @return Date
	* @throws
	 */
	
	public static Date StrToDate(String str){
		if (str == null || str.trim().equals(""))
			return null;
		String format = "yyyy-MM-dd HH:mm:ss";
		if (str.length() <= 16)
			format = "yyyy-MM-dd HH:mm";
		if (str.length() <= 10)
			format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}	
	/**
	 * 字符串转日期时间
	* @Title: StrToDateTime  
	* @Description: 格式yyyy-MM-dd HH:mm:ss
	* @param @param str
	* @param @return
	* @return Date
	* @throws
	 */
	public static Date StrToDateTime(String str){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
		}
		return date;
	}

	/**
	 * 日期加天数
	* @Title: dateAdd  
	* @Description: TODO
	* @param @param date
	* @param @param day
	* @param @return
	* @return Date
	* @throws
	 */
	public static Date addDay(Date date, int day){
		date = addHour(date, 24 * day);
		return date;
	}
	
	/**
	 * 日期加小时数
	* @Title: addHour  
	* @Description: TODO
	* @param @param date
	* @param @param hour
	* @param @return
	* @return Date
	* @throws
	 */
	public static Date addHour(Date date, int hour){
		date = new Date(date.getTime() + 1000 * 3600 * hour);
		return date;
	}
	
	public static String DateToStr(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}
	
	public static String DateTimeToStr(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}
}
