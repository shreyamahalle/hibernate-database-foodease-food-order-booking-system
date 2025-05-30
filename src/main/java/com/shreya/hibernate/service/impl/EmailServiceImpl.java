package com.shreya.hibernate.service.impl;

import com.shreya.hibernate.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail(String to, String message, String s) {
        logger.info("Email sent to {}: {}", to, message);
    }
}
