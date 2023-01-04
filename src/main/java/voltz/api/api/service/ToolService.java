package voltz.api.api.service;

import voltz.api.api.model.Tool;

import java.util.List;

public interface ToolService {


    void save(ToolRequestDto  toolRequest);

    List<Tool> getAll();

    void delete(String id);

}
