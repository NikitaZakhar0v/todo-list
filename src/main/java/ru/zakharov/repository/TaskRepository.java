package ru.zakharov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharov.domain.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
