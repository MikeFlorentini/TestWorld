/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.micon.TestWorld.controller;

import de.micon.TestWorld.form.ArticleForm;
import de.micon.TestWorld.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import de.micon.TestWorld.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mike
 */
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/article", produces = "application/json")
    public @ResponseBody Article getSingleArticle(@RequestParam(name = "uid") Long articleId) {
        Article article = articleService.getArticle(articleId);
        return new Article(article.getUid(), article.getName(), article.getDescription(), article.getPrice(), article.getUnits());
    }

    @GetMapping("/articleList")
    public String articleList(Model model) {
        model.addAttribute("article", articleService.getAllArticle());

        return "article_list";
    }

    @GetMapping("/article/{articleId}")
    public String getArticle(Model model, @PathVariable("articleId") long articleId) {
        ArticleForm articleForm = new ArticleForm();
        model.addAttribute("articleForm", articleForm);
        model.addAttribute("article", articleService.getArticle(articleId));

        return "article_detail";
    }

    @PostMapping("/article/{articleId}")
    public String editArticle(Model model, @PathVariable("articleId") long articleId, @ModelAttribute Article article) {
        ArticleForm articleForm = new ArticleForm();
        model.addAttribute("articleForm", articleForm);
        articleService.editArticle(article);
        model.addAttribute("article", article);

        return "article_detail";
    }

    @GetMapping("/deleteArticle/{articleId}")
    public String deleteArticleForm(Model model, @PathVariable("articleId") long articleId) {
        Article article = articleService.getArticle(articleId);
        model.addAttribute("article", articleService.editArticle(article));

        return "delete_article";
    }

    @PostMapping("/deleteArticle/{articleId}")
    public String deleteArticle(Model model, @PathVariable("articleId") long articleId) {
        articleService.deleteArticle(articleId);
        return "redirect:/articleList";
    }

    @GetMapping("/addArticle")
    public String showAddedArticle(Model model) {
        ArticleForm articleForm = new ArticleForm();
        model.addAttribute("articleForm", articleForm);

        return "add_article";
    }

    @PostMapping("/addArticle")
    public String saveArticle(Model model, @ModelAttribute Article article) {
        articleService.createArticle(article);
        model.addAttribute("article", articleService.getAllArticle());
        return "redirect:/articleList";
    }

}
