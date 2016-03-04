package com.kunyan.htmlparse.strategyPattern;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import java.util.Stack;

/**
 * Created by make on 2/29/16.
 */
public class StrategyDemo {

    public static void main(String[] args) throws Exception {

        OperationFactory operationFactory = new OperationFactory();
        operationFactory.addCommandOperation("select", new SelectionOperation());
        operationFactory.addCommandOperation("substring", new SubstringOperation());
        OperationContext operationContext = new OperationContext(operationFactory.getOperationMap());

        Stack<String> stack = new Stack<>();
        stack.addElement("");
        stack.pop();

        System.out.println(operationContext.execute(Command.SELECT, new Element(Tag.valueOf(""), ""), "abc"));
        System.out.println(operationContext.execute(Command.SUBSTRING, new Element(Tag.valueOf(""), ""), "abc", "3"));



    }
}
