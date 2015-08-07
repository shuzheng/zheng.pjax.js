package com.xinbaby.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * PJAX辅助类
 * 
 * @author shuzheng
 * @version 2015/07/30
 * 
 */
public class PjaxUtil {

	private static Log log = LogFactory.getLog(PjaxUtil.class);
	
	/**
	 * 判断请求是否是pjax
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static boolean pjax(HttpServletRequest request) throws Exception {
		boolean pjax = false;
		if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
			if (request.getHeader("Shuzheng-PJAX") != null && request.getHeader("Shuzheng-PJAX").equalsIgnoreCase("true")) {
				pjax = true;
			}
		}
		return pjax;
	}
	
}
