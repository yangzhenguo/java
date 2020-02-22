#!/usr/bin/env bash
#cd ../../../../../
echo $PWD
#cd `dirname $0`
#dir=`pwd`
mkdir out
echo ${PWD}/src/main/java
javac -sourcepath ${PWD}/src/main/java -d ./out -cp "/Users/Sam/.m2/repo/org/projectlombok/lombok/1.16.6/lombok-1.16.6.jar:/Users/Sam/.m2/repo/junit/junit/4.12/junit-4.12.jar" **/factory/**/*.java
