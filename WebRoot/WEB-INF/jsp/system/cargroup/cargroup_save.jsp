<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<!-- jsp文件头和头部 -->
		<%@ include file="../../system/index/top.jsp"%>
		
	
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="cargroup/${msg }.do" name="cargroupForm" id="cargroupForm" method="post">
						<input type="hidden" name="DICTIONARIES_ID" id="DICTIONARIES_ID" value="${pd.DICTIONARIES_ID}"/>
						<input type="hidden" name="PARENT_ID" id="PARENT_ID" value="${null == pd.PARENT_ID ? DICTIONARIES_ID:pd.PARENT_ID}"/>
						<div id="zhongxin">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">上级:</td>
								<td>
									<div class="col-xs-4 label label-lg label-light arrowed-in arrowed-right">
										<b>${null == pds.NAME ?'(无) 此项为顶级':pds.NAME}</b>
									</div>
								</td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">组ID:</td>
								<td><input type="hidden" name="GROUPID" id="GROUPID" value="${pd.GROUPID}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">组名称:</td>
								<td><input type="text" name="GROUPNAME" id="GROUPNAME" value="${pd.GROUPNAME}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
						        <tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">组描述:</td>
								<td><input type="text" name="GROUPDES" id="GROUPDES" value="${pd.GROUPDES}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">组排序:</td>
								<td><input type="text" name="GROUPSORT" id="GROUPSORT" value="${pd.GROUPSORT}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td colspan="10" class="center"><p class="text-warning bigger-110 orange">排查表：删除此条数据时会去此表查询是否被占用(是:禁止删除)</p></td>
							</tr>
							<tr>
								<td class="center" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="saveE();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
						
					</form>
	
					<div id="zhongxin2" class="center" style="display:none"><img src="static/images/jzx.gif" style="width: 50px;" /><br/><h4 class="lighter block green"></h4></div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function saveE(){
					
		    $("#cargroupForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
			
		}
		
		//判断编码是否存在
		function hasBianma(){
			var BIANMA = $.trim($("#BIANMA").val());
			if("" == BIANMA)return;
			$.ajax({
				type: "POST",
				url: '<%=basePath%>dictionaries/hasBianma.do',
		    	data: {BIANMA:BIANMA,tm:new Date().getTime()},
				dataType:'json',
				cache: false,
				success: function(data){
					 if("success" == data.result){
					 }else{
						$("#BIANMA").tips({
							side:1,
				            msg:'编码'+BIANMA+'已存在,重新输入',
				            bg:'#AE81FF',
				            time:5
				        });
						$('#BIANMA').val('');
					 }
				}
			});
		}
		</script>
</body>
</html>