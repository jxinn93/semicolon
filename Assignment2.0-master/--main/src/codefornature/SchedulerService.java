/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codefornature;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerService {
  public static void scheduleNotification(String username, String email) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Notification notification = new Notification(username, email);
        long initialDelay = notification.getDelay();
        scheduler.scheduleAtFixedRate(notification::check, initialDelay, 24 * 60 * 60, TimeUnit.SECONDS); // Daily schedule
    }  
}
