package com.jingqingyun.reading.web.servlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jingqingyun.common.model.Response;
import com.jingqingyun.reading.app.model.CreateBookDto;
import com.jingqingyun.reading.app.service.BookCommandService;

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
    public Response<Long> create(@RequestBody CreateBookDto req) {
        return Response.ok(bookCommandService.create(req));
    }

}
