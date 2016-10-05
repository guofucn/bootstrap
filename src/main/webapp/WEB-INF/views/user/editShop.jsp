<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/leftSidebar.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			增加店铺<small></small>
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
			<div class="box-body ">
				<div class="col-md-4">
					<form class="form-horizontal" action="manage/user/editShop" method="POST">
						<input type="hidden" name="id" value="${shop.id}" />
						<div class="box-body">
							<div class="form-group">
								<label for="shopName" class="col-sm-4 control-label">店铺名称</label>
								<div class="col-sm-8">
									<input name="shopName" class="form-control" maxlength=30 value="${shop.shopName}">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label">地区</label>
								<div class="col-sm-8">
									<select name="placeId" class="form-control select2 select2-hidden-accessible" tabindex="-1" aria-hidden="true">
										<option value="0" <c:choose>
													<c:when test="${shop.placeId==0}">
														selected="selected"
													</c:when>
												</c:choose>>请选择</option>
										<c:forEach var="marketPlace" items="${marketPlaces}">
											<option value="${marketPlace.id}" <c:choose>
													<c:when test="${marketPlace.id==shop.placeId}">
														selected="selected"
													</c:when>
												</c:choose> >${marketPlace.country}-${marketPlace.marketPlaceId}
											</option>
										</c:forEach>
									</select>
								</div>
							</div>

						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<button type="submit" class="btn btn-info pull-right">保存</button>
						</div>
						<!-- /.box-footer -->
					</form>
				</div>
			</div>

			<!-- /.row -->
			<!-- Main row -->
			<!-- /.row (main row) -->
		</div>
	</section>
	<!-- /.content -->
</div>
<jsp:include page="../common/footer.jsp" />
