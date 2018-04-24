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
public enum MsgTypeEnum {
	//发布采购成功
	FB_CG("发布采购成功","0"),
	FB_CG_FYY("发布采购翻译员","100"),
	FB_CG_KOM("发布采购韩国负责人","101"),
	FB_CG_CNM("发布采购中国负责人","102"),
	//采购翻译成功
	CG_FY_WC("采购翻译成功","1"),
	CG_FY_WC_CH("采购翻译完成撮合人员","200"),
	CG_FY_WC_KOM("采购翻译完成韩国负责人","201"),
	CG_FY_WC_CNM("采购翻译完成中国负责人","202"),
	//报价成功
	BJ_CG("报价成功","2"),
	BJ_TX_FYY("报价提醒翻译员","300"),
	BJ_TX_KOM("报价提醒韩国负责人","301"),
	BJ_TX_CNM("报价提醒中国负责人","302"),
	//报价翻译完成
	BJ_FY_WC("报价翻译完成","3"),
	BJ_FY_WC_KOM("报价翻译完成韩国负责人","400"),
	BJ_FY_WC_CNM("报价翻译完成中国负责人","401"),
	BJ_FY_WC_CGS("报价翻译完成采购商","402"),
	//采购商意向提醒
	CG_YX_TX("采购商意向提醒","4"),
	CG_YX_TX_CH("采购商意向提醒撮合人员","500"),
	CG_YX_TX_FYY("采购商意向提醒翻译员","501"),
	CG_YX_TX_KOM("采购商意向提醒韩国负责人","502"),
	CG_YX_TX_CNM("采购商意向提醒中国负责人","503"),
	//撮合成功
	CH_SUCCESS("撮合成功","5"),
	CH_SUCCESS_CITY("撮合成功城市经理","600"),
	CH_SUCCESS_CH("撮合成功撮合人员","601"),
	CH_SUCCESS_FYY("撮合成功翻译员","602"),
	CH_SUCCESS_KOM("撮合成功韩国负责人","603"),
	CH_SUCCESS_CNM("撮合成功中国负责人","604"),
	CH_SUCCESS_CGS("撮合成功采购商","605"),
	//解析系统提醒
	EXCLE_SUCCESS("批量解析","6"),
	CG_EXCLE_SUCCESS("批量采购解析成功","701"),
	CG_EXCLE_FAIL("批量采购解析失败","702"),
	BJ_EXCLE_SUCCESS("批量报价解析成功","703"),
	BJ_EXCLE_FAIL("批量报价解析失败","704");

	/** 描述 */
	private String desc;
	/** 枚举值 */
	private String value;

	private MsgTypeEnum(String desc, String value) {
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

	public static MsgTypeEnum getEnum(String value) {
		MsgTypeEnum resultEnum = null;
		MsgTypeEnum[] enumAry = MsgTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue().equals(value)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		MsgTypeEnum[] ary = MsgTypeEnum.values();
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
		MsgTypeEnum[] ary = MsgTypeEnum.values();
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
