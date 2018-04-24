package com.jjc.ssoClient.common.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {
	public static boolean isLoclePortUsing(int port){  
        boolean flag = true;  
        try {  
            flag = isPortUsing("10.158.44.201", port);  
        } catch (Exception e) {  
        }  
        return flag;  
    }  
	
	public static boolean isPortUsing(String host,int port) throws UnknownHostException{  
        boolean flag = false;  
        InetAddress theAddress = InetAddress.getByName(host);  
        try {  
            Socket socket = new Socket(theAddress,port);  
            flag = true;  
        } catch (IOException e) {  
           e.printStackTrace();   
        }  
        return flag;  
    }
	
//	public static void main(String[] args) {
//		SocketTest t = new SocketTest();
//		boolean r = t.isLoclePortUsing(80);
//		if(r){
//			System.out.println("is use");
//		}else{
//			System.out.println("is not use");
//		}
//	}
	
	public static void main(String[] args) {
		for (int i = 63636; i < 63640; i++) {
			try {
				InetAddress localHost = InetAddress.getLocalHost();
				Socket socket = new Socket(localHost, i);
				System.out.println("�����Ѿ�ʹ���˶˿ڣ�" + i);
			} 
//			catchd (UnknownHostException e) {
//				e.printStackTrace();
//			}
			catch (IOException e) {
//				e.printStackTrace();
			}
		}
		System.out.println("ִ����ϣ�");
	}
	
	
//	public static void main(String args[]) { 
//	    // ����4���ո� 
//		String say = "hello"; 
//		// ����������ұ�����һ���ո� 
//		int flag = 0; 
//		// �ؼ���if������֮�������һ���ո�������f�������ţ�1�������Ų���Ҫ�ո� 
//		if (flag == 0) { 
//			System.out.println(say); 
//		} 
//		// �������ǰ�ӿո��Ҳ����У�������ź��� 
//		if (flag == 1) { 
//		    System.out.println("world"); 
//		// �Ҵ�����ǰ���У��Ҵ����ź���else�����û��� 
//		} else { 
//		    System.out.println("ok"); 
//		// �Ҵ�������Ϊ���������뻻��
//		}
//	}
}
