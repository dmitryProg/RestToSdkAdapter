package com.sber.restsdkadapter.controllers;

import com.sber.restsdkadapter.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class BankController {

    final static String CONTEXT = "/api";//todo should I put it in a class with constants?
    private BankService bankService;

    @Autowired
    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @PostMapping(CONTEXT + "/queryQueue")
    public File queryQueue() {
        return bankService.queryQueue();
    }

    @PutMapping(CONTEXT + "/deleteFromQueueByIDs")
    public void deleteFromQueueByIDs(List<Long> ids) {
        bankService.deleteFromQueueByIDs(ids);
    }

    @PostMapping(CONTEXT + "/queryAllStatements")
    public File queryAllStatements() {
        return bankService.queryAllStatements();
    }

    @PostMapping(CONTEXT + "/changeStatusByStatement")
    public void changeStatusByStatement(Long statementId, String newStatus) {
        bankService.changeStatusByStatement(statementId, newStatus);
    }

}
