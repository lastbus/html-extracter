package com.kunyan.htmlparse.strategyPattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by make on 3/1/16.
 */
public class ExtractMethodsFactory {

    private static Map<String, Extract> commandExtractMap = new ConcurrentHashMap<String, Extract>();

    private ExtractMethodsFactory(){}

    public static void loadExtractMethodsFactory(){
        commandExtractMap.put("", new ExtractText());
        commandExtractMap.put("", new ExtractAttribute());
    }

    public static void addExtractMethds(String command, Extract extract){
        commandExtractMap.put(command, extract);
    }

    public static Map<String, Extract> getCommandExtractMap() {
        return commandExtractMap;
    }

    public static Extract getExtract(String command){
        return commandExtractMap.get(command);
    }

}
