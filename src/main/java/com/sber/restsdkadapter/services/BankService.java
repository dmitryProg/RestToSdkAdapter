package com.sber.restsdkadapter.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
public class BankService {
    public File queryQueue() {
    }

    public void deleteFromQueueByIDs(List<Long> ids){
        
    }

    public File queryAllStatements() {
    }

    public void changeStatusByStatement(Long statementId, String newStatus) {
    }

    public File queryStatementById(Long statementId) {
    }

    public File queryStatementsForAllByPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod) {
    }
}
