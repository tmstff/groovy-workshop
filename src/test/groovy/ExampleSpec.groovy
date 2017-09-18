import groovy.util.logging.Log
import groovyx.net.http.RESTClient
import spock.lang.Specification
import spock.lang.Unroll

@Log
class ExampleSpec extends Specification {

    def now

    def setup() {
        now = System.currentTimeMillis()
    }

    def "example for basic given-when-then-structure"() {
        given: "a string"
        def s = "I am a String"

        and: "backup copy of original String"
        def orgS = s

        when: "the length is determined"
        def length = s.length()

        then: "the length is correct"
        length == 13

        and: "the original string s not been changed"
        orgS == s

        when:
        def newS = s + "-test"

        then:

        assert newS == "I am a String-test"
    }

    def "test object equality"() {
        when:
        def user1 = new User(firstName: "Tim", lastName: "Steffens")
        def user2 = new User(firstName: "Tim", lastName: "Steffens")
        then:
        user1.equals(user2)
    }

    def "acessing a map with 'with'"() {
        when:
        def a = [b: "B", d: "D"]
        log.info("a: $a")

        then:
        with a, {
            b == "B"
            d == "D"
        }
    }

    def "example involving setup method"() {
        when:
        Thread.sleep(1)

        then:
        now < System.currentTimeMillis()

    }


    def "exception handling"() {
        when:
        throw new RuntimeException("falsch")

        then:
        def e = thrown(RuntimeException)
        e.message == "falsch"
    }

    @Unroll
    def "data tables: addition #i + #j = #expextedResult"() {
        when:
        def result = add(i, j)

        then:
        result == expextedResult

        where:
        i | j      | expextedResult
        1 | 100000 | 100001
        2 | 3      | 5
        4 | 5      | 9
    }

    @Unroll
    def "data tables: addition #i + #j = #expextedResult (alternative syntax)"() {
        when:
        def result = add(i, j)

        then:
        result == expextedResult

        where:
        i <<                [1,         2, 4]
        j <<                [100000,    3, 5]
        expextedResult <<   [100001,    5, 9]
    }

    @Unroll
    def 'List combination input #i, #j, #k' () {
        when:
        def result = add(add(i, j), k)

        then:
        result == i + j + k

        where:
        [i, j, k] << [[1, 2, 3],
                      [4, 5, 6],
                      [7, 8, 9, 10]
        ].combinations()
    }

    int add(Integer i, Integer j) {
        i + j
    }

    class UserClient {
        RESTClient restClient

        def addUser(name) {
            restClient.post([name: name]).id
        }
    }

    def "simple mocking"() {
        given:
        def restClientMock = Mock(RESTClient)
        def userClient = new UserClient(restClient: restClientMock)

        1 * restClientMock.post([name: "Hanno"]) >> [id: "id1235"]

        when:
        def result = userClient.addUser("Hanno")

        then:
        result == "id1235"
    }

    def "mocking: return different results"() {
        given:
        def restClientMock = Mock(RESTClient)
        def userClient = new UserClient(restClient: restClientMock)

        2 * restClientMock.post([name: "Hanno"]) >>> [[id: "id1235"], { throw RuntimeException("test") }]

        when:
        def result1 = userClient.addUser("Hanno")
        def result2 = userClient.addUser("Hanno")

        then:
        thrown(RuntimeException)
        result1 == "id1235"
    }
}
