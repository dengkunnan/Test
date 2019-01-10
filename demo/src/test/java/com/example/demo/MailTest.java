package com.example.demo;

import com.example.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Resource
    MailService helloService;
    @Resource
    TemplateEngine templateEngine;



@Test
public void sendSimleTest() {
    helloService.sendSimpleMail("1508376620@qq.com","自行车自行车在","自行车支持下XC");
}
@Test
public  void  sendhtmlmailTest() throws MessagingException {
    String content = "<html> \n"+
            "<body>\n"+
            "<h3> hello word , This is Html EMail Test! </h3>\n" +
            "</body>\n"+
            "</html>";
    helloService.sendHtmlMail("1508376620@qq.com","HTML eMile",content);
}
@Test
public void sendAttachmentsMail() throws MessagingException {
    String filePath ="D:\\TeamViewer_.exe";
    helloService.sendAttachmentsMail("1508376620@qq.com","HTML eMile","This is have fujian ", filePath);
}

    @Test
    public void sendInlineResourceMail() throws MessagingException {
        String imgPath ="F:\\荒野求生\\德野\\【越南妹子】原始生活合集（更新至第14弹） - 5.用天然植物造一座原始小屋\\1.png";
        String rscid = "neo001";
        String content = "<html> \n"+
                "<body>\n"+
                "<h3> hello word , This is Html EMail Test! </h3>\n" +
                "<img src=\'cid:"+ rscid +"\'></img>"+
                "</body>\n"+
                "</html>";

        helloService.sendInlinResourceMaile("1508376620@qq.com","HTML eMile",content, imgPath,rscid);
    }

    @Test
    public void testtemplateMailTest() throws MessagingException{
        Context context =new Context();
        context.setVariable("id","006");
        String emailContent = templateEngine.process("emailTemplate", context);
        helloService.sendHtmlMail("1508376620@qq.com","HTML eMile",emailContent);

    }
}
