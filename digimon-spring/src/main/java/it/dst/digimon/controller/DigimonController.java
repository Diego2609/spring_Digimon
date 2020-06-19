package it.dst.digimon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dst.digimon.model.Allenatore;
import it.dst.digimon.model.Digimon;
import it.dst.digimon.service.AllenatoreService;
import it.dst.digimon.service.DigimonService;
import it.dst.digimon.strategy.sort.AtkSort;
import it.dst.digimon.strategy.sort.Context;
import it.dst.digimon.strategy.sort.DefSort;
import it.dst.digimon.strategy.sort.ResSort;

@Controller
public class DigimonController {

	@Autowired
	private DigimonService digimonService;

	@Autowired
	private AllenatoreService allenatoreService;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		List<Allenatore> listAllenatore = allenatoreService.listAll();
		mav.addObject("listAllenatore", listAllenatore);
		return mav;
	}

	@RequestMapping("/new")
	public String newAllenatoreForm(Model model) {
		Allenatore allenatore = new Allenatore();
		model.addAttribute("allenatore", allenatore);
		return "nuovoAllenatore";
//		return new ModelAndView("nuovoAllenatore");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAllenatore(@ModelAttribute("allenatore") Allenatore allenatore) {
		allenatoreService.save(allenatore);
		return "redirect:/";
	}

	@RequestMapping(value = "/saveMod", method = RequestMethod.POST)
	public String saveAllenatoreModificato(@ModelAttribute("allenatore") Allenatore allenatore) {
		Allenatore vecchio = allenatoreService.get(allenatore.getId());
		allenatore.setListaDigimon(vecchio.getListaDigimon());
		allenatoreService.save(allenatore);
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public ModelAndView editAllenatoreForm(@RequestParam long id) {
		ModelAndView model = new ModelAndView("modificaAllenatore");
		Allenatore allenatore = allenatoreService.get(id);
		model.addObject("allenatore", allenatore);

		return model;
	}

	@RequestMapping("/delete")
	public String deleteAllenatoreForm(@RequestParam long id) {
		allenatoreService.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/newDigimon")
	public String newDigimonForm(Model model) {
		Digimon digimon = new Digimon();
		model.addAttribute("digimon", digimon);
		return "aggiungiDigimon";
	}

	@RequestMapping(value = "/saveDigimon", method = RequestMethod.POST)
	public String saveDigimon(@ModelAttribute("digimon") Digimon digimon) {
		digimonService.save(digimon);
		return "redirect:/";
	}

	@RequestMapping("/editDigimon")
	public ModelAndView editProdottoForm(@RequestParam long id) {
		ModelAndView model = new ModelAndView("modifica_digimon");
		Digimon digimon = digimonService.get(id);
		model.addObject("digimon", digimon);

		return model;
	}

	@RequestMapping("/deleteDigimon")
	public String deleteDigimonForm(@RequestParam long id) {
		digimonService.delete(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/indietro", method = RequestMethod.POST)
	public String indietro() {
		return "redirect:/";
	}

	@RequestMapping("/assegna")
	public ModelAndView assegnaDigimonForm(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("assegna_digimon");
		List<Digimon> listaDigimon = digimonService.listAll();
		model.addObject("idAle", id);
		model.addObject("lista", listaDigimon);
		return model;
	}

	@RequestMapping("/aggiungi")
	public ModelAndView aggiungiDigimon(@RequestParam Long id, @RequestParam Long idAle) {
		ModelAndView model = new ModelAndView("redirect:/");
		Allenatore allenatore = allenatoreService.get(idAle);
		Digimon digimon = digimonService.get(id);
		allenatore.getListaDigimon().add(digimon);
		allenatoreService.save(allenatore);
		return model;
	}

	@RequestMapping("/listaDigimon")
	public ModelAndView viewDigimonForm() {
		ModelAndView model = new ModelAndView("mostra_digimon");
		List<Digimon> listaDigimon = digimonService.listAll();
		model.addObject("lista", listaDigimon);
		return model;
	}

	@RequestMapping("/sortDigimon")
	public ModelAndView ordinamentoDigimon(@RequestParam int ordinamento) {
		ModelAndView model = new ModelAndView("mostra_digimon");
		List<Digimon> lista = digimonService.listAll();
		Context<Digimon> ctx = new Context<>(new AtkSort());
		switch (ordinamento) {
		case 0:
			ctx.changeStrategy(new AtkSort());
			break;
		case 1:
			ctx.changeStrategy(new DefSort());
			break;
		case 2:
			ctx.changeStrategy(new ResSort());
			break;

		}
		ctx.ordinamento(lista);
		model.addObject("lista", lista);
		return model;
	}

	@RequestMapping("/listaDigimonAll")
	public ModelAndView viewDigimonAllForm(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("mostra_digimon_allenatore");
		Allenatore allenatore = allenatoreService.get(id);
		model.addObject("lista", allenatore.getListaDigimon());
		return model;
	}
}
