package com.activosseguridad.activos_seguridad.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.activosseguridad.activos_seguridad.model.activos;
import com.activosseguridad.activos_seguridad.repository.activosRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class activosController {
    
    @Autowired
    private activosRepository activosRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activos", activosRepository.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/activo/agregar")
    public String formActivos(Model model) {
        activos activo = new activos();
        model.addAttribute("activo", activo);
        return "agregar";
    }

    @PostMapping("/activo")
    public String guardarActivo(@ModelAttribute("activos") activos activo) {
        activosRepository.save(activo);
        return "redirect:/";
    }


    @GetMapping("/activo/editar/{id}")
    public String mostrarActivos(@PathVariable Long id, Model model) {
        Optional<activos> activoOpt = activosRepository.findById(id);
        if (activoOpt.isPresent()) {
            model.addAttribute("activo", activoOpt.get());
            return "agregar";
        } else {
            return "redirect:/?error=notFound";
        }
    }

    @GetMapping("/activo/eliminar/{id}")
    public String eliminarActivo(@PathVariable Long id) {
        if (activosRepository.existsById(id)) {
            activosRepository.deleteById(id);
            return "redirect:/";
        } else {
            return "redirect:/?error=notFound";
        }
    }
}
