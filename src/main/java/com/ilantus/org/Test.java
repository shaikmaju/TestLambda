package com.ilantus.org;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Test {
    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        LOG.info("Main() is called...");
        TestLambdaJdbi lambda = new TestLambdaJdbi();
        List<Employee> list = lambda.getEmployeeDetails();
        LOG.info("The List of Employee Details=" + list);
    }
}
