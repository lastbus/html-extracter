package com.kunyan.htmlparse.strategyPattern;

import org.jsoup.nodes.Element;

/**
 * Created by make on 3/1/16.
 */
public interface Extract {

    public String extract(Element element, String... s) throws Exception;
}
