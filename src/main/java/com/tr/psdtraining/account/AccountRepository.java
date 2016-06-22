package com.tr.psdtraining.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Long> {
	UserAccount findOneByEmail(String email);
}