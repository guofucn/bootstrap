<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/leftSidebar.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1><a href="javascript:history.go(-1);"><i class="fa fa-fw fa-reply"></i>退回</a></h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="callout callout-danger">
			<h4>${errMsg}</h4>
		</div>
	</section>
	<!-- /.content -->
</div>
<jsp:include page="../common/footer.jsp" />
