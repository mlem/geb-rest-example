package org.gebish.example

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: BeoXTC
 * Date: 12.04.13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
class PersonShowPage extends Page {

    static url = "webService/person/show"

    static at = { $('#show-person') }

    static content = {
        personProperty {index -> $('ol',class: 'property-list person').find('li')[index].find("span.property-value") }
        birthday { personProperty(0) }
        city { personProperty(1) }
        firstName { personProperty(2) }
        lastName { personProperty(3) }
        id { $('#id') }
    }

}
