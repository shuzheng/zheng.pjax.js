package com.xinbaby.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.et.mvc.JspView;
import com.et.mvc.View;
import com.xinbaby.utils.PjaxUtil;

/**
 * 全站异步控制器
 * @author shuzheng
 *
 */
public class PjaxController extends ApplicationController {
	
	private static Log log = LogFactory.getLog(PjaxController.class);

	/**
	 * 首页
	 * @return
	 * @throws Exception
	 */
	public View index() throws Exception {
		JspView view;
		String user_agent = request.getHeader("User-Agent");
		if(user_agent.contains("iPhone") || user_agent.contains("Android") || user_agent.contains("Windows Phone")){
			view = new JspView("/pjax/m/index.jsp");
		} else {
			if (PjaxUtil.pjax(request)) {
				view = new JspView("/pjax/pc/index.jsp");
				log.info("ajax index");
			} else {
				view = new JspView("/pjax/pc/_public.jsp");
				view.setAttribute("title", "首页");
				view.setAttribute("action", "index");
				log.info("index");
			}
		}
		return view;
	}
	
	/**
	 * 列表页
	 * @return
	 * @throws Exception
	 */
	public View list() throws Exception {
		JspView view;
		String user_agent = request.getHeader("User-Agent");
		if(user_agent.contains("iPhone") || user_agent.contains("Android") || user_agent.contains("Windows Phone")){
			view = new JspView("/pjax/m/list.jsp");
		} else {
			if (PjaxUtil.pjax(request)) {
				view = new JspView("/pjax/pc/list.jsp");
				log.info("ajax list");
			} else {
				view = new JspView("/pjax/pc/_public.jsp");
				view.setAttribute("title", "列表页");
				view.setAttribute("action", "list");
				log.info("list");
			}
		}
		
		return view;
	}
	
	/**
	 * 正文页
	 * @return
	 * @throws Exception
	 */
	public View show(int id) throws Exception {
		JspView view;
		String user_agent = request.getHeader("User-Agent");
		if(user_agent.contains("iPhone") || user_agent.contains("Android") || user_agent.contains("Windows Phone")){
			view = new JspView("/pjax/m/show.jsp");
		} else {
			if (PjaxUtil.pjax(request)) {
				view = new JspView("/pjax/pc/show.jsp");
				log.info("ajax show");
			} else {
				view = new JspView("/pjax/pc/_public.jsp");
				view.setAttribute("title", "节目" + id);
				view.setAttribute("action", "show");
				log.info("show" + id);
			}
			view.setAttribute("caption", "节目" + id);
			view.setAttribute("content", "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容");
		}
		
		return view;
	}
	
}