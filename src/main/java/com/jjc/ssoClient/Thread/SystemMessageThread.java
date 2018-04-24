
/**
 * Copyright ? 2018年1月29日 hc360.com.Co.,Ltd
 * yunxin-rest-web-iambuyer 下午3:09:25
 * Version TODO
 * All right reserved.
 *
 */

package com.jjc.ssoClient.Thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类描述： 线程
 * 创建者： hchugq
 * 项目名称： yunxin-rest-web-iambuyer
 * 创建时间： 2018年1月29日 下午3:09:25
 * 版本号： v1.0
 */

public class SystemMessageThread implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(SystemMessageThread.class);
	
	//消息类型
	private String msgType;
	
	//操作业务ID
	private int workId; 
	
	public SystemMessageThread(String msgType, int workId){
		this.msgType = msgType;
		this.workId = workId;
	}

	@Override
	public void run() {
		LOG.info("业务数据 [{}]发布成功,开始发送系统通知消息,消息类型[{}].",workId,msgType);
		/*//TODO 调用 rsf 远程服务接口
		MsgUtilService msgUtilService = (MsgUtilService) RSFClentHelper.get(RSFClentHelper.MSG_UTIL_SERVICE);
		msgUtilService.insertMsg(workId, msgType);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");*/
	}
}
