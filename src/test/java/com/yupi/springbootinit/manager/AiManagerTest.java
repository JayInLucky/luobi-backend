package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiManagerTest {
    @Resource
    private AiManager aiManager;
//1675772021360898050L
//Long modelId = 1688012458876305409L;
@Test
void doChat() {
    Long modelId = 1688012458876305409L; //自己建立的模型。
    String message = "分析需求：\n" +
            "分析网站用户的增长情况\n" +
            "原始数据：\n" +
            "日期，用户数\n" +
            "1号，10\n" +
            "2号，20\n" +
            "3号，30\n" ;
    String doChat = aiManager.doChat(modelId,message);
    System.out.println(doChat);
}
}