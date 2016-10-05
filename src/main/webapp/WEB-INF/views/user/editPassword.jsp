<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/leftSidebar.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			修改密码<small></small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="javascript:void(0);"><i class="fa fa-dashboard"></i>用户设置</a></li>
			<li class="active">修改密码</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="box">
			<div class="box-body ">
				<div class="col-md-4">
					<form class="form-horizontal" action="manage/user/editPassword" method="POST">
						<div class="box-body">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-4 control-label">旧密码</label>

								<div class="col-sm-8">
									<input type="password"  name="oldPassword" class="form-control" placeholder="请输入旧密码" maxlength=10>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3"  class="col-sm-4 control-label">新密码</label>

								<div class="col-sm-8">
									<input type="password" name="newPassword" class="form-control" placeholder="请输入新密码" maxlength=10>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-4 control-label">确认新密码</label>

								<div class="col-sm-8">
									<input type="password" name="newPassword2" class="form-control" placeholder="再次输入新密码" maxlength=10>
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
