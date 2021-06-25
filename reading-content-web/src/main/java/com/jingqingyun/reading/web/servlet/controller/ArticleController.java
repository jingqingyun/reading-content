package com.jingqingyun.reading.web.servlet.controller;

import com.jingqingyun.common.model.Response;
import com.jingqingyun.reading.app.model.ArticleDTO;
import com.jingqingyun.reading.app.service.ArticleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ArticleController
 *
 * @author jingqingyun
 * @date 2020-09-07
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleQueryService articleService;

    @GetMapping("/{id}")
    public Response<ArticleDTO> getArticle(@PathVariable long id) {
        return Response.ok(articleService.getArticle(id).orElse(null));
    }

}
