package com.groovys


import junit.framework.Test

class TestSuiteExample {
    static Test suite() {
        def allTests = new GroovyTestSuite()
        allTests.addTestSuite(StudentTestCase.class)

        return allTests
    }
}

