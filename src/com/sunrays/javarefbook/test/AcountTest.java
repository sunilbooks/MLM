package com.sunrays.javarefbook.test;

import java.util.Date;

import com.sunrays.javarefbook.mlm.model.AccountModel;

public class AcountTest {
	public static void main(String[] args) throws Exception {
		AccountModel accountModel = new AccountModel();
//		accountModel.setId(1);
//		accountModel.setBalance(2000);
//		accountModel.setDateOfOpening(new Date());
//		accountModel.setLastTransactionDate(new Date());
//		accountModel.setUserName("Abhishek");
//		accountModel.setUserId(1001l);
		accountModel.nextPK();

	}

}
