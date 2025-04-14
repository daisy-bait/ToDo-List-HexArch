package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JsonPlaceHolderUserDTO {

    private Long id;
    private String name;
    private String email;

}
