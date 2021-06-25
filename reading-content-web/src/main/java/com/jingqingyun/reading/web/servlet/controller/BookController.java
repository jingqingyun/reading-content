package com.jingqingyun.reading.web.servlet.controller;

import com.jingqingyun.common.model.Response;
import com.jingqingyun.reading.app.model.CreateBookDTO;
import com.jingqingyun.reading.app.service.BookCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 *
 * @author jingqingyun
 * @date 2020-09-06
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookCommandService bookCommandService;

    @PostMapping("/create")
    public Response<Long> create(@Validated @RequestBody CreateBookDTO req) {
        return Response.ok(bookCommandService.create(req));
    }

}
