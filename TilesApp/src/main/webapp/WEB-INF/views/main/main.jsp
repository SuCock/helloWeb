<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<div class="slider">
	<div>
		<img width="500px" src="images/고화질 컴퓨터 배경화면 (2).png" />
	</div>
	<div>
		<img width="500px" src="images/고화질 컴퓨터 배경화면 (5).png" />
	</div>
	<div>
		<img width="500px" src="images/고화질 컴퓨터 배경화면 (9).png" />
	</div>
</div>

<script>
	$('.slider').bxSlider({
		mode : 'fade',
		captions : true,
		slideWidth : 600
	});
</script>