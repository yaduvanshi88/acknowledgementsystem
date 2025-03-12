package com.ack.acknowledgement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ack.acknowledgement.Entities.AcknowledgmentMessage;

public interface AcknowledgmentRepository extends JpaRepository<AcknowledgmentMessage, Long> {
    List<AcknowledgmentMessage> findByUserName(String userName);
}
