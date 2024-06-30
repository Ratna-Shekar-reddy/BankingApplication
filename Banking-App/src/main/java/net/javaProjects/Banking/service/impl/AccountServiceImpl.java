package net.javaProjects.Banking.service.impl;
import org.springframework.stereotype.Service;
import net.javaProjects.Banking.dto.AccountDto;
import net.javaProjects.Banking.entity.Account;
import net.javaProjects.Banking.mapper.AccountMapper;
import net.javaProjects.Banking.repository.AccountRepository;
import net.javaProjects.Banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public AccountDto createAccount(AccountDto accountDto){
        Account account=AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
       
    }
    @Override 
    public AccountDto getAccountById(Long id){
        Account account=accountRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Account does not exists"));
    return AccountMapper.mapToAccountDto(account);
    }
    @Override 
    public AccountDto deposit(Long id,double amount){
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exists"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
