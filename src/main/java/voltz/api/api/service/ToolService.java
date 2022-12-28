package voltz.api.api.service;

import voltz.api.api.model.Tool;

import java.util.List;

public interface ToolService {


    String save(Tool tool);

    List<Tool> getAll();

    void delete(String id);

}
