package com.kunyan.htmlparse.strategyPattern;

import org.jsoup.nodes.Element;

/**
 * Created by make on 3/1/16.
 */
public class ExtractAttribute implements Extract {

    @Override
    public String extract(Element element, String... s) throws Exception {
        if(s.length < 2) throw new Exception("");
        return element.select(s[0]).attr(s[1]);
    }

}
