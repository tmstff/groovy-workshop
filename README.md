# groovy-workshop

* tooling 
    * groovy & java: https://github.com/groovy/GMavenPlus/wiki/Examples#joint-compilation
    * groovy plugin
    * groovy console
    * scripts
* Groovy
    * basics
        * [groovy_cheat_sheet.pdf](groovy_cheat_sheet.pdf)
        * equality
        * ;
        * script language / compile time checks
        * types / def
        * return
        * braces
        * privacy
        * strings
            * interpolation
            * plain
            * multiline
                * stripMargin
        * regexp
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
        * ```new RESTClient("http://localhost:8000")```
* Spock
    * given, when, then, and (, setup, cleanup, expect)
    * assert
    * with
    * setup(Spec), cleanup(Spec)
    * logging / problem with traits
    * exceptions
    * where + @Unroll
    * mocks
        * declaration
        * behaviour
        * verification
        * dependency injection
    * real-world-examples
        * spock + spring
        * waitFor / TODO Waiting
