package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.entities.TaskEntity;

@Repository
public interface JpaTaskRepository extends JpaRepository<Long, TaskEntity> { }