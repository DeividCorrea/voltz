package voltz.api.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voltz.api.api.model.Tool;
import voltz.api.api.repository.ToolRepository;
import voltz.api.api.service.ToolService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;


    @GetMapping
    public List<Tool> list () {
        return toolService.getAll();
    }

    @PostMapping
    public String save(@Valid @RequestBody Tool tool){

        return toolService.save(tool);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
       toolService.delete(id);
    }

}
