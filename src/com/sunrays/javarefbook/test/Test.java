package com.sunrays.javarefbook.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sunrays.javarefbook.mlm.model.CenterModel;
import com.sunrays.javarefbook.mlm.model.ItemModel;
import com.sunrays.javarefbook.mlm.model.MajorCategoryModel;
import com.sunrays.javarefbook.mlm.model.MinorCategoryModel;
import com.sunrays.javarefbook.mlm.model.OrganizationModel;
import com.sunrays.javarefbook.mlm.model.PlanModel;
import com.sunrays.javarefbook.mlm.model.RoleModel;
import com.sunrays.javarefbook.mlm.model.SystemTestingModel;
import com.sunrays.javarefbook.mlm.model.TransactionModel;
import com.sunrays.javarefbook.mlm.model.UserModel;
import com.sunrays.javarefbook.mlm.model.UserProfileModel;

public class Test {
	public static void main(String[] args) throws Exception {
		/*
		 * ItemModel itemModel = new ItemModel(); itemModel.setId(1);
		 * itemModel.setItemName("bllezer"); itemModel.setMajorCategory("aaaa");
		 * itemModel.setMinorCategory("CCCC"); itemModel.setItemSize(38);
		 * itemModel.findByPK(1);
		 */

		/*
		 * MajorCategoryModel majorCategoryModel = new MajorCategoryModel();
		 * majorCategoryModel.setId(1);
		 * majorCategoryModel.setCategoryCode("123");
		 * majorCategoryModel.setName("major"); majorCategoryModel.findByPK(1);
		 */

		/*
		 * MinorCategoryModel minorCategoryModel = new MinorCategoryModel();
		 * minorCategoryModel.setId(1);
		 * minorCategoryModel.setCategoryCode("1234");
		 * minorCategoryModel.setMajorCategoryId("a6b5");
		 * minorCategoryModel.setName("sultan"); minorCategoryModel.findByPK(1);
		 */

		/*
		
		 * organizationModel.setId(1); organizationModel.setName("raja");
		 * organizationModel.setAddress("patnipura");
		 * organizationModel.setEmail("raja@gmail.com");
		 * organizationModel.setPhoneNo("999999990");
		 * organizationModel.setFilepath("c/img");
		 * organizationModel.setLogo("aaaa"); organizationModel.setUrl("11111");
		 * organizationModel.setFaxNo("22222"); 
		  */
		  OrganizationModel organizationModel=new OrganizationModel();
		  List list = organizationModel.search();
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				organizationModel = (OrganizationModel) iterator.next();
				System.out.println(organizationModel.getName());
		 
		 
			}
			/*
		 * PlanModel planModel=new PlanModel(); planModel.setId(1);
		 * planModel.setLevel1(1); planModel.setLevel2(2);
		 * planModel.setLevel3(3); planModel.setLevel4(4);
		 * planModel.setLevel5(5); planModel.setLevel6(6);
		 * planModel.setLevel7(7); planModel.setLevel8(8);
		 * planModel.setLevel9(9); planModel.setLevel10(10);
		 * planModel.setName("Hactor"); planModel.findByPK(1);
		 */

		/*
		 * RoleModel roleModel=new RoleModel(); roleModel.setId(1);
		 * roleModel.setName("zues"); roleModel.findByPK(1);
		 */

		/*
		 * SystemTestingModel systemTestingModel=new SystemTestingModel();
		 * systemTestingModel.setId(1);
		 * systemTestingModel.setEmailNotification("gotIt");
		 * systemTestingModel.setSmsNotification("gotIit");
		 * systemTestingModel.setNoOfRecord(100);
		 * systemTestingModel.setTheme("Red"); systemTestingModel.findByPK(1);
		 */
		/*
		 * TransactionModel transactionModel = new TransactionModel();
		 * transactionModel.setId(1); transactionModel.setFromUserId(11111l);
		 * transactionModel.setFromUserName("Rohan");
		 * transactionModel.setAccountId(1122l); transactionModel.setUserId(1l);
		 * transactionModel.setTrndate(new Date());
		 * transactionModel.setAmount(1000000); transactionModel.update();
		 */
		/*
		 * UserModel userModel = new UserModel(); userModel.setId(3);
		 * userModel.setFirstName("aa"); userModel.setLastName("jj");
		 * userModel.setDateOfBirth(new Date()); userModel.setUserid("b6c20");
		 * userModel.setUserPassword("pwd"); userModel.setRoleName("admin");
		 * userModel.setAddress("sanver"); userModel.setGender("male");
		 * userModel.setTelephonNo("99999999");
		 * userModel.setOrganization("international");
		 * userModel.setCenterId(1l); userModel.setCenterName("indore");
		 * userModel.setPlanId(55l); userModel.setPlanName("reg2");
		 * userModel.setReferredById(7771l);
		 * userModel.setReferredByName("unknown"); userModel.add();
		 */
/*
		UserProfileModel userProfileModel = new UserProfileModel();
		userProfileModel.setId(1);
		userProfileModel.setFirstName("Abhishek");
		userProfileModel.setLastName("joshi");
		userProfileModel.setUserId("abhi");
		userProfileModel.setPassword("1234");
		userProfileModel.findByPK(1);*/
	}

	}
