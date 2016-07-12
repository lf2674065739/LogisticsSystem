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
					
					<form action="realorderinfo/${msg }.do" name="realorderinfoForm" id="realorderinfoForm" method="post">
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
								<td style="width:70px;text-align: right;padding-top: 13px;">订单ID:</td>
								<td><input type="hidden" name="ORDERID" id="ORDERID" value="${pd.ORDERID}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">订单号:</td>
								<td><input type="text" name="ORDERNUM" id="ORDERNUM" value="${pd.ORDERNUM}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
						  <tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">车辆ID:</td>
								<td><input type="text" name="CARID" id="CARID" value="${pd.CARID}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">司机ID:</td>
								<td><input type="text" name="DRIVERID" id="DRIVERID" value="${pd.DRIVERID}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">订单货物:</td>
								<td><input type="text" name="ORDERGOODS" id="ORDERGOODS" value="${pd.ORDERGOODS}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">货主方货物重量:</td>
								<td><input type="text" name="SHIPPERGOODSWEIGHT" id="SHIPPERGOODSWEIGHT" value="${pd.SHIPPERGOODSWEIGHT}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">收货方货物重量:</td>
								<td><input type="text" name="RECEIPTGOODSWEIGHT" id="RECEIPTGOODSWEIGHT" value="${pd.RECEIPTGOODSWEIGHT}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">订单生成时间:</td>
								<td><input type="text" name="ORDERCREATEDATE" id="ORDERCREATEDATE" value="${pd.ORDERCREATEDATE}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">订单失效时间:</td>
								<td><input type="text" name="ORDERFAILUREDATE" id="ORDERFAILUREDATE" value="${pd.ORDERFAILUREDATE}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">订单状态:</td>
								<td><input type="text" name="ORDERSTATUS" id="ORDERSTATUS" value="${pd.ORDERSTATUS}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">物流ID:</td>
								<td><input type="text" name="LOGISTICSID" id="LOGISTICSID" value="${pd.LOGISTICSID}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">运费:</td>
								<td><input type="text" name="FREIGHT" id="FREIGHT" value="${pd.FREIGHT}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:70px;text-align: right;padding-top: 13px;">完成时间:</td>
								<td><input type="text" name="FINISHTIME" id="FINISHTIME" value="${pd.FINISHTIME}" maxlength="50" placeholder="这里输入英文" title="英文" style="width:98%;"/></td>
							</tr>
							
							
							<tr>
								<td class="center" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="saveT();">保存</a>
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
		function saveT(){
					
		    $("#realorderinfoForm").submit();
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