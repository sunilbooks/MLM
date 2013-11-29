<%@page import="com.sunrays.javarefbook.mlm.model.RoleModel"%>
<%@page import="com.sunrays.javarefbook.mlm.model.UserModel"%>
<ul>
	<ul id="designtree">
		<%
			UserModel userModel = (UserModel) session.getAttribute("user");

			if (userModel != null) {
				RoleModel roleModel = userModel.getRoleModel();
				if ("Admin".equals(roleModel.getName())) {
		%>

		<li>Admin
			<ul>
				<li><a href="CenterCtl.do">Center</a></li>
				<li><a href="CenterListCtl.do">CenterList</a></li>
				<li><a href="GroupCtl.do">Group</a></li>
				<li><a href="GroupListCtl.do">GroupList</a></li>
				<li><a href="ItemCtl.do">Item</a></li>
				<li><a href="ItemListCtl.do">ItemList</a></li>
				<li><a href="OrganizationCtl.do">Organization</a></li>
				<li><a href="OrganizationListCtl.do">OrganizationList</a></li>
				<li><a href="UserCtl.do">User</a></li>
				<li><a href="UserListCtl.do">UserList</a></li>
				<li><a href="RoleCtl.do">Role</a></li>
				<li><a href="RoleCtl.do">RoleList</a></li>
				<li><a href="MajorCategoryCtl.do">MajorCategory</a></li>
				<li><a href="MajorCategoryListCtl.do">MajorCategoryList</a></li>
				<li><a href="MinerCategoryCtl.do">MinerCategory</a></li>
				<li><a href="MinerCategoryListCtl.do">MinerCategorylist</a></li>
				<li><a href="PlanCtl.do">Plan</a></li>
				<li><a href="PlanListCtl.do">PlanList</a></li>
			</ul>
		</li>
		<li>Member
			<ul>
				<li><a href="Account.jsp" />Account</a></li>
			</ul>
		</li>
		<li>Center
			<ul>
				<li><a href="MyProfileCtl.do" />MyProfile</a></li>
			</ul>
		</li>
		<%
			} else if ("Member".equals(roleModel.getName())) {
		%>
		<li>Member
			<ul>
				<li><a href="Account.jsp" />Account</a></li>
			</ul>
		</li>
		<li>Center
			<ul>
				<li><a href="MyProfileCtl.do" />MyProfile</a></li>
			</ul>
		</li>
		<%
			} else {
		%>
		<li>Center
			<ul>
				<li><a href="MyProfileCtl.do" />MyProfile</a></li>
			</ul>
		</li>
		<%
			}
			}
		%>
	</ul>
</ul>
<script type="text/javascript">
	new Zapatec.Tree({
		tree : "designtree",
		expandOnLabelClick : true,
		initLevel : 0,
		theme : "default"
	});
</script>