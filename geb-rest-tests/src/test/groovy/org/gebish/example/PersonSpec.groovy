package org.gebish.example

import geb.spock.GebReportingSpec
import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Stepwise

//@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6' )

@Stepwise
class PersonSpec extends GebReportingSpec {

    @Shared String personId

    @Shared
    private def restUrl = "${ browser.baseUrl }webService/restservice/"

    @Shared
    private def client = new RESTClient()

    def "create a user in browser"() {
        when:
        to PersonCreatePage

        and:
        birthdayYear.value(1984)
        city.value("Vienna")
        firstName.value("Martin")
        lastName.value("Lemanski")
        createButton.click()

        then:
        waitFor {
            at PersonShowPage
        }

        when:
        personId = id.value()

        then:
        birthday.text().endsWith('1984 00:00:00 MESZ')
        city.text() == 'Vienna'
        firstName.text() == 'Martin'
        lastName.text() == 'Lemanski'
    }

    def "verify user with rest"() {
        when:
        def resp = client.get(uri: restUrl, path: "person/${personId}.json")
        assert resp.status == 200
        assert resp.contentType == "application/json"
        def person = resp.data.personInstance

        then:
        assert person.id == personId.toInteger()
        assert person.firstName == "Martin"
        assert person.lastName == "Lemanski"
        assert person.city == "Vienna"
        assert person.birthday == "1984-04-14T22:00:00Z"
    }

    def "delete user with rest"() {
        when:
        def resp = client.delete(uri: restUrl, path: "person/${personId}.json")
        then:
        assert resp.status == 302  // "not found" status code
    }


}
