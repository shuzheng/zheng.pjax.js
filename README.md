<h2>zheng.pjax.js使用方法</h2>
<pre>
// 初始化插件
$.pjax({
	selector: 'a',
	container: '#content'
});
</pre>
<h2>服务器端处理</h2>
<pre>
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
</pre>
<h2>License</h2>
<p>MIT</p>
