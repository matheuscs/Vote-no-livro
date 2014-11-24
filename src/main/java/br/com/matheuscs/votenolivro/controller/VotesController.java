package br.com.matheuscs.votenolivro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.matheuscs.votenolivro.model.ComputaVotosInterface;

@Controller
public class VotesController {

	@Autowired
	private ComputaVotosInterface computaVotos;

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public VotesController() {
		super();
	}

	@RequestMapping(value="/votacao", method = RequestMethod.POST)
	public String votacao(Model model, String livroEscolhido) {
		System.out.println("Livro escolhido: " + livroEscolhido);
		if(livroEscolhido != null) {
			computaVotos.somaVoto(livroEscolhido);
		}
		String livro1 = computaVotos.sorteiaLivro(null);
		String livro2 = computaVotos.sorteiaLivro(livro1);
		model.addAttribute("livro1", livro1);
		model.addAttribute("livro2", livro2);
		if(computaVotos.finalizado()) {
			return "email";
		}
		else {
			return "votacao";
		}
	}
}
