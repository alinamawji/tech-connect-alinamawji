package com.techelevator;

import java.util.List;
import java.util.Map;

import com.techelevator.dao.ActorDao;

import com.techelevator.dao.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping(value="/actorList", method = RequestMethod.GET)
	/* What request mapping do we want here */
	public String showSearchActorForm() {
		return "actorList";
	}

	@RequestMapping(value="/actorList/search", method = RequestMethod.GET)
	/* What about here? */
	public String searchActors(@RequestParam String last_name, ModelMap modelHolder) {
		/* Call the model and pass values to the jsp */
		List<Actor> actors = actorDao.getMatchingActors(last_name);
		modelHolder.put("actors", actors);
		return "actorList";
	}
}
