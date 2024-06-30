package net.javaProjects.Banking.repository;

import net.javaProjects.Banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account,Long>{
    
}
