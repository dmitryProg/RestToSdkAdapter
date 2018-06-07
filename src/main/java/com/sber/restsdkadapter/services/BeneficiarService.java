package com.sber.restsdkadapter.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;

@Service
@Log4j2
public class BeneficiarService {
    public String createStatement(Long randomIdAdd, File xmlFile) {
    }

    public File queryStatementsForBeneficiarByPeriod(Long principalInn, LocalDateTime startPeriod, LocalDateTime endPeriod) {
    }
}
