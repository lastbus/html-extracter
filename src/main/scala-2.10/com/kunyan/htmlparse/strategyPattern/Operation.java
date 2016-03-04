package com.kunyan.htmlparse.strategyPattern;

import org.jsoup.nodes.Element;

/**
 * Created by make on 2/29/16.
 */
public interface Operation {

    public String execute(String command, Element element, String... s) throws Exception;
}
