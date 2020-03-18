package com.groovys
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
class Example2{
    static void main(String[] args){
        def obj = new JsonSlurper().parseText("""
            { "name": "John", "ID" : "1"}
        """)
        println(obj.name + ";" + obj.ID);
        def json = JsonOutput.toJson(obj)
        println(json)
    }
}