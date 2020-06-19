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
import it.dst.digimon.service.DigimonService;
import it.dst.digimon.utility.AtkSort;
import it.dst.digimon.utility.Context;
import it.dst.digimon.utility.DefSort;
import it.dst.digimon.utility.ResSort;

@Controller
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
	@RequestMapping(value = "/saveMod", method = RequestMethod.POST)
	public String saveAllenatoreModificato(@ModelAttribute("allenatore") Allenatore allenatore) {
		Allenatore vecchio = service.getAle(allenatore.getId());
		allenatore.setListaDigimon(vecchio.getListaDigimon());
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

	@RequestMapping("/newDigimon")
	public String newDigimonForm(Model model) {
		Digimon digimon = new Digimon();
		model.addAttribute("digimon", digimon);
		return "aggiungiDigimon";
	}

	@RequestMapping(value = "/saveDigimon", method = RequestMethod.POST)
	public String saveDigimon(@ModelAttribute("digimon") Digimon digimon) {
		service.save(digimon);
		return "redirect:/";
	}

	@RequestMapping("/editDigimon")
	public ModelAndView editProdottoForm(@RequestParam long id) {
		ModelAndView model = new ModelAndView("modifica_digimon");
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

	@RequestMapping("/assegna")
	public ModelAndView assegnaDigimonForm(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("assegna_digimon");
		List<Digimon> listaDigimon = service.listAll();
		model.addObject("idAle", id);
		model.addObject("lista", listaDigimon);
		return model;
	}

	@RequestMapping("/aggiungi")
	public ModelAndView aggiungiDigimon(@RequestParam Long id, @RequestParam Long idAle) {
		ModelAndView model = new ModelAndView("redirect:/");
		Allenatore allenatore = service.getAle(idAle);
		Digimon digimon = service.get(id);
		allenatore.getListaDigimon().add(digimon);
		service.saveAle(allenatore);
		return model;
	}

	@RequestMapping("/listaDigimon")
	public ModelAndView viewDigimonForm() {
		ModelAndView model = new ModelAndView("mostra_digimon");
		List<Digimon> listaDigimon = service.listAll();
		model.addObject("lista", listaDigimon);
		return model;
	}

	@RequestMapping("/sortDigimon")
	public ModelAndView ordinamentoDigimon(@RequestParam int ordinamento) {
		ModelAndView model = new ModelAndView("mostra_digimon");
		List<Digimon> lista = service.listAll();
		switch (ordinamento) {

		case 0:
			Context ctx = new Context(new AtkSort());
			ctx.ordinamento(lista);
			break;
		case 1:
			Context ctx1 = new Context(new DefSort());
			ctx1.ordinamento(lista);
			break;
		case 2:
			Context ctx2 = new Context(new ResSort());
			ctx2.ordinamento(lista);
			break;

		}
		model.addObject("lista", lista);
		return model;
	}
	@RequestMapping("/listaDigimonAll")
	public ModelAndView viewDigimonAllForm(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("mostra_digimon_allenatore");
		Allenatore allenatore = service.getAle(id);
		model.addObject("lista", allenatore.getListaDigimon());
		return model;
		}
}
