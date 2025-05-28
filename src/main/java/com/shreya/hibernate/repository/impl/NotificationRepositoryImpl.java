package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Notification;
import com.shreya.hibernate.repository.NotificationRepository;

import java.util.List;

public class NotificationRepositoryImpl implements NotificationRepository {
    @Override
    public boolean saveNotification(Notification notification) {
        return false;
    }

    @Override
    public List<Notification> getAllNotifications() {
        return List.of();
    }

    @Override
    public List<Notification> getNotificationsByCustomerId(Long customerId) {
        return List.of();
    }

    @Override
    public boolean markAsRead(Long id) {
        return false;
    }
}
