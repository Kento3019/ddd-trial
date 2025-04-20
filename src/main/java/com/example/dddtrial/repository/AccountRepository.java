package com.example.dddtrial.repository;

import com.example.dddtrial.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    // accountNumber による検索
    Optional<Account> findByAccountNumber(String accountNumber);

    // accountName による検索（必要なら）
    Optional<Account> findByAccountName(String accountName);
}
