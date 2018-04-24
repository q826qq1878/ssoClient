package com.jjc.ssoClient.web.util;

/**
 * Created by jiangjiacheng on 2017/7/18.
 */

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {

    public static String myEmailAccount = "jiangjiacheng@hc360.com";
    public static String myEmailPassword = "79cA366W";
    public static String myEmailSMTPHost = "smtp.hc360.com";
//    public static String receiveMailAccount = "625933773@qq.com";

    public static void main(String[] args) throws Exception {

        String s = "/yunxin-ucenter";
        String s1 = "http://my.web.com:8082/yunxin-ucenter/accountsecurity/mailboxVerify";

        int index = s1.indexOf(s);
        System.out.println(s1.substring(0,index+s.length()));

    }

    public static void sendEMAIL(String  title , String content , String receiveMailAccount) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
//        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
        MimeMessage message = createMimeMessage(title,content,session, myEmailAccount, receiveMailAccount);
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEmailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(String  title , String content ,  Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "慧聪云信", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject(title, "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(content , "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
    

}