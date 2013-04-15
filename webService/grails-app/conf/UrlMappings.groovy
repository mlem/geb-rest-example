class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/restservice/$controller/$id?" (parseRequst: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }
        /*
        "/person/$id"(controller: "person", parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }  */

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
