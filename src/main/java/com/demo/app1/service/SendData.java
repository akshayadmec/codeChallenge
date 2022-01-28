package com.demo.app1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class SendData {
    private JmsTemplate jmsTemplate;

    @Autowired
    public SendData(JmsTemplate jmsTemplate){
        this.jmsTemplate=jmsTemplate;
    }
    public void sendName(String name){
        jmsTemplate.convertAndSend("channel",name);
    }
}
