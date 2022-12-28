package voltz.api.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voltz.api.api.model.Tool;
import voltz.api.api.repository.ToolRepository;

import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Override
    public String save(Tool tool) {
        return toolRepository.save(tool).getId();
    }

    @Override
    public List<Tool> getAll() {
        return toolRepository.findAll();
    }

    @Override
    public void delete(String id) {
        toolRepository.deleteById(id);
    }


}
