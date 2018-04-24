package com.jjc.ssoClient.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短信enum
 *
 * @author qawine
 */
public enum SmsEnum {
	FYY("采购商发布采购提醒翻译员","77309"),
	HGCITY("采购商发布采购提醒韩国负责人、城市经理","78913"),
	CYD("采购商发布采购提醒产业带对接人","77205"),
	CITY("翻译成功提醒韩国负责人","78912"),
	CHRY("翻译员翻译成功提醒中国负责人","77206"),

	BJFYY("报价成功提醒翻译员","78911"),
	BJKOM("报价成功提醒韩国负责人","78910"),
	BJCHERM("报价成功提醒中国负责人","78179"),

	BJCGS("报价翻译完成提采购商","77766"),
	BJCITY("报价翻译完成提醒韩国负责人","77773"),
	BJCITYLR("报价翻译完成提醒中国负责人","77560"),

	REG("注册验证码","69612");
	/** 描述 */
	private String desc;
	/** 枚举值 */
	private String value;
	private SmsEnum(String desc, String value) {
		this.desc = desc;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static SmsEnum getEnum(String value) {
		SmsEnum resultEnum = null;
		SmsEnum[] enumAry = SmsEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue().equals(value)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		SmsEnum[] ary = SmsEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("value", String.valueOf(ary[num].getValue()));
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		SmsEnum[] ary = SmsEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("value", String.valueOf(ary[i].getValue()));
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}

}