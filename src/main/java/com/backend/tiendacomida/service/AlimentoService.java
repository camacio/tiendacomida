package com.backend.tiendacomida.service;

import java.time.LocalDate;
import java.util.List;

import com.backend.tiendacomida.model.Alimento;
import com.backend.tiendacomida.model.Categoria;

public interface AlimentoService {
	
	void crearAlimento(Alimento alimento);
	
	void crearVariosAlimentos(List<Alimento> alimentos);

	Alimento obtenerUnAlimentoPorId(Long id);
	
	Alimento obtenerPrimerAlimento();
	
	List<Alimento> obtenerTodos();
	
	int obtenerNumeroTotalAlimentos();
	
	Categoria obtenerCategoriaAlimentoPorNombre(String nombre);
	
	 List<Categoria> obtenerTodasCategorias();
	
	double obtenerPrecioAlimentoPorId(Long id);
	
	double obtenerMediaPrecioTodosAlimentos();
	
	double obtenerPrecioMininoAlimento();
	
	double obtenerPrecioMaximoAlimento();
	
	double obtenerPrecioTotalTodosAlimentos();
	
	LocalDate obtenerFechaCaducidadAlimentoPorId(Long id);
	
	void actualizarAlimento(Alimento alimento);
	
	void eliminarAlimentoPorId(Long id);
	
	void eliminarAlimento(Alimento alimento);
	
	void eliminarTodosLosAlimentos();
	
	List<Alimento> ordenarAlimentos();
	
	List<Alimento> desordenarAlimentos();
}
