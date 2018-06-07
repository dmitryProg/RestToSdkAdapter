package com.sber.restsdkadapter.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;

@Service
@Log4j2
public class PrincipalService {
    public File queryStatementsForPrincipalByPeriod(Long principalInn, LocalDateTime startPeriod, LocalDateTime endPeriod) {

    }
}
