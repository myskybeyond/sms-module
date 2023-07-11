package com.syzn.sms;

import com.syzn.sms.service.MaiSendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;

@SpringBootTest
class SmsModuleApplicationTests {

	@Autowired
	private MaiSendService mailSendService;

	private final static String MAIL_TEMPLATE = "{0}您好，{1}需要您打扫{2}区域，请关注！";
	private final static String MAIL_SUBJECT  = "上元智能值日提醒";

	@Test
	void contextLoads() {
		String to = "shangyuanljt@126.com";
		String content = MessageFormat.format(MAIL_TEMPLATE,"张三","2023-06-22","展厅、前台");
//		mailSendService.send(to,MAIL_SUBJECT,content);

//		Map<String, String> smsVariableMap = new HashMap<>();
//		smsVariableMap.put("name", "张三");
//		smsVariableMap.put("dutyDt", "2023-06-25");
//		smsVariableMap.put("dutyArea", "测试卫生区域");
//
//		try {
//			String str1 = objectMapper.writeValueAsString(smsVariableMap);
//			System.out.println(str1 + "jackson format object...");
//			String str2 = JSONUtil.toJsonStr(smsVariableMap);
//			System.out.println(str2 + "Hutool Json format object...");
//		} catch (JsonProcessingException e) {
//			throw new RuntimeException(e);
//		}
	}

}
