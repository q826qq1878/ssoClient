package com.jjc.ssoClient.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采购信息枚举enum
 * 
 * @author jjc
 */
public enum KorCoreUserTypeEnum {
	ADMIN("最高权限","-1"),
	KOR_ADMIN("韩国最高权限","0"),
	CHINA_ADMIN("中国最高权限","1"),
	KOR_CITY_MANAGER("韩国城市经理","2"),
	KOR_CITY_PURCHASE("韩国采购商","3"),
	KOR_TRANSLATE("韩国翻译人员","4"),
	CHINA_INTERMEDIARY("中国撮合人员","5");


	/** 描述 */
	private String desc;
	/** 枚举值 */
	private String value;

	private KorCoreUserTypeEnum(String desc, String value) {
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

	public static KorCoreUserTypeEnum getEnum(String value) {
		KorCoreUserTypeEnum resultEnum = null;
		KorCoreUserTypeEnum[] enumAry = KorCoreUserTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue().equals(value)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		KorCoreUserTypeEnum[] ary = KorCoreUserTypeEnum.values();
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
		KorCoreUserTypeEnum[] ary = KorCoreUserTypeEnum.values();
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
