# Example Project to demonstrate *Compiler Driven Development*

This technique can be used to let the compiler literally drive the development
of a given feature or bugfix, including the design and necessary behavior.

It consists of 2 basic steps:

* **Break something!** Break a very specific place in the code by changing
some type or signature that is downstream from all potentially changing
code. Introduce a breaking change that expresses the feature or bugfix
you want to have.
* Then **follow compiler errors!** Just go through all compiler errors and
fix them in accordance with your objectives. Fix all errors in isolation
and as minimally as possible. Note however, that you must make sure that
code that compiles is semantically complete! You can not introduce anything
that can be used to make something compile without it being correct!

# Exercise

The actual feature request for this example is: Thread through all the
backend messages without changing the code structure so that they
appear on the frontend.

Remember, you have to change exactly one thing, and then just follow compiler errors!
