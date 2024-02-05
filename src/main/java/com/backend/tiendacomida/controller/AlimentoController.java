package com.backend.tiendacomida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.tiendacomida.model.Alimento;
import com.backend.tiendacomida.model.Categoria;
import com.backend.tiendacomida.service.AlimentoService;

@RequestMapping("/tienda")
public class AlimentoController {

	@Autowired
	private AlimentoService service;
	
	@GetMapping("/categorias")
	public List<Categoria> obtenerCategorias() {
		return service.obtenerTodasCategorias();
	}
	
	@GetMapping("/alimentos")
	public List<Alimento> obtenerTodosAlimentos() {
		return service.obtenerTodos();
	}
	
	@GetMapping("{id}")
	public Alimento alimentoPorId(@PathVariable Long id) {
		Alimento alimento = service.obtenerUnAlimentoPorId(id);
		
		if(alimento == null) {
			throw new RuntimeException("No se encontro ningun alimento");
		}
		
		return alimento;
	}
	
	
}
