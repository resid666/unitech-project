package com.fintech.unitech.repository;

import com.fintech.unitech.domain.Account;
import com.fintech.unitech.enumeration.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountByUserIdAndStatus(Long userId, AccountStatus status);

    Optional<Account> findByIdAndUserId(Long id, Long userId);
}
