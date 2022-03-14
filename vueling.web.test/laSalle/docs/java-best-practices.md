# Java Best practices

* Read the [Java Naming Conventions]:http://www.oracle.com/technetwork/java/codeconventions-135099.html
* Read [the Coding style guide](style-guide.md)

And take care of:
* Methods in well-designed object-oriented code are short. Strive to keep methods less than 10 lines. Reconsider methods that are over a page in length, breaking them into several methods representing smaller blocks of functionality.
* Break up long methods into small methods. This promotes code reuse and allows for more combinations of methods. If the number of methods grows to be difficult to understand, then look at decomposing the class into more than one class.
* Follow the 30-second rule. Another programmer should be able to look at your method and fully understand what it does, why it does it and how it does it in less than 30-seconds. If that is not possible, then your code is too complex and difficult to maintain. A good rule of thumb is that a method should be no more than a screen in length.
* Keep it simple
* Avoid nesting blocks of statements more than 2 or 3 levels deep. This adds to the complexity of the code. A method should be easy to read and understand. Easy to maintain is the goal.
* Avoid nesting method calls too deeply, since this can introduce undue complexity.
* Avoid using compound predicates:

     if (x>0 && x<100 && y>0 && y<100 || z==1000)

     Think of all the combinations you will have to write to adequately test the above condition (2^5 or 32 different combinations).


- Every day: Revisit, Refactor, and Improve -> left the 'things' better than you meet

- Never write anything if it is not necessary.
  For example, do not define elements in a page object that maybe we will not use.

## Samples

- Use functional names when possible (vs use html names)

    Example:
```groovy
        BAD:
            "clickBtnGetStatus"
         OK:
            "showStatus"
```

- Use LOGGER to log details of the execution. To show the flow of the execution.
```groovy

    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import java.lang.invoke.MethodHandles;
    ....
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
```
