package br.com.matheuscs.votenolivro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.matheuscs.votenolivro.model.ComputaVotosInterface;

@Controller
public class VotesController {
	private ComputaVotosInterface model;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/votacao", method = RequestMethod.GET)
	public String a() {
		return "email";
	}


}
