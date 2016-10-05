<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>亚马的逊</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/bootstrap/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/bootstrap/css/font-awesome4.5.0.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/bootstrap/css/ionicons2.0.1.min.css">

<!-- Theme style -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/plugins/iCheck/flat/blue.css">
<!-- jvectormap -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet" href="resource/AdminLTE-2.3.3/plugins/daterangepicker/daterangepicker-bs3.css">
<!-- bootstrap wysihtml5 - text editor -->
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="resource/AdminLTE-2.3.3/bootstrap/js/html5shiv3.7.3.min.js"></script>
  <script src="resource/AdminLTE-2.3.3/bootstrap/js/respond1.4.2.min.js"></script>
  <![endif]-->
<!-- jQuery 2.2.0 -->
<script src="resource/AdminLTE-2.3.3/plugins/jQuery/jQuery-2.2.0.min.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="javascript:void(0);" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> 
			<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices --> <span
				class="logo-lg"><b>聚才软件</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle navigation</span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li><a href="manage/user/logout"><i class="fa fa-sign-out"></i><span>&nbsp;退出</span></a></li>
					</ul>
				</div>
			</nav>
		</header>