javanese
========

A Java project to play with. 

So far, there are only two simple implementations to calculate the factorial of a number: Iterate with a loop and Recursive method. The project has the following structure: 

$ tree .
.
├── LICENSE
├── README.md
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── atreceno
    │               └── it
    │                   └── javanese
    │                       └── maths
    │                           ├── Benchmark.java
    │                           ├── FactorialIteration.java
    │                           └── FactorialRecursive.java
    └── test
        └── java
            └── com
                └── atreceno
                    └── it
                        └── javanese
                            └── maths
                                ├── FactorialIterationTest.java
                                └── FactorialRecursiveTest.java

15 directories, 8 files

To run a specific test: 

$ mvn test -Dtest=FactorialRecursiveTest

To compare both implementations: 

$ mvn package
$ java -cp target/javanese-1.0-SNAPSHOT.jar com.atreceno.it.javanese.maths.Benchmark

It looks that the recursive solution is a little bit faster for bigger numbers. For production, consider the use of [other algorithms][] or implementations like the one from [Apache Commons][] or [Google Guava][].

[other algorithms]: http://www.luschny.de/math/factorial/FastFactorialFunctions.htm
[Apache Commons]: http://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/util/ArithmeticUtils.html
[Google Guava]: http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/math/BigIntegerMath.html
