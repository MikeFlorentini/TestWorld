/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.micon.TestWorld.service;

import de.micon.TestWorld.model.Article;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.micon.TestWorld.repository.ArticleRepository;

/**
 *
 * @author mike
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRespository;

    @Override
    public Article createArticle(Article article) {
        return articleRespository.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleRespository.getOne(id);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRespository.deleteById(id);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRespository.findAll();
    }

    @Override
    public Article editArticle(Article article) {
        return articleRespository.saveAndFlush(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleRespository.delete(article);
    }
    
}
