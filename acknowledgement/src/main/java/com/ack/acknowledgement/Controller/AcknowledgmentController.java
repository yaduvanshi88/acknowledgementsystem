package com.ack.acknowledgement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ack.acknowledgement.Entities.AcknowledgmentMessage;
import com.ack.acknowledgement.Services.AcknowledgmentService;

@RestController
@RequestMapping("/acknowledgments")
public class AcknowledgmentController {

    @Autowired
    private AcknowledgmentService service;

    @PostMapping
    public AcknowledgmentMessage createAcknowledgment(@RequestParam String userName, @RequestParam String clientName) {
        return service.createAcknowledgment(userName, clientName);
    }

    @GetMapping
    public List<AcknowledgmentMessage> getAllAcknowledgments() {
        return service.getAllAcknowledgments();
    }

    @GetMapping("/{id}")
    public AcknowledgmentMessage getAcknowledgmentById(@PathVariable Long id) {
        return service.getAcknowledgmentById(id);
    }

    @GetMapping("/user/{userName}")
    public List<AcknowledgmentMessage> getAcknowledgmentsByUser(@PathVariable String userName) {
        return service.getAcknowledgmentsByUser(userName);
    }
}