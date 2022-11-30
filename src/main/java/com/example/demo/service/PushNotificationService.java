/**
 * 
 */
package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.model.PushNotificationRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @since Nov 30, 2022
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PushNotificationService {

    private final FCMService fcmService;

    public void sendPushNotification(Map<String, String> payloadData, PushNotificationRequest request) {
        try {
            fcmService.sendMessage(payloadData, request);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Push notification service sent message failed with message: {}", e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(PushNotificationRequest request) {
        try {
            fcmService.sendMessageWithoutData(request);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Push notification service sent message without data failed with message: {}", e.getMessage());
        }
    }

    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.error("Push notification service sent message to token failed with message: {}", e.getMessage());
        }
    }
}
