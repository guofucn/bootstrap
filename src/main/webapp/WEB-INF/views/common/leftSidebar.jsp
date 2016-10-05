<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.jc.ssm.model.User"%>
<%
	User user = (User) session.getAttribute("user");
	String userName = "";
	if (user != null) {
		userName = user.getUserName();
	}
%>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<div class="user-panel">
			<div class="pull-left image">
				<img src="resource/AdminLTE-2.3.3/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<%
						out.print(userName);
					%>
				</p>
				<a href="javascript:void(0);"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">导航</li>
			<li class="treeview"><a href="#"> <i class="fa fa-table"></i> <span>订单处理</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="manage/order/sync"><i class="fa fa-circle-o"></i>同步订单</a></li>
					<li><a href="manage/order/list"><i class="fa fa-circle-o"></i>订单列表</a></li>
					<li><a href="manage/order/check"><i class="fa fa-circle-o"></i>待审核订单</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-table"></i> <span>用户设置</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="manage/user/userInfo"><i class="fa fa-circle-o"></i>账户设置</a></li>
					<li><a href="manage/user/editPassword"><i class="fa fa-circle-o"></i>修改密码</a></li>
					<li><a href="manage/user/connectSet"><i class="fa fa-circle-o"></i>连接设置</a></li>
					<li><a href="manage/user/listShop"><i class="fa fa-circle-o"></i>店铺设置</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
