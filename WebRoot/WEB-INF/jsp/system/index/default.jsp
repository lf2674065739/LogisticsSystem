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

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<!-- 百度echarts -->
<script src="plugins/echarts/echarts.min.js"></script>
</head>
<body class="no-skin">

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="hr hr-18 dotted hr-double"></div>
					<div class="row">
						<div class="col-xs-12">
						     
	                        <%
								String strXML = "";
	
								strXML += "<graph caption='当日统计量' xAxisName='2016-07-11' yAxisName='质量(T)' decimalPrecision='0' formatNumberScale='0'>";
								strXML += "<set name='计划量' value='46' color='AFD8F8'/>";
								strXML += "<set name='发货量' value='57' color='F6BD0F'/>";
								strXML += "<set name='收货量' value='71' color='8BBA00'/>";
								strXML += "<set name='结算量' value='49' color='FF8E46'/>";
								strXML += "</graph>";
								//Create the chart - Column 3D Chart with data from strXML variable using dataXML method
							%>
							
							<%
								String strXML1 = "";
	
								strXML1 += "<graph caption='当月统计量' xAxisName='2016-07' yAxisName='质量(T)' decimalPrecision='0' formatNumberScale='0'>";
								strXML1 += "<set name='计划量' value='343' color='AFD8F8'/>";
								strXML1 += "<set name='发货量' value='457' color='F6BD0F'/>";
								strXML1 += "<set name='收货量' value='371' color='8BBA00'/>";
								strXML1 += "<set name='结算量' value='371' color='FF8E46'/>";
								strXML1 += "</graph>";
								//Create the chart - Column 3D Chart with data from strXML variable using dataXML method
							%>
							<div class="alert alert-block alert-success">
								<button type="button" class="close" data-dismiss="alert">
									<i class="ace-icon fa fa-times"></i>
								</button>
								<i class="ace-icon fa fa-check green"></i>
								   <font style="font-size: 30px;">同泽宇所拉货物的统计</font>
							</div>
							<!-- 柱状图 -->
					    <div class="center">
							<div style="float:left;">
								<table border="0" width="50%">
									<tr>
										<td><jsp:include
												page="../../FusionChartsHTMLRenderer.jsp" flush="true">
												<jsp:param name="chartSWF" value="static/FusionCharts/Column3D.swf" />
												<jsp:param name="strURL" value="" />
												<jsp:param name="strXML" value="<%=strXML%>" />
												<jsp:param name="chartId" value="myNext" />
												<jsp:param name="chartWidth" value="800" />
												<jsp:param name="chartHeight" value="600" />
												<jsp:param name="debugMode" value="false" />
											</jsp:include></td>
									</tr>
								</table>
							</div>
							<div style="float:right;">
								<table border="0" width="50%">
									<tr>
										<td><jsp:include
												page="../../FusionChartsHTMLRenderer.jsp" flush="true">
												<jsp:param name="chartSWF" value="static/FusionCharts/Column3D.swf" />
												<jsp:param name="strURL" value="" />
												<jsp:param name="strXML" value="<%=strXML1%>" />
												<jsp:param name="chartId" value="myNext" />
												<jsp:param name="chartWidth" value="800" />
												<jsp:param name="chartHeight" value="600" />
												<jsp:param name="debugMode" value="false" />
											</jsp:include></td>
									</tr>
								</table>
							</div>
						</div> 
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->


		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$(top.hangge());
	</script>
<script type="text/javascript" src="static/ace/js/jquery.js"></script>
</body>
</html>