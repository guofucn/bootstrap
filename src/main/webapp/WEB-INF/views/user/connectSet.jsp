<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/leftSidebar.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			连接设置<small><a href="https://developer.amazonservices.com.cn/index.html" target="blank">获取连接参数</a></small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:void(0);"><i class="fa fa-dashboard"></i>用户设置</a></li>
			<li class="active">连接设置</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="box">
			<div class="box-body">
				<div class="col-md-4">
					<form class="form-horizontal" action="manage/user/connectSet" method="POST">
						<div class="box-body">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-4 control-label">卖家编号</label>

								<div class="col-sm-8">
									<input name="sellerId" class="form-control" maxlength=20 value="${connectSet.sellerId}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">开发商账号</label>

								<div class="col-sm-8">
									<input name="developerId" class="form-control" maxlength=20 value="${connectSet.developerId}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">AWS 访问键编号</label>

								<div class="col-sm-8">
									<input type="password" name="accessKey" class="form-control" maxlength=30 value="${connectSet.accessKey}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">密钥</label>

								<div class="col-sm-8">
									<input type="password" name="secretKey" class="form-control" maxlength=50 value="${connectSet.secretKey}">
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
