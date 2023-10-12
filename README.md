# DependencyInversion

An example of the Dependency Inversion Principle.

The class _WordCountNoDI_ is a single-class application that has the dependency problem: it depends on low level details, namely the Java library classes that let it read a file for word tokens.

The class _WordCountDIFix_ uses dependency inversion to fix this. It uses the abstract interface _WordSource_ and the implementation of that interface, _WordSourceJavaLib_ to perform the same functionality as the other program, but with the application source now being written at the proper level of abstraction. The details of using the Java library for I/O are encapsulated in the _WordSourceJavaLib_ class.

The Ant build file has to targets, _run-nodi_ and _run-di_ that compile and run these two programs, respectively. You can also run them from the command line.

