package it.dst.digimon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dst.digimon.model.Allenatore;
import it.dst.digimon.model.Digimon;
import it.dst.digimon.service.DigimonService;

public class DigimonController {
	@Autowired
	private DigimonService service;

	@RequestMapping("/")
	public ModelAndView home() {
		List<Allenatore> listAllenatore = service.listAllAle();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listAllenatore", listAllenatore);
		return mav;
	}

	@RequestMapping("/new")
	public String newAllenatoreForm(Model model) {
		Allenatore allenatore = new Allenatore();
		model.addAttribute("allenatore", allenatore);
		return "nuovoAllenatore";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAllenatore(@ModelAttribute("allenatore") Allenatore allenatore) {
		service.saveAle(allenatore);
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public ModelAndView editAllenatoreForm(@RequestParam long id) {
		ModelAndView model = new ModelAndView("modificaAllenatore");
		Allenatore allenatore = service.getAle(id);
		model.addObject("allenatore", allenatore);

		return model;
	}

	@RequestMapping("/delete")
	public String deleteAllenatoreForm(@RequestParam long id) {
		service.deleteAle(id);
		return "redirect:/";
	}

//	@RequestMapping("/")
//	public ModelAndView home() {
//		List<Allenatore> listAllenatore = service.listAllAle();
//		ModelAndView mav = new ModelAndView("index");
//		mav.addObject("listAllenatore", listAllenatore);
//		return mav;
//	}

	@RequestMapping("/newDigimon")
	public String newDigimonForm(Model model) {
		Digimon digimon = new Digimon();
		model.addAttribute("digimon", digimon);
		return "nuovoDigimon";
	}

	@RequestMapping(value = "/saveDigimon", method = RequestMethod.POST)
	public String saveDigimon(@ModelAttribute("digimon") Digimon digimon) {
		service.save(digimon);
		return "redirect:/";
	}

	@RequestMapping("/editDigimon")
	public ModelAndView editProdottoForm(@RequestParam long id) {
		ModelAndView model = new ModelAndView("modificaDigimon");
		Digimon digimon = service.get(id);
		model.addObject("digimon", digimon);

		return model;
	}

	@RequestMapping("/deleteDigimon")
	public String deleteDigimonForm(@RequestParam long id) {
		service.delete(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/indietro", method = RequestMethod.POST)
	public String indietro() {
		return "redirect:/";
	}
}