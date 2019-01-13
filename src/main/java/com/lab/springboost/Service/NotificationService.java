package com.lab.springboost.Service;

import com.lab.springboost.common.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class NotificationService implements Notification {
    public static final String NOTIFY_MSG_SESSION_KEY = "notificationMessage";

    @Autowired
    private HttpSession httpSession;

    @Override
    public void countPrescription(Integer count) {
        httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, count);
    }
}
