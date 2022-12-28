package voltz.api.api.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection  = "tools")
public class Tool {

    @Id
    private String id;
    private String title;
    private String link;
    private String description;
    private List<String> tags;

    public Tool(ToolDto tool) {
        this.title = tool.getTitle();
        this.link = tool.getLink();
        this.description = tool.getDescription();
        this.tags = tool.getTags();
    }
}
