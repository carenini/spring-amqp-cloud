This project hosts some samples that complement [Spring AMQP](http://github.com/SpringSource/spring-amqp), showing you how to get started with Spring and AMQP.

# Build Instructions #

Get an account on [Cloudfoundry](http://www.cloudfoundry.com).
Then clone from GIT and then use Maven (2.1.*):

    $ git clone ...
    $ mvn install
    $ cd target
    $ vmc push

SpringSource ToolSuite users (or Eclipse users with the latest
m2eclipse plugin) can import the projects as existing Maven projects.

The basic HelloWorld sample has two versions (with synchronous and
asynchronous consumers).  Both have two Java classes called `Producer`
and `Consumer` with main methods to launch.  Run the producer first
and ensure that the broker is already running.


