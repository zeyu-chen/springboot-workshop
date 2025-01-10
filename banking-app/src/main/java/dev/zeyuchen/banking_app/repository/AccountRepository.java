package dev.zeyuchen.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.zeyuchen.banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
