package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillRepository {
    private FeignBillRepository feignBillRepository;
    public BillRepository(FeignBillRepository feignBillRepository) {
        this.feignBillRepository = feignBillRepository;
    }

    public List<Bill> findByUserId(String userId){
        ResponseEntity<List<Bill>> response = feignBillRepository.findByUserId(userId);
        return response.getBody();
    }

}