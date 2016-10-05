<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; 2016</strong> All rights
    reserved.
  </footer>
<jsp:include page="controlSidebar.jsp" />

</div>  
<!-- ./wrapper start in header.jsp-->

<!-- jQuery UI 1.11.4 -->
<script src="resource/AdminLTE-2.3.3/bootstrap/js/jquery-ui1.11.4.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="resource/AdminLTE-2.3.3/bootstrap/js/bootstrap.min.js"></script>
<!-- Sparkline -->
<script src="resource/AdminLTE-2.3.3/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="resource/AdminLTE-2.3.3/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="resource/AdminLTE-2.3.3/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="resource/AdminLTE-2.3.3/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="resource/AdminLTE-2.3.3/bootstrap/js/moment2.11.2.min.js"></script>
<script src="resource/AdminLTE-2.3.3/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="resource/AdminLTE-2.3.3/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="resource/AdminLTE-2.3.3/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="resource/AdminLTE-2.3.3/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="resource/AdminLTE-2.3.3/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="resource/AdminLTE-2.3.3/dist/js/app.min.js"></script>

<script>
  	//设置选中菜单高亮
	var li = $(".breadcrumb li");
	var menu1 = $(li[0]).find("a").text();
	var menu2 = $(li[1]).text();
  	
  	$.each($(".sidebar-menu").find(".treeview"), function(){
  		if (menu1 == $(this).children("a:first").find("span").text()){
  			$(this).addClass("active");
  			$.each($(this).find("ul").find("li"), function(){
  				if (menu2 == $(this).find("a").text()){
  					$(this).addClass("active");
  					 return false;
  				}
  			});
  		}
  	});
</script>

</body>
</html>