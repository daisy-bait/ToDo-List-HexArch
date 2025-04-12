package top.daisy_dev.hexagonal.to_do_list.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;

}
