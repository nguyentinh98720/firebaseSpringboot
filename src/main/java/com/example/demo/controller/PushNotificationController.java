/**
 * 
 */
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PushNotificationRequest;
import com.example.demo.model.PushNotificationResponse;
import com.example.demo.service.PushNotificationService;

import lombok.RequiredArgsConstructor;

/**
 * @since Nov 30, 2022
 *
 */
@RestController
@RequestMapping("/fcm")
@RequiredArgsConstructor
public class PushNotificationController {

    private final PushNotificationService service;

    @PostMapping("/notification/topic")
    public ResponseEntity<PushNotificationResponse> sendNotification(@RequestBody PushNotificationRequest request) {
        service.sendPushNotificationWithoutData(request);
        return ResponseEntity.ok(PushNotificationResponse.builder().status(HttpStatus.OK.value()).message("Notification has been sent!").build());
    }

    @PostMapping("/notification/token")
    public ResponseEntity<PushNotificationResponse> sendTokenNotification(@RequestBody PushNotificationRequest request) {
        service.sendPushNotificationToToken(request);
        return ResponseEntity.ok(PushNotificationResponse.builder().status(HttpStatus.OK.value()).message("Token notification has been sent!").build());
    }

    @PostMapping("/notification/data")
    public ResponseEntity<PushNotificationResponse> sendDataNotification(@RequestBody PushNotificationRequest request, @RequestBody List<String> sampleData) {
        Map<String, String> sampleMapData = new HashMap<>();
        Optional.ofNullable(sampleData).ifPresent(l -> l.forEach(s -> sampleMapData.put(s, s)));
        service.sendPushNotification(null, request);
        return ResponseEntity.ok(PushNotificationResponse.builder().status(HttpStatus.OK.value()).message("Notification with data has been sent!").build());
    }
}
