<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/leftSidebar.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			同步订单<small></small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:void(0);"><i class="fa fa-dashboard"></i>订单处理</a></li>
			<li class="active">同步订单</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="box">
			<div class="box-header"></div>
			<div class="box-body">
				<form action="manage/order/sync" method="POST">
					<button type="submit" class="btn btn-block btn-info btn-lg">开始同步</button>
				</form>
			</div>

			<!-- /.row -->
			<!-- Main row -->
			<!-- /.row (main row) -->
		</div>
	</section>
	<!-- /.content -->
</div>
<jsp:include page="../common/footer.jsp" />
