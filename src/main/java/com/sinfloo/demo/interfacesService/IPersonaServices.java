package com.sinfloo.demo.interfacesService;

import java.util.List;
import java.util.Optional;

import com.sinfloo.demo.modelo.Persona;

public interface IPersonaServices {
	
	public List<Persona> listar();
	
	public Optional<Persona> listarPorId(int id);
	
	public int save(Persona p);
	
	public void delete(int id);

}
