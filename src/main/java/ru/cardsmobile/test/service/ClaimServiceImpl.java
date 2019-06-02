package ru.cardsmobile.test.service;

import ru.cardsmobile.test.dto.ClaimDto;
import ru.cardsmobile.test.dto.CustomClaimDto;
import ru.cardsmobile.test.dto.MegaClaimDto;
import ru.cardsmobile.test.model.CustomClaim;
import ru.cardsmobile.test.model.MegaClaim;
import ru.cardsmobile.test.repository.ClaimRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService {
    private static final Logger LOG = LoggerFactory.getLogger(ClaimServiceImpl.class.getName());
    private ClaimRepository<CustomClaim> customClaimRepository;
    private ClaimRepository<MegaClaim> megaClaimRepository;
    private ModelMapper mapper;

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setCustomClaimRepository(ClaimRepository<CustomClaim> customClaimRepository) {
        this.customClaimRepository = customClaimRepository;
    }

    @Autowired
    public void setMegaClaimRepository(ClaimRepository<MegaClaim> megaClaimRepository) {
        this.megaClaimRepository = megaClaimRepository;
    }

    public CustomClaimDto save(CustomClaimDto claimDto) {
        CustomClaim claim = mapper.map(claimDto, CustomClaim.class);
        claim = customClaimRepository.save(claim);
        LOG.debug("Claim saved with id {}", claim.getId());
        return mapper.map(claim, CustomClaimDto.class);
    }

    @Override
    public MegaClaimDto save(MegaClaimDto claimDto) {
        MegaClaim claim = mapper.map(claimDto, MegaClaim.class);
        claim = megaClaimRepository.save(claim);
        LOG.debug("Claim saved with id {}", claim.getId());
        return mapper.map(claim, MegaClaimDto.class);
    }

    @Override
    public ClaimDto find(String id) {
        return null;
    }
}
