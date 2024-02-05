package com.backend.tiendacomida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.tiendacomida.service.AlimentoService;

@RequestMapping("/platos")
public class AlimentoController {

	@Autowired
	private AlimentoService service;
	
	
}
