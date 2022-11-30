/**
 * 
 */
package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @since Nov 30, 2022
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class PushNotificationRequest {

    private String title;

    private String message;

    private String topic;

    private String token;

}
