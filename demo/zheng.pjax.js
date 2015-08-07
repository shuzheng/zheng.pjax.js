/****************************************************************************
 * 
*	zheng.pjax.js v0.1
*
*	日期：2015-07-30
*	作者：张恕征
*	邮箱：469741414@qq.com
*	主页：http://www.zhangshuzheng.cn/
*	Copyright (c) 2015, Zhang Shuzheng All rights reserved.
*	Licensed under the MIT license: http://opensource.org/licenses/MIT
*
****************************************************************************/
;(function($, window) {
	// 方法集合
	var plugin = {
		trigger: function(event, $a) {
			if ('undefined' != typeof NProgress) {
				NProgress.start();
			}
			var url = '';
			// 直接访问
			if (event == 'load') {
				var url = location.pathname + location.search + location.hash;
				history.replaceState({title: document.title}, null, url);
				NProgress.done();
				return;
			}
			// 点击链接
			else if (event == 'click') {
				// history压栈
				history.pushState({title:  $a.attr('title')}, null, $a.attr('href'));
				// 更新标题
				document.title = $a.attr('title');
				// 当前url
				url = $a.attr('href');
			}
			// 前进后退
			else if (event == 'popstate') {
				var url = location.pathname + location.search + location.hash;
				var state = history.state;
				if (state != null) {
					document.title = state.title;
				}
				history.replaceState({title: document.title}, null, url);
			}
			$.ajax(url, {
				type: 'get',
				headers: {'Shuzheng-PJAX': 'true'},
				success: function(html){
					$('#content').html(html);
				},
				error: function() {
					$('#content').html('404');
				}
			});
			if ('undefined' != typeof NProgress) {
				NProgress.done();
			}
		}
	}
	// 添加静态方法
	$.extend({
		pjax: function(option) {
			// 如果支持pushstate
			if ('pushState' in history) {
				// 超链接绑定事件
				$(option.container).on('click', option.selector, function(e) {
					plugin.trigger('click', $(this));
					e.preventDefault();
				});
				// 监听浏览器前进后退事件
				// 事件触发
				window.addEventListener('popstate', function(e) {
					plugin.trigger('popstate');
				});
				plugin.trigger('load');
			}
			// 'onhashchange' in window
		}
	});
	// 扩展方法
	$.fn.pjax = function(options) {
		var opts = $.extend({}, $.fn.pjax.defaults, options);
		return this.each(function(i) {
			console.log(this.href);
		});
	}
	// 默认配置
	$.fn.pjax.defaults = {
		debug: false
	}
})(jQuery, window);