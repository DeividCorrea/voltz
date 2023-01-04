package voltz.api.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolRequestDto {

    private String title;
    private String link;
    @Length(max = 256, message = "Campo deve conter no maximo 256 carcateres")
    private String description;
    @Size(min = 0, max = 8, message = "Campo deve conter no maximo 8 tags")
    private List<String> tags;

}
