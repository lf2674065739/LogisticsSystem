<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<script type="text/javascript">
    function load(){
    	$("#CHECKIN").val(4);
    }
	function setCheck(value){
		$("#CHECKIN").val(value);
	}
</script>
</head>
<body class="no-skin" onload="load()">
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
								<form action="appUser/${msg }.do" name="appUserCheckForm" id="appUserCheckForm" method="post">
									<%-- <input type="hidden" name="USER_ID" id="user_id" value="${pd.USER_ID }"/> --%>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<%-- <c:if test="${fx != 'head'}">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">角色:</td>
											<td id="juese">
											<select class="chosen-select form-control" name="ROLE_ID" id="role_id" data-placeholder="请选择角色" style="vertical-align:top;" style="width:98%;" >
											<option value=""></option>
											<c:forEach items="${roleList}" var="role">
												<option value="${role.ROLE_ID }" <c:if test="${role.ROLE_ID == pd.ROLE_ID }">selected</c:if>>${role.ROLE_NAME }</option>
											</c:forEach>
											</select>
											</td>
										</tr>
										</c:if>
										<c:if test="${fx == 'head'}">
											<input name="ROLE_ID" id="role_id" value="${pd.ROLE_ID }" type="hidden" />
										</c:if> --%>
										<input type="hidden" name="USERID" id="USERID" value="${pd.USERID}"/>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">姓名:</td>
											<td><input type="text" name="NAME" id="NAME" maxlength="32" value="${pd.NAME }" placeholder="这里输入用户名" title="用户名" style="width:98%;"/></td>
										</tr>
										<tr>
										    <td style="width:120px;text-align: right;padding-top: 13px;">角色:</td>
											<td id="juese">
												<select class="chosen-select form-control" name="ROLEID" id="ROLEID" data-placeholder="请选择角色" style="vertical-align:top;" style="width:98%;" >
												<option value=""></option>
												<c:forEach items="${appRoleList}" var="appRole">
													<option value="${appRole.ROLEID }" <c:if test="${appRole.ROLEID == pd.ROLEID }">selected</c:if>>${appRole.ROLENAME }</option>
												</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">手机号:</td>
											<td><input type="text" name="PHONE" id="PHONE" value="${pd.PHONE }"  maxlength="32" placeholder="确认密码" title="确认密码" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">身份证号:</td>
											<td><input type="text" name="CARDID" id="CARDID"  value="${pd.CARDID }"  maxlength="32" placeholder="这里输入区域ID" title="区域ID" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">身份证照片:</td>
											<td>
											    <img src="${pageContext.request.contextPath}/images/${pd.CARDPHOTOPATH}" height="200" width="350" alt="未上传"/>
											    
											    <%-- <c:if test="${pd == null || pd.CARDPHOTOPATH == '' || pd.CARDPHOTOPATH == null }">
												    <img src="${pageContext.request.contextPath}/images/${pd.CARDPHOTOPATH}" height="200" width="350"/>
												</c:if> --%>
											</td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">驾驶证号:</td>
											<td><input type="text" name="LICENSEID" id="LICENSEID"  value="${pd.LICENSEID }"  maxlength="32" placeholder="这里输入区域ID" title="区域ID" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">驾驶证照片:</td>
											<td>
											    <img src="${pageContext.request.contextPath}/images/${pd.LICENSEPHOTOPATH}" height="200" width="350" alt="未上传"/>
											    <%-- <c:if test="${pd == null || pd.LICENSEPHOTOPATH == '' || pd.LICENSEPHOTOPATH == null }">
												    <img src="<%=basePath%>uploadFiles/uploadImgs/${pd.LICENSEPHOTOPATH}" height="200" width="350"/>
												</c:if> --%>
											</td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">法人身份证号:</td>
											<td><input type="text" name="LEGALPERSONCARDID" id="LEGALPERSONCARDID"  value="${pd.LEGALPERSONCARDID }"  maxlength="32" placeholder="这里输入区域ID" title="区域ID" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">法人身份证照片:</td>
											<td>
											    <img src="${pageContext.request.contextPath}/images/${pd.LEGALPERSONCARDPHOTOPATH}" height="200" width="350" alt="未上传"/>
											    <%-- <c:if test="${pd == null || pd.LEGALPERSONCARDPHOTOPATH == '' || pd.LEGALPERSONCARDPHOTOPATH == null }">
												    <img src="<%=basePath%>uploadFiles/uploadImgs/${pd.LEGALPERSONCARDPHOTOPATH}" height="200" width="350"/>
												</c:if> --%>
											</td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">营业执照:</td>
											<td><input type="text" name="LEGALPERSONCARDID" id="LEGALPERSONCARDID"  value="${pd.LEGALPERSONCARDID }"  maxlength="32" placeholder="这里输入区域ID" title="区域ID" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:120px;text-align: right;padding-top: 13px;">营业执照照片:</td>
											<td>
											    <img src="${pageContext.request.contextPath}/images/${pd.LEGALPERSONCARDPHOTOPATH}" height="200" width="350" alt="未上传"/>
											    <%-- <c:if test="${pd == null || pd.LEGALPERSONCARDPHOTOPATH == '' || pd.LEGALPERSONCARDPHOTOPATH == null }">
												    <img src="<%=basePath%>uploadFiles/uploadImgs/${pd.LEGALPERSONCARDPHOTOPATH}" height="200" width="350"/>
												</c:if> --%>
											</td>
										</tr>
									    <%--<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">上级机构:</td>
											<td><input type="email" name="ORGID" id="ORGID"  value="${pd.ORGID }" maxlength="32" placeholder="这里输入邮箱" title="邮箱" onblur="hasE('${pd.USERNAME }')" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">车辆:</td>
											<td><input type="text" name="CARID" id="CARID"value="${pd.CARID }" placeholder="这里输入车辆ID" maxlength="64" title="车辆ID" style="width:98%;"/></td>
										</tr> --%>
										<tr>
										    <td style="width:120px;text-align: right;padding-top: 13px;">审核状态:</td>
											<td>
												<label style="float:left;padding-left: 20px;"><input class="ace" name="form-field-radio" id="form-field-radio1" onclick="setCheck('4');" checked="checked" type="radio" value="2"><span class="lbl">通过</span></label>
												<label style="float:left;padding-left: 40px;"><input class="ace" name="form-field-radio" id="form-field-radio2" onclick="setCheck('3');" type="radio"><span class="lbl">未通过</span></label>
											    <input type="hidden" name="CHECKIN" id="CHECKIN" value="${pd.CHECKIN}"/>
											</td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
											</td>
										</tr>
									</table>
									</div>
									<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
								</form>
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
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
</body>
<script type="text/javascript">
	$(top.hangge());
	$(document).ready(function(){
		if($("#user_id").val()!=""){
			$("#loginname").attr("readonly","readonly");
			$("#loginname").css("color","gray");
		}
	});
	//保存
	function save(){
		$("#appUserCheckForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	function ismail(mail){
		return(new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
		}
	
	//判断用户名是否存在
	function hasU(){
		var USERNAME = $.trim($("#loginname").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasU.do',
	    	data: {USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#userForm").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				 }else{
					$("#loginname").css("background-color","#D16E6C");
					setTimeout("$('#loginname').val('此用户名已存在!')",500);
				 }
			}
		});
	}
	
	//判断邮箱是否存在
	function hasE(USERNAME){
		var EMAIL = $.trim($("#EMAIL").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasE.do',
	    	data: {EMAIL:EMAIL,USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" != data.result){
					 $("#EMAIL").tips({
							side:3,
				            msg:'邮箱 '+EMAIL+' 已存在',
				            bg:'#AE81FF',
				            time:3
				        });
					 $("#EMAIL").val('');
				 }
			}
		});
	}
	
	//判断编码是否存在
	function hasN(USERNAME){
		var NUMBER = $.trim($("#NUMBER").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasN.do',
	    	data: {NUMBER:NUMBER,USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" != data.result){
					 $("#NUMBER").tips({
							side:3,
				            msg:'编号 '+NUMBER+' 已存在',
				            bg:'#AE81FF',
				            time:3
				        });
					 $("#NUMBER").val('');
				 }
			}
		});
	}
	$(function() {
		//下拉框
		if(!ace.vars['touch']) {
			$('.chosen-select').chosen({allow_single_deselect:true}); 
			$(window)
			.off('resize.chosen')
			.on('resize.chosen', function() {
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				});
			}).trigger('resize.chosen');
			$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
				if(event_name != 'sidebar_collapsed') return;
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				});
			});
			$('#chosen-multiple-style .btn').on('click', function(e){
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
				 else $('#form-field-select-4').removeClass('tag-input-style');
			});
		}
	});
</script>
</html>