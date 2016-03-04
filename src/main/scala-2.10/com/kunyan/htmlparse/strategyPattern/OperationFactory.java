package com.kunyan.htmlparse.strategyPattern;

import java.util.Map;

/**
 * Created by make on 2/29/16.
 */
public class OperationFactory {

    private Map<String, Operation> operationMap = null;

    public OperationFactory(){}

    public void addCommandOperation(String command, Operation operation) throws Exception {
        if(operationMap.containsKey(command)) throw new Exception("fatal exception");
        operationMap.put(command, operation);
    }

    public Map<String, Operation> getOperationMap() throws Exception {
        if(operationMap == null || operationMap.size() == 0) throw new Exception("fatal exception");
        return operationMap;
    }
}
