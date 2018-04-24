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
public enum KorStProductStateEnum {
	PUBLISHED("已发布","0"),
	MATCHMAKING("撮合中","1"),
	SHOP("停止采购","2"),
	SUCCESS("采购成功","3");

	/** 描述 */
	private String desc;
	/** 枚举值 */
	private String value;

	private KorStProductStateEnum(String desc, String value) {
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

	public static KorStProductStateEnum getEnum(String value) {
		KorStProductStateEnum resultEnum = null;
		KorStProductStateEnum[] enumAry = KorStProductStateEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue().equals(value)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		KorStProductStateEnum[] ary = KorStProductStateEnum.values();
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
		KorStProductStateEnum[] ary = KorStProductStateEnum.values();
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
