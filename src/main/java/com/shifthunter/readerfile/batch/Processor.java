package com.shifthunter.readerfile.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.shifthunter.readerfile.model.UserBatch;

@Component
public class Processor implements ItemProcessor<UserBatch, UserBatch>{

	private static final Map<String, String> DEPT_NAMES =new HashMap<>();
	
	public Processor() {
	DEPT_NAMES.put("001","Technology");	
	DEPT_NAMES.put("002","Operations");	
	DEPT_NAMES.put("003","Accounts");	
	}
	
	
	@Override 
	public UserBatch process(UserBatch user) {
		String deptCode = user.getDept();
		String dept = DEPT_NAMES.get(deptCode);
		user.setDept(dept);
		user.setTime(new Date());
		System.out.println(String.format("Converetd from [%s] to [%s]", deptCode, dept));
		return user;
	}
	
//  NEXT STEP IS TO CREATE THE WRITER TO TEH DATABASE	
	
}
