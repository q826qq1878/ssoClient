package com.jjc.ssoClient.web.util;

import java.io.File;

/**
 * Created by jiangjiacheng on 2018/2/9.
 */
public class FileUtil {


    public static final String FILE_PATH="/home/iambuyer.com/korea/korea.txt";


    public static void main(String[] args) {
        System.out.println(FileUtil.judeFileExists(FileUtil.FILE_PATH));
    }

    // 判断文件是否存在
    public static boolean judeFileExists(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return  true;
        } else {
            return  false;
        }
    }


}
