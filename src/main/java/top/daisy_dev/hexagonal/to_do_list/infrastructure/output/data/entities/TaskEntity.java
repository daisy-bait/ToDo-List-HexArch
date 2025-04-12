package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime startDate;

    private boolean completed;

    public static TaskEntity toEntity(Task taskModel) {
        return new TaskEntity(
                taskModel.getId(),
                taskModel.getTitle(),
                taskModel.getDescription(),
                taskModel.getCreatedAt(),
                taskModel.isCompleted()
        );
    }

    public Task toDomainModel() {
        return new Task(
                this.id,
                this.title,
                this.description,
                this.startDate,
                this.completed
        );
    }

}