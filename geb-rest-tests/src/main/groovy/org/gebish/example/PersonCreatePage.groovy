package org.gebish.example

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: BeoXTC
 * Date: 12.04.13
 * Time: 21:14
 * To change this template use File | Settings | File Templates.
 */
class PersonCreatePage extends Page {

    static url = "webService/person/create"

    static at = { $('#create-person') }

    static content = {
        form { $("form", action: "/webService/person/save") }
        birthdayYear { $('#birthday_year') }
        city { $("#city") }
        firstName { $("#firstName") }
        lastName { $("#lastName") }
        createButton { $("#create") }
    }


}
