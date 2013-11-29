package com.sunrays.javarefbook.test;

import com.sunrays.javarefbook.mlm.model.GroupModel;

public class GroupTest {
public static void main(String[] args) throws Exception {
	GroupModel groupModel=new GroupModel();
	groupModel.setId(2);
	groupModel.setGroupId(1000);
	groupModel.setUserId(11);
	groupModel.setNoOfId(100);
	groupModel.findByPK(1);
	
}
}
