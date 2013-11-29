<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sunrays.javarefbook.mlm.model.UserModel"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="./css/pmbm.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Multi Level Marketing</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<script src="utils/zapatec.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="reset.css" />
<link rel="stylesheet" type="text/css" href="style.css" />

<!-- basic Javascript file for the tree-->
<script src="zptree/src/tree.js" type="text/javascript"></script>
</head>
<body>
	<%!UserModel userModel = null;%>
	<div id="bg">
		<div id="logo">
			<h1>MLM</h1>
			<div>Multi Level Marketing</div>
		</div>
		<div id="wrap">
			<div id="nav">
				<ul>
					<li><a href="#">Home</a></li>
					<%
						userModel = (UserModel) session.getAttribute("user");
						if (userModel != null) {
					%>
					<li><a href="BaseLayout.jsp"><font color="#ffffff">
								Welcome&nbsp;<%=userModel.getFirstName()%>&nbsp;<%=userModel.getLastName()%></font>
					</a></li>
					<li><a href="http://www.sunrays.co.in">About us</a></li>
					<li><a href="http://www.sunrays.co.in">Site Map</a></li>
					<li><a href='<s:url action="MyProfile"/>'>MyProfile</a></li>
					<li><a href="LogoutCtl">Logout</a></li>
					<%
						} else {
					%>
					<li><a href="BaseLayout.jsp"><font color="#ffffff">
								Welcome</font> </a></li>
					<li><a href="http://www.sunrays.co.in">About us</a></li>
					<li><a href="http://www.sunrays.co.in">Site Map</a></li>
					<li><a href="#">MyProfile</a></li>
					<%
						}
					%>
				</ul>
			</div>
			<div id="header"></div>
			<!-- /header -->
			<div id="content">
				<div class="left float-l">
					<%
						userModel = (UserModel) session.getAttribute("user");
						if (userModel != null) {
					%>
					<jsp:include page="Menu.jsp"></jsp:include>
					<%
						} else {
							body = null;
					%>
					<jsp:include page="Login.jsp"></jsp:include>
					<%
						}
					%>

				</div>
				<div class="right folat-r">
					<%!String body = null;%>
					<%
						body = request.getParameter("body");
						if (body == null) {
							body = "Welcome.jsp";
						}
					%>
					<jsp:include page="<%=body%>" />
				</div>
			</div>
			<!-- /content -->
			<div id="xhtml">
				<div class="float-l">
					<div id="ftlink">
						<a href="#">Home</a>| <a href="http://www.sunrays.co.in">About
							us</a>| <a href="http://www.sunrays.co.in">Site Map</a>| <a
							href='<s:url action="MyProfile"/>'>MyProfile</a>
					</div>
					<p id="copyright">
						@ 2011. All Rights Reserved. <br /> Designed by <a
							href="http://www.sunrays.co.in">Sunrays</a>
					</p>
				</div>
			</div>
			<!-- /footer -->
		</div>
	</div>
</body>

</html>