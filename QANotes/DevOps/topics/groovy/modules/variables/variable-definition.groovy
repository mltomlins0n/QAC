#!/usr/bin/env groovy
# get the current user on the system
String name = System.getenv("USER")
# say hello to the user
println "Hello ${name}"
