package com.kunyan.htmlparse.strategyPattern;

import org.jsoup.nodes.Element;

/**
 * Created by make on 3/1/16.
 */
public class ExtractText implements Extract {

    @Override
    public String extract(Element element, String... s) {
        return element.select(s[0]).text();
    }

}
