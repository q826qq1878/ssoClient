package com.jjc.ssoClient.web.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jiangjiacheng on 2017/9/28.
 */
public class ImgUtil {



    //调用图片服务
//    public static final String IMG_URL = "http://img01.iambuyer.com/imgup/upLoad/uploadSuccess";

    public static final String IMG_URL = "http://img01.iambuyer.com/imgup/upLoad/uploadSuccess";


    //调用上传到正式目录的服务
    public static String uploadSuccess(String beakImg){
        if(StringUtils.isEmpty(beakImg) || beakImg.indexOf("http") != -1){
            return  null;
        }
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("fileName", beakImg);
        JSONObject jsonObject  = restTemplate.postForObject(IMG_URL, requestEntity, JSONObject.class);
        if(null != jsonObject){
            String ret = (String) jsonObject.get("ret");
            String fileName = (String) jsonObject.get("fileName");
            if("200".equals(ret)){
                return  fileName;
            }else{
                return  null;
            }
        }else{
            return null;
        }
    }


    public static void main(String[] args) {
//        System.out.println(uploadSuccess("p1mK%2FlErsVCqCO7a32n4OLf%2BB%2B63l57GSDuscTMiZx4LXa%2F%2Btc%2BWWt3SoVyr4l0X.jpg"));


    }
}
