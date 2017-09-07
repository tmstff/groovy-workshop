# groovy-workshop

* tooling 
    * groovy & java: https://github.com/groovy/GMavenPlus/wiki/Examples#joint-compilation
    * groovy plugin
    * groovy console
    * scripts
* basics
    * [groovy_cheat_sheet.pdf](groovy_cheat_sheet.pdf)
    * equality
    * ;
    * script language / compile time checks
    * types / def
    * return
    * privacy
* core constructs
    * strings
        * interpolation
        * plain
        * multiline
            * stripMargin
    * closures
    * collections
        * lists
        * maps
        * ranges
        * ops
    * parameters
        * default
        * "named"
        * for constructors
        * test data generation methods
    * traits
* JSON
    * JsonBuilder
    * JsonSlurper
* http
    * https://github.com/jgritman/httpbuilder/wiki
    * ```python -m SimpleHTTPServer 8000```
    * ```new RESTClient("localhost:8000")```
* Spock
    * given, when, then, and (, setup, cleanup, expect)
    * assert
    * with
    * setup(Spec), cleanup(Spec)
    * logging / problem with traits
    * exceptions
    * where + @Unroll
    * real-world-examples
        * mocks
        * declaration
        * behaviour
        * verification
        * dependency injection
        * spock + spring
        * waitFor / TODO Waiting
