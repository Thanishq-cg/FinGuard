package com.main.service;

import com.main.dto.DebtRequest;
import com.main.dto.User;
import com.main.entity.Debt;
import com.main.proxy.UserClient;
import com.main.repository.DebtRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebtServiceImpl implements DebtService {

    @Autowired
    private DebtRepository debtRepository;
    
    @Autowired 
    private UserClient userClient;

    public Debt createDebt(DebtRequest debtRequest) {
        Debt debt = new Debt();
        debt.setUserId(debtRequest.getUserId());
        debt.setPrincipalAmount(debtRequest.getPrincipalAmount());
        debt.setInterestRate(debtRequest.getInterestRate());
        debt.setEmiAmount(debtRequest.getEmiAmount());
        debt.setStartDate(debtRequest.getStartDate());
        debt.setEndDate(debtRequest.getEndDate());
        debt.setCreatedAt(new Date(System.currentTimeMillis()));
        debt.setUpdatedAt(new Date(System.currentTimeMillis()));
        return debtRepository.save(debt);
    }

    public Debt getDebtById(int loanId) {
        return debtRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Debt not found"));
    }

    public Debt updateDebt(int loanId, double amount) {
        Debt debt = debtRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Debt not found"));

		debt.setAmountPaid(debt.getAmountPaid()+amount);
        return debtRepository.save(debt);
    }

    public void deleteDebt(int loanId) {
        debtRepository.deleteById(loanId);
    }

    public List<Debt> getDebtsByUserId(int userId) {
        return debtRepository.findByUserId(userId);
    }
}