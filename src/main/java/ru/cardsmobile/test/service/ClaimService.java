package ru.cardsmobile.test.service;

import ru.cardsmobile.test.dto.ClaimDto;
import ru.cardsmobile.test.dto.CustomClaimDto;
import ru.cardsmobile.test.dto.MegaClaimDto;

// для простоты конверить туда обратно будет в сервисе
public interface ClaimService {
    CustomClaimDto save(CustomClaimDto claim);

    MegaClaimDto save(MegaClaimDto claim);

    ClaimDto find(String id);

}
