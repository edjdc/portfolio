package edjdc.portfolio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import edjdc.portfolio.model.Projeto;
import edjdc.portfolio.service.ProjetoService;

@Controller
@RequestMapping("/")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("projetos", projetoService.findAll());
		return mv; 
	}
	

	@GetMapping("/novo")
	public ModelAndView novo(Projeto projeto) {
		ModelAndView mv = new ModelAndView("/form");
		mv.addObject("projeto", projeto);
		return mv; 
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return this.novo(projetoService.findOne(id));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	@DeleteMapping("/remover/{id}")
    public void remover(@PathVariable("id") Long id) {
		projetoService.delete(id);
    }
	
	
	@PostMapping("/salvar")
    public ModelAndView salvar(@Valid Projeto projeto, BindingResult result) {
        if(result.hasErrors()) {
            return novo(projeto);
        }
        projetoService.save(projeto);
        return new ModelAndView("redirect:/");
    }
	
}
