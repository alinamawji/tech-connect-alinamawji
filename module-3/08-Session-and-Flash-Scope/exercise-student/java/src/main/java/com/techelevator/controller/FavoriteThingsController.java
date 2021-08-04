package com.techelevator.controller;

import com.techelevator.model.FavoriteThings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("favoriteThings")
@RequestMapping("/FavoriteThings")
public class FavoriteThingsController {

	@RequestMapping(path = "/Page1", method = RequestMethod.GET)
	public String getPage1(ModelMap map) {
		return "Page1";
	}

	@RequestMapping(path = "/Page1", method = RequestMethod.POST)
	public String postPage1(@RequestParam String favoriteColor, ModelMap map) {
		FavoriteThings favoriteThings = new FavoriteThings();
		favoriteThings.setFavoriteColor(favoriteColor);
		map.put("favoriteThings", favoriteThings);
		return "redirect:/FavoriteThings/Page2";
	}

	@RequestMapping(path = "/Page2", method = RequestMethod.GET)
	public String getPage2() {
		return "Page2";
	}

	@RequestMapping(path = "/Page2", method = RequestMethod.POST)
	public String postPage2(@RequestParam String favoriteFood, ModelMap map) {
		FavoriteThings favoriteThings = (FavoriteThings) map.get("favoriteThings");
		favoriteThings.setFavoriteFood(favoriteFood);
		return "redirect:/FavoriteThings/Page3";
	}

	@RequestMapping(path = "/Page3", method = RequestMethod.GET)
	public String getPage3() {
		return "Page3";
	}

	@RequestMapping(path = "/Page3", method = RequestMethod.POST)
	public String postPage3(@RequestParam String favoriteSeason, ModelMap map) {
		FavoriteThings favoriteThings = (FavoriteThings) map.get("favoriteThings");
		favoriteThings.setFavoriteSeason(favoriteSeason);
		return "redirect:/FavoriteThings/Summary";
	}

	@RequestMapping(path = "/Summary", method = RequestMethod.GET)
	public String getSummaryPage(ModelMap map) {
		return "Summary";
	}
}
