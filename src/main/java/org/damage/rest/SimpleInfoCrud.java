package org.damage.rest;

import org.damage.info.Info;
import org.damage.info.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class SimpleInfoCrud {

    private final InfoService infoService;

    @Autowired
    public SimpleInfoCrud(final InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/{id}")
    public Info getInfoById(@PathVariable final String id) {
        return infoService.findInfoById(id);
    }

    @PostMapping
    public Info addInfo(@RequestBody final Info info) {
        infoService.addNewInfo(info);
        return info;
    }
}
