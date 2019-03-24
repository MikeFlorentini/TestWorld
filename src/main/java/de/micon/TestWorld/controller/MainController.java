/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.micon.TestWorld.controller;

import de.micon.TestWorld.model.Article;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mike
 */
@Controller
public class MainController {

    @Autowired
    public MainController() {
    }

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String getMain() {
        return "index";
    }

}
