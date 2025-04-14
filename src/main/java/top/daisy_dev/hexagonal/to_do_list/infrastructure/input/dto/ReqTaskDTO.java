package top.daisy_dev.hexagonal.to_do_list.infrastructure.input.dto;

import java.time.LocalDateTime;

public class ReqTaskDTO {

    private Long taskId;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private boolean completed;

}
