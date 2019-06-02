package ru.cardsmobile.test.repository;

import ru.cardsmobile.test.model.Claim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClaimRepository<T extends Claim> extends JpaRepository<T, UUID> {
}
