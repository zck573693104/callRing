/**
 @document
 @author:Yujianping
 @tel:13716506521
 @date:2013-6-25
 @param(int) width 提示框的宽度 默认值为380
 @param(int) height 提示框的高度 默认值为180
 @param(int) top 弹窗距顶部的位置 可以留空，默认为页面垂直居中
 @param(int) left 弹窗距顶部的位置 可以留空，默认为页面水居中
 @param(string) title 提示框的title,默认为标题
 @example 使用示例
 @        $("#dlog").dlog({
 @			  width:380,
 @			  height:180,
 @			  top:500,
 @			  left:500,
 @			  title:"标题"
 @		 });
 **/
(function($){
	
	// 初始z-index
	var zindex = 90000;
	
	// 获取鼠标当前坐标
	$.extend({
		mouseCoords:function(e){
			if(e.pageX || e.pageY){
				return {x:e.pageX, y:e.pageY};
			}
			return {
				x:e.clientX + document.body.scrollLeft - document.body.clientLeft,
				y:e.clientY + document.body.scrollTop  - document.body.clientTop
			};
		}
	});

	// 生成弹窗
	$.fn.extend({
		dlog:function(options){
			
			var defaults = {
					title:"标题",
					width:400,
					height:200,
					top:null,
					left:null,
					modal:true,
					onClose:false,
					close:true
				},
				opts = $.extend(defaults,options || {}),
				mask = "",dlog = "",bg = "",header = "",content = "",
				width = parseInt(opts.width,10),
				height = parseInt(opts.height,10),
				_top = parseInt(opts.top,10),
				_left = parseInt(opts.left,10),
				close = opts.onClose,
				headerClose = opts.close,
				nonum = /\D/,
				top,left,$dlog,$bg,$header,$content,$mask,
				title = opts.title,
				modal = opts.modal,
				conHeight = height - 40,
				dDraging = false, // 是否正在拖动
				_this = this;
			
			// 对话框在页面中的位置
			if(nonum.test(_top) && nonum.test(_left)){
				top = ($(window).height() - height)/2; 
				left = ($(window).width() - width)/2;
			}else if(!nonum.test(_top) && nonum.test(_left)){
				top = _top;
				left = ($(window).width() - width)/2;
			}else if(nonum.test(_top) && !nonum.test(_left)){
				top = ($(window).height() - height)/2;
				left = _left;
			}else{
				top = _top;
				left = _left;
			}

			if(top < 0){
				top = 0;
			}

			if(left < 0){
				left = 0;
			}
			
			// html结构内容 
			mask = "<div class='dlog_mask'></div>"
			dlog = '<div class="dlog"></div>';
			bg = '<div class="bg"></div>';
			header = '<div class="d_header"><div class="d_title">' + title + '</div>';

			if(headerClose){
				header += '<div class="d_tool"><a class="d_tool_close" title="关闭" href="javascript:;">X</a></div>';
			}

			header += '</div>';

			content = '<div class="d_body" style="height:' + conHeight + 'px;"></div>';
			
			// 将html结构插入到body里
			$dlog = $(dlog).appendTo("body");
			$bg = $(bg).appendTo($dlog);
			$header = $(header).appendTo($bg);
			$content = $(content).appendTo($bg);
			$(_this).appendTo($content);
			
			// 设置弹窗的样式
			$dlog.css({
				"width":width,
				"height":height,
				"top":top,
				"left":left,
				"z-index":(zindex + 2)
			});
			
			// 显示弹窗
			$(_this).show();
			
			// 遮罩层
			if(modal && typeof modal == "boolean"){
				$mask = $(mask).appendTo("body");
				
				// IE6下加入iframe,解决select的问题
				/*
				if($.browser.msie && ($.browser.version == "6.0") && !$.support.style){
					
					$mask.html('<iframe style="width:100%;height:100%;position:absolute;top:0;left:0;filter:alpha(opacity=0);"></iframe>');
				}*/

				// 设置弹窗的遮罩宽高
				$mask.css({
					width:$(_this)._dlogsize().width,
					height:$(_this)._dlogsize().height,
					"z-index":(zindex + 1)
				});
				
				// 浏览器尺寸改时从新设置遮罩宽高
				$(window).on("resize",function(){
					$mask.css({
						width:$(document.body).outerWidth(true),
						height:$(document.body).outerHeight(true)
					});
					
					setTimeout(function() {
						$mask.css({
							width:$(_this)._dlogsize().width,
							height:$(_this)._dlogsize().height
						});
					},50);
				});
			}
			
			// 鼠标移向头部时鼠标效果
			$header.find(".d_title").on({
				mouseover:function(){
					$(this).css("cursor","move");
				},
				mouseout:function(){
					$(this).css("cursor","");
				}
			});

			$header.find(".d_title").on('mousedown',function(e){
				e.preventDefault();
				$(_this).dlogdrag(document,$dlog,width-2,height-2,zindex+1,e);
			});

			//绑定关闭按钮
			if(headerClose){
				$header.find(".d_tool_close").click(function(){
					$(_this)._dlogclose(close);
				});
			}

			zindex += 2;
		},
		_dlogclose:function(close){ // 关闭弹出框
			var _this = this,
				$dlog=$(_this).parent().parent().parent(),
				$mask=$dlog.next(".dlog_mask");
			
			if(!close){
				$(_this).appendTo("body").hide();
			}
			
			// 如果有遮罩则删除
			if($mask.length > 0){
				$mask.remove();
			}

			$dlog.remove();
		},
		_dlogsize:function(){ // 获取document的宽高
			if(document.compatMode == "BackCompat"){
				return {
					width:Math.max(document.body.scrollWidth,document.body.clientWidth),
					height:Math.max(document.body.scrollHeight,document.body.clientHeight)
				};
			}else{
				return {
					width:Math.max(document.documentElement.scrollWidth,document.documentElement.clientWidth),
					height:Math.max(document.documentElement.scrollHeight,document.documentElement.clientHeight)
				};
			}
		},
		dlogdrag:function(doc,$dlog,width,height,zindex,e){
		
			//e.preventDefault();
			//标记开始移动
			dDraging = true;

			// initDiffX|Y : 初始时，鼠标与被移动元素原点的距离
			// moveX|Y : 移动时，被移动元素定位位置 (新鼠标位置与initDiffX|Y的差值)
			var dragParams = {initDiffX:'',initDiffY:'',moveX:'',moveY:''};

			// 改变鼠标形状
			$("body").css({'cursor':'move'});
			
			// 生成并插入模拟移动的层和对应层初始位置
			$proxy = $("<div class='dlog_proxy'></div>").insertAfter($dlog);
			$proxy.css({
				"width":width,
				"height":height,
				"top":$dlog.css("top"),
				"left":$dlog.css("left"),
				"z-index":zindex
			});

			// 鼠标当前位置相对于被移动元素原点的距离
			dragParams.initDiffX = $.mouseCoords(e).x - $proxy.position().left;
			dragParams.initDiffY = $.mouseCoords(e).y - $proxy.position().top;
			
			$(doc).on("mousedown",function(){
				//alert(11);
				// 执行移动
				if(dDraging){	
					
					// 被移动元素的新位置，实际上鼠标当前位置与原位置之差
					// 实际上，被移动元素的新位置，也可以直接是鼠标位置，这也能体现拖拽，但是元素的位置就不会精确。
					dragParams.moveX = $.mouseCoords(e).x - dragParams.initDiffX;
					dragParams.moveY = $.mouseCoords(e).y - dragParams.initDiffY;
					
					// 移动方向：可以是不限定、垂直、水平。
					$proxy.css({'left':dragParams.moveX,'top':dragParams.moveY});
				}
			});

			//移动过程
			$(doc).on('mousemove',function(e){
				
				// 执行移动
				if(dDraging){	
					
					// 被移动元素的新位置，实际上鼠标当前位置与原位置之差
					// 实际上，被移动元素的新位置，也可以直接是鼠标位置，这也能体现拖拽，但是元素的位置就不会精确。
					dragParams.moveX = $.mouseCoords(e).x - dragParams.initDiffX;
					dragParams.moveY = $.mouseCoords(e).y - dragParams.initDiffY;
					
					// 移动方向：可以是不限定、垂直、水平。
					$proxy.css({'left':dragParams.moveX,'top':dragParams.moveY});
				}
				return false;
			});

			// 鼠标弹起时，标记为取消移动
			$(doc).on("mouseup",function(){  
			
				// 停止移动
				dDraging = false;
				$("body").css({'cursor':''}); 
				
				// 设置窗口位置
				$dlog.css({
					"top":dragParams.moveY,
					"left":dragParams.moveX
				});
				
				// 删除模拟移动层
				$proxy.remove();
				
				$(this).off("mousedown");
				$(this).off("mousemove");
			});
		}		
	});
})(jQuery);