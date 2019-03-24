/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.micon.TestWorld.controller;

import de.micon.TestWorld.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mike
 */
@Controller
public class ExportController {

    private final ArticleService articleService;
    
    @Autowired
    public ExportController(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    @GetMapping("/export")
    public String exportMain(Model model){
        model.addAttribute("article", articleService.getAllArticle());
        return "export";
    }
    
}
