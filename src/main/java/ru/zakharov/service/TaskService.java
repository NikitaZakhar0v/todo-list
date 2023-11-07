package ru.zakharov.service;

import org.springframework.data.domain.Page;
import ru.zakharov.domain.Filter;
import ru.zakharov.domain.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    Task update(Task task);
    void delete(Long id);

    Page<Task> findPaginated(Filter filter);
}
