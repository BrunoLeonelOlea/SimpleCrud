package com.sinfloo.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinfloo.demo.interfacesService.IPersonaServices;
import com.sinfloo.demo.modelo.Persona;

@Controller
@RequestMapping
public class PersonaController {
	
	@Autowired
	private IPersonaServices service;
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "formpro";
	}
	
	@PostMapping("/save")
	public String save(Persona p,Model model) {
		service.save(p);
		return "redirect:/listar";
		
	}
	
	@GetMapping(path ="/listar")
	public String listar(Model model) {
		List<Persona> personas = service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id,Model model) {
		Optional<Persona> persona = service.listarPorId(id);
		model.addAttribute("persona", persona);	
		return "formpro";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}

}
