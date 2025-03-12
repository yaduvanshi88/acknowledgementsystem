package com.ack.acknowledgement.Services;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;

import com.ack.acknowledgement.Entities.AcknowledgmentMessage;
import com.ack.acknowledgement.Repository.AcknowledgmentRepository;
import com.ack.acknowledgement.exception.ResourceNotFoundException;
@Service
public class AcknowledgmentService {
    private static final Logger log = LoggerFactory.getLogger(AcknowledgmentService.class);

    @Autowired
    private AcknowledgmentRepository repository;

    public AcknowledgmentMessage createAcknowledgment(String userName, String clientName) {
        AcknowledgmentMessage m = new AcknowledgmentMessage(userName, clientName);
        log.info("Creating acknowledgment: {}", m);
        return repository.save(m);
    
    }

    public List<AcknowledgmentMessage> getAllAcknowledgments() {
        log.info("Fetching all acknowledgments");
        return repository.findAll();
    }

    public List<AcknowledgmentMessage> getAcknowledgmentsByUser(String userName) {
        log.info("Fetching acknowledgments for user: {}", userName);
        return repository.findByUserName(userName);
    }

    public AcknowledgmentMessage getAcknowledgmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Acknowledgment not found for id: " + id));
    }
}

