package com.sber.restsdkadapter.controllers;

import com.sber.restsdkadapter.services.BankService;
import com.sber.restsdkadapter.services.BeneficiarService;
import com.sber.restsdkadapter.services.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.time.LocalDateTime;
import static com.sber.restsdkadapter.controllers.BankController.CONTEXT;

@RestController
public class BankPrincipalBeneficiarController {

    private BankService bankService;
    private BeneficiarService beneficiarService;
    private PrincipalService principalService;

    @Autowired
    public BankPrincipalBeneficiarController(BankService bankService, BeneficiarService beneficiarService, PrincipalService principalService){
        this.bankService = bankService;
        this.beneficiarService = beneficiarService;
        this.principalService = principalService;
    }

    @PutMapping(CONTEXT + "/createStatement")
    public String createStatement(Long randomIdAdd, File xmlFile) {
        return beneficiarService.createStatement(randomIdAdd, xmlFile);
    }

    @PostMapping(CONTEXT + "/queryStatementsForPrincipalByPeriod")
    public File queryStatementsForPrincipalByPeriod(Long principalInn, LocalDateTime startPeriod, LocalDateTime endPeriod) {
        return principalService.queryStatementsForPrincipalByPeriod(principalInn, startPeriod, endPeriod);//todo should I use ZonedDateTime??
    }

    @PostMapping(CONTEXT + "/queryStatementsForBeneficiarByPeriod")
    public File queryStatementsForBeneficiarByPeriod(Long principalInn, LocalDateTime startPeriod, LocalDateTime endPeriod) {
        return beneficiarService.queryStatementsForBeneficiarByPeriod(principalInn, startPeriod, endPeriod);//todo should I use ZonedDateTime??
    }


    /**
     * Method uses all three components, which service should  put it?
     * @param statementId
     * @return query
     */
    @PostMapping(CONTEXT + "/queryStatementById")
    public File queryStatementById(Long statementId) {
        return bankService.queryStatementById(statementId);
    }

    /**
     * Method uses all three components, which service should  put it?
     * @param startPeriod, endPeriod
     * @return query
     */
    @PostMapping(CONTEXT + "/createStatement")
    public File queryStatementsForAllByPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod) {
        return bankService.queryStatementsForAllByPeriod(startPeriod,endPeriod);//todo should I use ZonedDateTime??
    }

}
