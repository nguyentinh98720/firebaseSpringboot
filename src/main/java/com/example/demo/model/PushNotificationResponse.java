/**
 * 
 */
package com.example.demo.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class PushNotificationResponse {

    private int status;

    private String message;

}
