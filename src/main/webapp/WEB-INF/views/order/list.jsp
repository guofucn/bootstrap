<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jc.ssm.util.DateTimeUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/leftSidebar.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			订单列表<small></small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:void(0);"><i class="fa fa-dashboard"></i>订单处理</a></li>
			<li class="active">订单列表</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="box">
			<div class="box-header">
				<div class="row">
					<div class="col-md-9">
						<form class="form-inline" action="manage/order/list" method="POST">
							<div class="form-group">
								<label>日期从</label> <input type="text" class="form-control" name="startDate" onFocus="WdatePicker({readOnly:true})" value="${startDate}">
							</div>
							<div class="form-group">
								<label>到</label> <input type="text" name="endDate" class="form-control" id="exampleInputEmail2" onFocus="WdatePicker({readOnly:true})" value="${endDate}">
							</div>
							<div class="form-group">
								<label>订单状态</label> <select name="status" class="form-control" name="status">
									<option value="all" <c:choose>
													<c:when test="${status=='全部'}">
														selected="selected"
													</c:when>
												</c:choose>>全部</option>
									<option value="Pending" <c:choose>
													<c:when test="${status=='Pending'}">
														selected="selected"
													</c:when>
												</c:choose>>Pending</option>
									<option value="Canceled" <c:choose>
													<c:when test="${status=='Canceled'}">
														selected="selected"
													</c:when>
												</c:choose>>Canceled</option>
									<option value="Shipped" <c:choose>
													<c:when test="${status=='Shipped'}">
														selected="selected"
													</c:when>
												</c:choose>>Shipped</option>
								</select>
							</div>
							<button type="submit" class="btn btn-info">查询</button>
						</form>
					</div>
				</div>
			</div>
			<div class="box-body table-responsive no-padding">
				<table class="table table-hover" id="salesOrderList">
					<tbody>
						<tr>
							<th style="display: none;">id</th>
							<th>AmazoneOrderId</th>
							<th>SellerOrderId</th>
							<th>PurchaseDate</th>
							<th>OrderStatus</th>
							<th>AFN</th>
							<th>SalesChannel</th>
							<th>Amount</th>
							<th>ItemShipped</th>
							<th>MarketPlaceId</th>
							<th>操作</th>
						</tr>
						<c:forEach var="salesOrder" items="${salesOrders}">
							<tr>
								<td style="display: none;">${salesOrder.id}</td>
								<td>${salesOrder.amazonOrderId}</td>
								<td>${salesOrder.sellerOrderId}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${salesOrder.purchaseDate}" /></td>
								<td>${salesOrder.orderStatus}</td>
								<td>${salesOrder.fulfillmentChannel}</td>
								<td>${salesOrder.salesChannel}</td>
								<td>${salesOrder.amount}&nbsp;${salesOrder.currencyCode}</td>
								<td>${salesOrder.numberOfItemsShipped}/${salesOrder.numberOfItemsUnshipped}</td>
								<td>${salesOrder.marketplaceId}</td>
								<td><div class="box-tools">
										<button type="button" class="btn btn-box-tool" onclick="showOrderDetail(this);">
											<i class="fa fa-plus"></i>
										</button>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="box-footer">
				<div class="box-tools">
					<div class="pull-left">
						共<strong>${rowCount}</strong>行
					</div>
					<c:choose>
						<c:when test="${pagination!=null}">
								${pagination}
						</c:when>
					</c:choose>
				</div>
			</div>

			<div class="detailTable hidden">
				<div class="detailDiv ">
					<table class="table">
						<tr>
							<th>ASIN</th>
							<th>SellerSKU</th>
							<th>QuantityOrdered</th>
							<th>ItemPrice</th>
							<th>ShippingPrice</th>
							<th>GiftWrapPrice</th>
							<th>ItemTax</th>
							<th>ShippingTax</th>
							<th>GiftWrapTax</th>
							<th>ShippingDiscount</th>
							<th>PromotionDiscount</th>
						</tr>
					</table>
				</div>
			</div>
			<!-- /.row -->
			<!-- Main row -->
			<!-- /.row (main row) -->
		</div>
	</section>
	<!-- /.content -->
</div>

<script src="<%=basePath%>resource/My97DatePicker/WdatePicker.js"></script>
<script>
	function showOrderDetail(btn) {
		var currRow = $(btn).parent().parent().parent();
		var salesOrderId = $(currRow).find("td:first").text();
		var nextRow = $("<tr class='orderDetailRow'><td colspan='10' style='background-color:#f4f4f4;'></td></tr>");
		var detailTable = $(".detailTable");
		nextRow.find("td").append($(".detailTable").html());
		var icon = $(btn).find("i");
		if ($(icon).hasClass("fa-plus")) {
			$.ajax({
				url : "manage/api/getOrderDetail",
				type : "POST",
				dataType : "JSON",
				data : {
					salesOrderId : salesOrderId
				},
				success : function(data, textStatus) {
					if (data.orderDetail){
						$("#salesOrderList").find(".fa-minus").removeClass("fa-minus").addClass("fa-plus");
						$(icon).removeClass("fa-plus");
						$(icon).addClass("fa-minus");
						$(".orderDetailRow").remove();
						$(currRow).after(nextRow);
						$(nextRow).find(".detailDiv").hide();
						
						orderDetail = data.orderDetail;
						var table = $(nextRow).find("table");
						for (var i = 0; i < orderDetail.length; i++){
							var row = "<tr><td colspan='11'><strong>" +orderDetail[i].title + "</strong></td></tr>";
							$(table).append(row);
							row = "<tr><td>" 
								+ orderDetail[i].asin + "</td><td>" 
								+ orderDetail[i].sellerSKU + "</td><td>" 
								+ orderDetail[i].quantityOrdered + "</td><td>"
								+ (orderDetail[i].itemPrice ? orderDetail[i].itemPrice : "") + "</td><td>"
								+ (orderDetail[i].shippingPrice ? orderDetail[i].shippingPrice : "") + "</td><td>"
								+ (orderDetail[i].giftWrapPrice ? orderDetail[i].giftWrapPrice : "") + "</td><td>"
								+ (orderDetail[i].itemTax ? orderDetail[i].itemTax : "")+ "</td><td>"
								+ (orderDetail[i].shippingTax ? orderDetail[i].shippingTax : "") + "</td><td>"
								+ (orderDetail[i].giftWrapTax ? orderDetail[i].giftWrapTax : "") + "</td><td>"
								+ (orderDetail[i].shippingDiscount ? orderDetail[i].shippingDiscount : "") + "</td><td>"
								+ (orderDetail[i].promotionDiscount ? orderDetail[i].promotionDiscount : "") + "</td></tr>"
							$(table).append(row);
						}
						//$(nextRow).find(".detailDiv").slideToggle();
						$(nextRow).find(".detailDiv").slideDown(200);
					}
				}
			});
		} else {
			$(icon).removeClass("fa-minus");
			$(icon).addClass("fa-plus");
			$(".orderDetailRow").remove();
		}
	}
	function getOrderDetail(salesOrderId) {
		$.ajax({
			url : "manage/api/getOrderDetail2",
			type : "POST",
			dataType : "JSON",
			data : {
				salesOrderId : salesOrderId
			},
			success : function(data, textStatus) {
				console.log(date);
			}
		});
	}
</script>
<jsp:include page="../common/footer.jsp" />
