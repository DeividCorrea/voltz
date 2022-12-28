package voltz.api.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import voltz.api.api.model.Tool;
import voltz.api.api.model.ToolDto;
import voltz.api.api.repository.ToolRepository;
import voltz.api.api.service.ToolService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@Valid @RequestBody ToolDto tool){

        return toolService.save(new Tool(tool));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
       toolService.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
