package voltz.api.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import voltz.api.api.model.Tool;
import voltz.api.api.model.ToolDto;

import java.util.List;

@Repository
public interface ToolRepository extends MongoRepository<Tool, String> {

}
