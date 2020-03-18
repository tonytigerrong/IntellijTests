package com.groovys
import groovy.json.JsonSlurper
class Example1{
    static void main(String[] args){
        def string = "hello world groovy!"
        println(string)
        def i = 0;
        while(i<10){
            println(++i);
        }
        def l = [0,1,3,5,10]
        def file = new File("./text.txt")
        for(def a in l){
            println(a?0:a);
            file << a
        }
        def file1 = new File(".")
        file1.eachFile {
            f -> println f.absolutePath
                println("this is the path : ${f.absolutePath}")
        }
        def ar = 11..15
        def ls = [12,44,40,1]
        ls.pop()
        println(ls)
        if('groovy' =~ '^gro{2}vy'){
            println("match")
        }else{
            println("no match")
        }
        def clos = {param -> println("hello ${param}")}
        clos.call("world!")

        def jsonSlurper = new JsonSlurper()
        Object lst = jsonSlurper.parseText('{ "List1": [2, 3, 4, 5] },"List2": [2, 3, 4, 5, 6] }')
        lst.each { println it }

    }

}