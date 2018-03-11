package com.component;

import com.workflowapi.interfaces.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 3/5/2018.
 */
@Component
public class WorkFlowComponent {

    public WorkFlowComponent() {
        System.out.println("=========Injecting WorkFlowComponent========");
    }

    @Autowired
    @Qualifier("ServiceChain")
    public List<WorkFlowService> setWorkFlowList(List<WorkFlowService> workflowList) {
        return workflowList;

    }
}

/*
*
If there multiple components matching with same Qualifier and to get all of that list, Use @Autowired for SetterMethod

For Components use the same qualifier of Setter method for all the components that are applicable

*
* */