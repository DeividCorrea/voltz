package voltz.api.api.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@Document(collection  = "tools")
public class Tool {

    @Id
    private String id;

    private String title;
    private String link;
    private String description;

    @Size(min = 0, max = 8)
    private List<String> tags;

}
