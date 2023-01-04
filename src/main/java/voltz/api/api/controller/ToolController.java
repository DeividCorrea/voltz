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
@RequestMapping(value = "/tools", produces = "application/json")
public class ToolController {

    @Autowired
    private ToolService toolService;


    @GetMapping
    public ResponseEntity<List<Tool>> list () {
        return ResponseEntity.ok(toolService.getAll());
    }

    @PostMapping
    public ResponseEntity<Tool> save(@Valid @RequestBody ToolRequestDto toolRequestbody){
        //Tool tool = toolService.save(toolRequestbody)
        //return ResponseEntity.status(HttpStatus.CREATED).body(tool)
        
        //return new ResponseEntity<>(toolService.save(toolRequestbody), HttpStatus.CREATED);
        
        return ResponseEntity.created(toolService.save(toolRequestbody));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        toolService.delete(id);
        return ResponseEntity.status(HttpStatus.OK);
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
