package com.jingqingyun.reading.app.service;

import cqrs.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jingqingyun.common.utils.ModelUtils;
import com.jingqingyun.reading.app.model.CreateBookDto;
import com.jingqingyun.reading.app.model.command.CreateBookCommand;

/**
 * BookCommandService
 *
 * @author jingqingyun
 * @date 2020/10/9
 */
@Service
public class BookCommandService {

    @Autowired
    private CommandGateway commandGateway;

    public long create(CreateBookDto req) {
        CreateBookCommand cmd = ModelUtils.convert(req, CreateBookCommand.class);
        return commandGateway.dispatch(cmd);
    }

}
