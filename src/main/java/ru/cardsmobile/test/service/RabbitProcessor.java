package ru.cardsmobile.test.service;

import ru.cardsmobile.test.dto.CustomClaimDto;
import ru.cardsmobile.test.dto.MegaClaimDto;
import ru.cardsmobile.test.model.ClaimStatus;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProcessor {
    private ClaimService service;

    @Autowired
    public void setService(ClaimService service) {
        this.service = service;
    }

    @RabbitListener(queues = "cardsMobileQueue")
    public void processQueue1(CustomClaimDto claim) throws InterruptedException {
        Thread.sleep(1000);
        claim.setClaimStatus(ClaimStatus.DONE);
        service.save(claim);
    }

    @RabbitListener(queues = "cardsMobileQueue")
    public void processQueue1(MegaClaimDto claim) throws InterruptedException {
        Thread.sleep(1000);
        claim.setClaimStatus(ClaimStatus.DONE);
        service.save(claim);
    }
}
