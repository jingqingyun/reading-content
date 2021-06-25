package com.jingqingyun.reading.app.service;

import com.jingqingyun.common.utils.ModelUtils;
import com.jingqingyun.reading.app.model.CreateBookDTO;
import com.jingqingyun.reading.app.model.command.CreateBookCommand;
import cqrs.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public long create(CreateBookDTO req) {
        CreateBookCommand cmd = ModelUtils.convert(req, CreateBookCommand.class);
        return commandGateway.dispatch(cmd);
    }

}
