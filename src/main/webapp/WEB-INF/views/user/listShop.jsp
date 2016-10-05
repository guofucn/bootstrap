<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/leftSidebar.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			店铺设置<small></small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:void(0);"><i class="fa fa-dashboard"></i>用户设置</a></li>
			<li class="active">店铺设置</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="box">
			<div class="box-body">
				<div class="box-header">
					<h3 class="box-title">店铺列表</h3>
					<div class="btn-group pull-right">
						<a href="manage/user/editShop"><button type="button" class="btn btn-info btn-sm">增加店铺</button></a>
					</div>
				</div>
				<div class="box-body table-responsive no-padding">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>店铺名称</th>
								<th>地区</th>
								<th>操作</th>
							</tr>
							<c:forEach var="shop" items="${shops}">
								<tr>
									<td><c:out value="${shop.shopName}"></c:out></td>
									<td><c:out value="${shop.country}-${shop.marketPlaceId}"></c:out></td>
									<td><a href="manage/user/editShop?id=${shop.id}"><button type="button" class="btn btn-info btn-sm">修改</button></a>
										<button type="button" class="btn btn-info btn-sm" onclick="showMsg(this)" shopId ="${shop.id}">删除</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">提示</h4>
							</div>
							<div class="modal-body">真的要删除吗?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
								<a id="btn-del" href="manage/user/delShop?id=${shop.id}"><button type="button" class="btn btn-info">删除</button></a>
							</div>
						</div>
					</div>
				</div>

			</div>

			<!-- /.row -->
			<!-- Main row -->
			<!-- /.row (main row) -->
		</div>
	</section>
	<!-- /.content -->
</div>
<script>
	function showMsg(self){
		$("#btn-del").attr("href", "manage/user/delShop?id=" + $(self).attr("shopId"));
		$('#myModal').modal();
	}
</script>
<jsp:include page="../common/footer.jsp" />
