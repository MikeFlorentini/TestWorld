/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.micon.TestWorld.service;

import de.micon.TestWorld.entity.Article;
import java.util.List;

/**
 *
 * @author mike
 */
public interface ArticleService {
    Article createArticle(Article article);
    Article getArticle(Long id);
    Article editArticle(Article article);
    void deleteArticle(Article article);
    void deleteArticle(Long id);
    List<Article> getAllArticle();
}
