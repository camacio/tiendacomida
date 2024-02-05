package com.backend.tiendacomida.service;

import java.time.LocalDate;
import java.util.List;

import com.backend.tiendacomida.model.Alimento;
import com.backend.tiendacomida.model.Categoria;

public interface AlimentoService {
	
	void crearPlato(Alimento plato);
	
	void crearVariosPlatos(List<Alimento> comida);

	String obtenerUnPlatoPorId(Long id);
	
	String obtenerPrimerPlato();
	
	List<Alimento> obtenerTodos();
	
	int obtenerNumeroTotalPlatos();
	
	String obtenerCategoriaPlatoPorNombre(String nombre);
	
	 List<Categoria> obtenerTodasCategorias();
	
	double obtenerPrecioPlatoPorId(Long id);
	
	double obtenerMediaPrecioTodosPlatos();
	
	double obtenerPrecioMininoPlato();
	
	double obtenerPrecioMaximoPlato();
	
	double obtenerPrecioTotalTodosPlatos();
	
	LocalDate obtenerFechaCaducidadPlatoPorId(Long id);
	
	void actualizarPlato(Alimento plato);
	
	void eliminarPlatoPorId(Long id);
	
	void eliminarPlato(Alimento plato);
	
	void eliminarTodosLosPlatos();
	
	List<Alimento> ordenarPlatos();
	
	List<Alimento> desordenarPlatos();
}
