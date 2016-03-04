package com.kunyan.htmlparse.strategyPattern;

import org.jsoup.nodes.Element;

/**
 * Created by make on 2/29/16.
 */
public class SelectionOperation implements Operation {
    

    @Override
    public String execute(String command, Element element, String... s) throws Exception {
        return ExtractMethodsFactory.getCommandExtractMap().get(command).extract(element, s);
    }
}
