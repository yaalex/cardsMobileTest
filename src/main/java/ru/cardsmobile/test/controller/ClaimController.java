package ru.cardsmobile.test.controller;

import ru.cardsmobile.test.dto.ClaimDto;
import ru.cardsmobile.test.dto.CustomClaimDto;
import ru.cardsmobile.test.dto.MegaClaimDto;
import ru.cardsmobile.test.service.ClaimService;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/claim")
public class ClaimController {

    private ClaimService service;
    private AmqpTemplate rabbitTemplate;

    @Autowired
    public void setService(ClaimService service) {
        this.service = service;
    }

    @Autowired
    public void setRabbitTemplate(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // TODO накрутить security
    @RequestMapping(path = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> process(@RequestBody ClaimDto claimDto) {
        if (claimDto instanceof CustomClaimDto) {
            claimDto = service.save((CustomClaimDto) claimDto);
        }
        if (claimDto instanceof MegaClaimDto) {
            claimDto = service.save((MegaClaimDto) claimDto);
        }
        rabbitTemplate.convertAndSend("cardsMobileQueue", claimDto);

        return ResponseEntity.accepted().body(claimDto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClaim(@PathVariable String id) {
        return ResponseEntity.ok(service.find(id));
    }

}
