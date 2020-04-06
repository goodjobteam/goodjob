package com.mingzhi.common;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/*
 * author mingzhi
 * 2020年04月06日
 * 处理的一些公共方法
 */
public class CommonUtils{

		public static final String RANDOM_STRING = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//返回的json值
		public static final String JSON_SUCCESS_TRUE = "{\"success\": true}";
		public static final String JSON_SUCCESS_FALSE = "{\"success\": false}";
		
		/**
		 * 判断字符串（数字的字符串）是否为空,为空时返回"0"
		 * @param param 需要判断的字符串
		 * @return
		 */
		public static String isNumberNull(String param) {
			if (param == null || "".equals(param)) {
				return "0";
			} else {
				return param;
			}
		}
		
		/**
		 * 判断字符串（数字的字符串）是否为空,为空时返回"0.0"
		 * @param param 需要判断的字符串
		 * @return
		 */
		public static String isNumberNull2(String param) {
			if (param == null || "".equals(param)) {
				return "0.0";
			} else {
				return param;
			}
		}
		
		/**
	     * 得到给定日期的第二天
	     */
	    public static String getTheTimeOfToday(String theday){
	    	
	    	Date textDate = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			String tomorrow = null;//得到明天的时间
			try {
				textDate = sdf.parse(theday);
				cal.setTime(textDate);
				cal.add(Calendar.DAY_OF_YEAR, 1);
				tomorrow = sdf.format(cal.getTime());
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
			return tomorrow;
	    }

		/**
		 * 判断对象是否为空
		 * @param param 需要判断的对象
		 * @return
		 */
		public static String isNumberNull(Object param) {
			String obj = isObjectNull(param);
			if (obj == null || "".equals(obj)) {
				return "0";
			} else {
				return obj;
			}
		}
		
		/**
		 * 判断对象是否为空
		 * @param param 需要判断的对象
		 * @return
		 */
		public static String isObjectNull(Object param) {
			if (param == null || "".equals(param)) {
				return "";
			} else {
				return param + "";
			}
		}
		
		/**
		 * 判断对象是否为空
		 * @param param 需要判断的对象
		 * @param isReturnNull 对象为空的时候，确定返回值为空字符串还是"null"值，true返回"null",false返回""
		 * @return
		 */
		public static String isObjectNull(Object param, boolean isReturnNull) {
			if (param == null || "".equals(param)) {
				if (isReturnNull) {
					return "null";
				} else {
					return "";
				}
			} else {
				return param + "";
			}
		}
		
		/**
		 * 判断对象是否为空
		 * @param param 需要判断的对象
		 * @return
		 */
		public static String isObjectReturnNull(Object param) {
			if (param == null || "".equals(param)) {
					return null;
			} else {
				return param + "";
			}
		}
		
		/**
		 * 判断txt字符串是否符合regex正则表达式
		 * @param regex 正则表达式
		 * @param txt 需要验证的字符串
		 * @return
		 */
		public static boolean isMatchRegex(String regex, String txt) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(txt);
			return matcher.find();
		}
		
