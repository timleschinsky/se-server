package com.ovgu.se.openapispringboot.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.sampleItemREST.base-path:}")
public class ItemApiController implements ItemApi {

    private final ItemApiDelegate delegate;

    public ItemApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ItemApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ItemApiDelegate() {});
    }

    @Override
    public ItemApiDelegate getDelegate() {
        return delegate;
    }

}
