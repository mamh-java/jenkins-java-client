jenkins-java-client
======================

# A jenkins API Client for Java


Introduction
-----------

Java implementation of the [Jenkins] REST API.
 

Usage
-------
```java

URI uri = new URI("http://localhost:8080/");
String username = "mage";
String password = "token";
server = new JenkinsServer(uri, username, password); 

List<Job> jobs = server.getJobs("view");//获取视图 view 下面的jobs

List<Job> jobs = server.getJobs(); //默认获取视图All下面的jobs

```