		/**
		 * 替换txt字符串中符合regex正则表达式的字符串
		 * @param regex 正则表达式
		 * @param txt 需要替换的字符串
		 * @param replaceTxt 替换的字符串
		 * @return
		 */
		public static String replaceStringByRegex(String regex, String txt, String replaceTxt) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(txt);
			String returnString = matcher.replaceAll(replaceTxt);
			return returnString;
		}
		
		/**
		 * 根据key和value值组成json格式的返回值
		 * @param key json格式的key值
		 * @param value json格式的value值
		 * @param isSuccess success对应的值
		 * @return
		 */
		public static String stringToReturnJsonValue(String key, String value, boolean isSuccess) {
			if (value.startsWith("[")) {
				return "{\"success\": " + isSuccess + ", \"" + key + "\": " + value + "}";
			}
			return "{\"success\": " + isSuccess + ", \"" + key + "\": \"" + value + "\"}";
		}
		
		/**
		 * 根据List组成json格式的返回值
		 * @param list 需要组成json格式的List
		 * @param isSuccess success对应的值
		 * @return
		 */
		public static String listToToReturnJsonValue(Map<String, Object> map, boolean isSuccess) {
			String result = "{\"success\": " + isSuccess;
			for (String key : map.keySet()) {
				String value = map.get(key).toString();
				if (value.startsWith("[")) {
					result += ",\"" + key + "\": " + value + "";
				} else {
					result += ",\"" + key + "\": \"" + value + "\"";
				}
			}
			result += "}";
			return result;
		}
		
		/**
		 * 将guid字符串（多个guid用逗号分隔的字符串）的,替换为以','的字符串,常用在sql语句中的IN语句
		 * @param guids 多个guid用逗号分隔的字符串
		 * @return 替换为','的guid字符串
		 */
		public static String guidsToSqlGuids(String guids) {
			Pattern pattern = Pattern.compile(",");
			Matcher m = pattern.matcher(guids);
			guids = m.replaceAll("','");
			return guids;
		}
		
		/**
		 * 将sql语句查询出来List转换为json字符串
		 * @param list sql语句查询出来List
		 * @param keys json字符串里的键值对的键组成的字符串（由逗号分隔）
		 * @param nums 取List中的哪些值的索引组成字符串
		 * @return
		 */
		public static String returnJsonValueByList(List<Object[]> list, String keys, String nums) {
			String[] keyArray = keys.split(",");
			String[] numArray = nums.split(",");
			if (keyArray.length != numArray.length) {
				System.out.println("keys与nums的长度对应");
				return "";
			}
			JSONArray jsonArray = new JSONArray();
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					HashMap<String, String> map = new HashMap<String, String>();
					for (int j = 0; j < keyArray.length; j++) {
						map.put(keyArray[j], isObjectNull(list.get(i)[Integer.parseInt(numArray[j])]));
					}
					jsonArray.add(map);
				}
			}
			return jsonArray.toString();
		}
		
		/**
		 * 将字符串格式为时间(不包含时分秒)
		 * @param dateString 需要格式化的字符串
		 * @return 完成格式化的时间
		 */
		public static Date formatStringToDate(String dateString) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(dateString);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		/**
		 * 将日期格式化为字符串(不包含时分秒)
		 * @param date 需要格式化的日期
		 * @return 完成格式化的字符串
		 */
		public static String formatDateToString(Date date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = sdf.format(date);
			return dateString;
		}
		
		/**
		 * 将字符串格式为时间(包含时分秒)
		 * @param timeString 需要格式化的字符串
		 * @return 完成格式化的时间
		 */
		public static Date formatStringToTime(String timeString) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = sdf.parse(timeString);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		/**
		 * 将日期格式化为字符串(包含时分秒)
		 * @param time 需要格式化的日期
		 * @return 完成格式化的字符串
		 */
		public static String formatTimeToString(Date time) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeString = sdf.format(time);
			return timeString;
		}
		
		/**
		 * 将Date转换为Timestamp
		 * @param date 需要转换的Date数据
		 * @return 转换完成的Timestamp数据
		 */
		public static Timestamp dateToTimestamp(Date date) {
			return new Timestamp(date.getTime());
		}
		
		/**
		 * 格式化数字字符串为保留两位小数的数字字符串
		 * @param obj 需要格式化的字符串
		 * @return 格式化完成的字符串
		 */
		public static String decimalFormatNumToStringWithRound2(Object obj) {
			DecimalFormat df = new DecimalFormat("#0.00");  //保留两位小数
			String result = df.format(obj);
			return result;
		}

		/**
		 * 格式化数字字符串为百分号的数字字符串
		 * @param obj 需要格式化的字符串
		 * @return 格式化完成的字符串
		 */
		public static String decimalFormatNumToStringWithPercent(Object obj) {
			DecimalFormat df = new DecimalFormat("##.##%");  //百分号
			String result = df.format(obj);
			return result;
		}
		
		/**
		 * 生成42位唯一标识
		 * @return 42位唯一标识
		 */
		public static String generate42BitGuid() {
			Random random = new Random();
			String uuid = UUID.randomUUID().toString();
			uuid += "-";
			for (int i = 0; i < 5; i++) {
				int randomNum = random.nextInt(RANDOM_STRING.length());
				uuid += RANDOM_STRING.charAt(randomNum);
			}
			return uuid.toUpperCase();
		}
		
		/**
		 * 获取昨天的日期
		 * @return
		 */
		public static Date getYesterday() {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			return calendar.getTime();
		}

		/**
		 * 获取当天前N天的日期
		 * @return
		 */
		public static Date getBeforeDate(int beforeDay) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, (0 - beforeDay));
			return calendar.getTime();
		}
		
		/**
		 * 获取本周第一天
		 * @return
		 */
		public static Date getCurWeekStartDate() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			return calendar.getTime();
		}
		
		/**
		 * 调整字符串格式(包含时分)
		 * @param timeString 需要格式化的字符串
		 * @return 完成格式化的时间
		 */
		public static String formatTimeStringToString(String timeString) {
			if(timeString != ""){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date date = sdf.parse(timeString);
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					return sdf.format(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			return timeString;
		}
		
		
		/**
	     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
	     *
		  * @param value
		  *            指定的字符串
		  * @return 字符串的长度
		  */
		 public static int chineseLength(String value) {
	        int valueLength = 0;
	        String chinese = "[\u0391-\uFFE5]";
	        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
	        for (int i = 0; i < value.length(); i++) {
	            /* 获取一个字符 */
	            String temp = value.substring(i, i + 1);
	            /* 判断是否为中文字符 */
	        if (temp.matches(chinese)) {
	                /* 中文字符长度为2 */
	                valueLength += 2;
	            } else {
	                /* 其他字符长度为1 */
	                valueLength += 1;
	            }
	        }
	        return valueLength;
	    }
		 
		/**
		 * 拼接SQL时使用
		 * 如果为空，返回‘null’，否则返回'self'
		 * @param obj
		 * @return
		 */
		public static String nullIfEmpty(Object param){
			if (param == null || "".equals(param)) {
				return "null";
			} else {
				return "'" + param + "'";
			}
		}
		
		/**
		 * 判断List<Map>是否包含指定key值的map
		 * @param list
		 * @param key
		 * @param keyValue
		 * @return
		 */
		public static int containsMapKey(List<Map<String,Object>> list, String key, String keyValue){
			int containsFlag = -1 ;
			if (list != null && list.size() > 0){
				for(int i = 0; i < list.size(); i ++){
					Object o = isObjectNull(list.get(i).get(key));
					if (keyValue.equals(o)){
						containsFlag = i;
						break;
					}
				}
			}
			return containsFlag;
		}
		
		/**
		 * 
		 * @Description: 从json 中获取value
		 * @param @param json
		 * @param @param key
		 * @param @return    设定文件 
		 * @return String    返回类型 
		 *
		 */
		public static String getJsonString(JSONObject json,String key){
			return json.containsKey(key)?json.get(key).equals(null)?"":json.getString(key):"";
		}
	
	
	
}
