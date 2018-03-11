package com.workflowapi.services;

import com.workflowapi.interfaces.WorkFlowService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by user on 3/5/2018.
 */

@Qualifier("ServiceChain")
@Component
public class ServiceA implements WorkFlowService {
    public ServiceA() {
        System.out.println("Injecting serviceA");
    }
}
