package com.backend.tiendacomida.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.tiendacomida.model.Alimento;
import com.backend.tiendacomida.model.Categoria;
import com.backend.tiendacomida.repository.AlimentoRepository;
import com.backend.tiendacomida.service.AlimentoService;

public class AlimentoServiceImpl implements AlimentoService {

	@Autowired
	private AlimentoRepository repository;
	
	@Override
	public void crearPlato(Alimento plato) {
		Objects.requireNonNull(plato);
		
		repository.save(plato);
	}

	@Override
	public String obtenerUnPlatoPorId(Long id) {
		Objects.requireNonNull(id);
		
		return repository.findById(id).get().getNombre();
	}

	@Override
	public String obtenerPrimerPlato() {
		return repository.findAll().stream().findFirst().get().getNombre();
	}

	@Override
	public List<Alimento> obtenerTodos() {
		return repository.findAll();
	}

	@Override
	public String obtenerCategoriaPlatoPorNombre(String nombre) {
		Objects.requireNonNull(nombre);
		
		return repository.findAll().stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).toString();
	}

	@Override
	public List<Categoria> obtenerTodasCategorias() {
		return repository.findAll().stream().map(p -> p.getCategoria()).collect(Collectors.toList());
	}

	@Override
	public double obtenerPrecioPlatoPorId(Long id) {
		return (int) repository.findById(id).get().getPrecio();
	}

	@Override
	public double obtenerMediaPrecioTodosPlatos() {
		return repository.findAll().stream().mapToDouble(p -> p.getPrecio()).average().getAsDouble();
	}

	@Override
	public LocalDate obtenerFechaCaducidadPlatoPorId(Long id) {
		return repository.findById(id).get().getFechaCaducidad();
	}

	@Override
	public void actualizarPlato(Alimento plato) {
		Objects.requireNonNull(plato);
		
		boolean existe = repository.existsById(plato.getId());
		
		if(!existe) {
			throw new IllegalArgumentException("No existe un plato con el id");
		}
		
	}

	@Override
	public void eliminarPlatoPorId(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void eliminarPlato(Alimento plato) {
		Objects.requireNonNull(plato);
		
		repository.delete(plato);
		
	}

	@Override
	public void eliminarTodosLosPlatos() {
		repository.deleteAll();
	}

	@Override
	public void crearVariosPlatos(List<Alimento> comida) {
		Objects.requireNonNull(comida);
		
		repository.saveAll(comida);
		
	}

	@Override
	public int obtenerNumeroTotalPlatos() {
		return (int) repository.count();
	}

	@Override
	public double obtenerPrecioMininoPlato() {
		return repository.findAll().stream().mapToDouble(p -> p.getPrecio()).min().getAsDouble();
	}

	@Override
	public double obtenerPrecioMaximoPlato() {
		return repository.findAll().stream().mapToDouble(p -> p.getPrecio()).max().getAsDouble();
	}

	@Override
	public List<Alimento> ordenarPlatos() {
		return repository.findAll().stream().sorted().collect(Collectors.toList());
		
	}

	@Override
	public List<Alimento> desordenarPlatos() {
		return repository.findAll().stream().unordered().collect(Collectors.toList());
	}

	@Override
	public double obtenerPrecioTotalTodosPlatos() {
		return repository.findAll().stream().mapToDouble(p -> p.getPrecio()).sum();
	}

}
