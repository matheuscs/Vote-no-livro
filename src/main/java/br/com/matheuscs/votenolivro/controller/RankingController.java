package br.com.matheuscs.votenolivro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.matheuscs.votenolivro.model.ComputaVotosInterface;

@Controller
public class RankingController {
	
	@Autowired
	private ComputaVotosInterface computaVotos;
	
	@RequestMapping(value="/ranking", method=RequestMethod.POST) 
	public String mostraRanking(Model model) {
		computaVotos.consolidaVotosNoRanking();
		model.addAttribute("votos", computaVotos.pegaResultado());
		model.addAttribute("todosOsVotos", computaVotos.pegaTodosOsResultados());
		return "ranking";
	}
}
