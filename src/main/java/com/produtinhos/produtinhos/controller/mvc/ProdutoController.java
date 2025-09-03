package com.produtinhos.produtinhos.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.produtinhos.produtinhos.model.Produto;
import com.produtinhos.produtinhos.service.ProdutoService;

import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping({ "", "/" })
    public ModelAndView index() {
        return new ModelAndView("/produtos/index")
                .addObject("produtos", produtoService.findAll());
    }

    @GetMapping("/cadastrar")
    public ModelAndView indexRegisterPage() {
        return new ModelAndView("/produtos/cadastrar")
                .addObject("produto", new Produto());
    }

    @GetMapping("/editar/{id}")
    public ModelAndView indexUpdatePage(@PathVariable Long id) {
        return new ModelAndView("/produtos/editar")
                .addObject("produto", produtoService.findById(id));
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id) {
        produtoService.delete(id);
        return new ModelAndView("redirect:/produtos");
    }

    @PostMapping("")
    public ModelAndView save(@Valid Produto produto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/produtos/cadastrar")
                    .addObject("produto", produto);
        }

        produtoService.save(produto);
        return new ModelAndView("redirect:/produtos");
    }

    @PostMapping("/editar/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid Produto produto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/produtos/editar")
                    .addObject("produto", produto);
        }

        produtoService.update(id, produto);
        return new ModelAndView("redirect:/produtos");
    }

}
