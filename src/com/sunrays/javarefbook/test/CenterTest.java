package com.sunrays.javarefbook.test;

import java.util.Iterator;
import java.util.List;

import com.sunrays.javarefbook.mlm.model.CenterModel;

public class CenterTest {
	public static void main(String[] args) throws Exception {
		CenterModel centerModel = new CenterModel();
		// centerModel.setId(1);

		// centerModel.setName("i");
		// centerModel.setPermissionId("k"); centerModel.setPhoneNo("h");
		// centerModel.setLoginId("b"); centerModel.setPassword("j");

		List list = centerModel.search();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			centerModel = (CenterModel) iterator.next();
			System.out.println(centerModel.getName());
		}

	}
}
