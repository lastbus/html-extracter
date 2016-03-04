package com.kunyan.htmlparse.strategyPattern;

import org.jsoup.nodes.Element;

import java.util.Map;

/**
 * Created by make on 2/29/16.
 */
public class OperationContext {

    private Map<String, Operation> operationMap = null;

    /**
     * be sure that operation map is initiated.
     * @param operationMap
     * @throws Exception
     */
    public OperationContext(Map<String, Operation> operationMap) throws Exception {
        this.operationMap = operationMap;
        if(operationMap == null) throw new Exception("fatal error: OperationContext cannot be initial=te");
    }


    /**
     * according to the command args to invocation object.
     * @param command
     * @param s
     * @return
     * @throws Exception
     */
    public String execute(String command, Element element, String... s) throws Exception {
        if(command.equals("select")) return operationMap.get(command).execute(command, element, s);
        if(command.equals("substring")) return operationMap.get(command).execute(command, element, s);
        else throw new Exception("cannot find command: " + command);
    }


}
