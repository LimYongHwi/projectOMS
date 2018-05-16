

$(document).ready(function(){
	
	
	var menuPos = parseInt($('#MyMenuBox').css('top'));
	
	$(window).scroll(function(){
		
	var scrollTop = $(window).scrollTop();
	var newPos = scrollTop + menuPos + "px";
	
	$('#MyMenuBox').stop().animate({
		'top':newPos
	},{
		'duration' :500,
		'easing': 'easeInOutBack',
		'complete': function(){
			console.log('이동완료');
		}
	});
	
	}).scroll();


	
	function changeText(cont1,cont2,speed){
		var Otext=cont1.text();
		var Ocontent=Otext.split("");
		var i=0;
		function show(){
			if(i<Ocontent.length)
			{		
				cont2.append(Ocontent[i]);
				i=i+1;
			};
		};
			var Otimer=setInterval(show,speed);	
	};
	changeText($("h1"),$(".p2"),150);
// 	clearInterval(Otimer);
	});
	

