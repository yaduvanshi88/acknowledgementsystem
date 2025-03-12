package com.ack.acknowledgement.Entities;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AcknowledgmentMessage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String clientName;
    private String message;
    private String timestamp;

    public AcknowledgmentMessage(String userName, String clientName) {
        this.userName = userName;
        this.clientName = clientName;
        this.timestamp = getCurrentTimestamp();
        this.message = generateMessage(userName, clientName, this.timestamp);
    }
    

    private String generateMessage(String userName, String clientName, String timestamp) {
        return switch (clientName) {
            case "Client1" -> "I " + userName + " do acknowledge to accept the terms at " + timestamp;
            case "Client2" -> "I " + userName + " agree that I have read the terms and condition shared at " + timestamp;
            default -> "I " + userName + " acknowledge the agreement at " + timestamp;
        };
    }

    private String getCurrentTimestamp() {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z");
    return ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).format(formatter);
    }

}