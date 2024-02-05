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
	public void crearAlimento(Alimento alimento) {
		Objects.requireNonNull(alimento);
		
		repository.save(alimento);
	}

	@Override
	public Alimento obtenerUnAlimentoPorId(Long id) {
		Objects.requireNonNull(id);
		
		return repository.findById(id).get();
	}

	@Override
	public Alimento obtenerPrimerAlimento() {
		return repository.findAll().stream().findFirst().get();
	}

	@Override
	public List<Alimento> obtenerTodos() {
		return repository.findAll();
	}

	@Override
	public Categoria obtenerCategoriaAlimentoPorNombre(String nombre) {
		Objects.requireNonNull(nombre);
		
		return repository.findAll().stream()
				.filter(p -> p.getNombre().equalsIgnoreCase(nombre))
				.findFirst()
				.get()
				.getCategoria();
	}

	@Override
	public List<Categoria> obtenerTodasCategorias() {
		return repository.findAll()
				.stream()
				.map(p -> p.getCategoria())
				.collect(Collectors.toList());
	}

	@Override
	public double obtenerPrecioAlimentoPorId(Long id) {
		return (int) repository.findById(id).get().getPrecio();
	}

	@Override
	public double obtenerMediaPrecioTodosAlimentos() {
		return repository.findAll().stream()
				.mapToDouble(p -> p.getPrecio())
				.average()
				.getAsDouble();
	}

	@Override
	public LocalDate obtenerFechaCaducidadAlimentoPorId(Long id) {
		return repository.findById(id).get().getFechaCaducidad();
	}

	@Override
	public void actualizarAlimento(Alimento alimento) {
		Objects.requireNonNull(alimento);
		
		boolean existe = repository.existsById(alimento.getId());
		
		if(!existe) {
			throw new IllegalArgumentException("No existe un Alimento con el id");
		}
		
	}

	@Override
	public void eliminarAlimentoPorId(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void eliminarAlimento(Alimento alimento) {
		Objects.requireNonNull(alimento);
		
		repository.delete(alimento);
		
	}

	@Override
	public void eliminarTodosLosAlimentos() {
		repository.deleteAll();
	}

	@Override
	public void crearVariosAlimentos(List<Alimento> alimentos) {
		Objects.requireNonNull(alimentos);
		
		repository.saveAll(alimentos);
	}

	@Override
	public int obtenerNumeroTotalAlimentos() {
		return (int) repository.count();
	}

	@Override
	public double obtenerPrecioMininoAlimento() {
		return repository.findAll()
				.stream()
				.mapToDouble(p -> p.getPrecio())
				.min()
				.getAsDouble();
	}

	@Override
	public double obtenerPrecioMaximoAlimento() {
		return repository.findAll()
				.stream()
				.mapToDouble(p -> p.getPrecio())
				.max()
				.getAsDouble();
	}

	@Override
	public List<Alimento> ordenarAlimentos() {
		return repository.findAll()
				.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	@Override
	public List<Alimento> desordenarAlimentos() {
		return repository.findAll()
				.stream()
				.unordered()
				.collect(Collectors.toList());
	}

	@Override
	public double obtenerPrecioTotalTodosAlimentos() {
		return repository.findAll()
				.stream()
				.mapToDouble(p -> p.getPrecio())
				.sum();
	}

}
