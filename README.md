## How to use
```js
// init
$.pjax({
	selector: 'a',
	container: '#content'
});
```
## server
```java
/**
 * index
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
			view.setAttribute("title", "index");
			view.setAttribute("action", "index");
			log.info("index");
		}
	}
	return view;
}
```
## License
MIT
