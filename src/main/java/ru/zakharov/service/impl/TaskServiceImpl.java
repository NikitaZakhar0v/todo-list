package ru.zakharov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.zakharov.domain.Filter;
import ru.zakharov.domain.Task;
import ru.zakharov.repository.TaskRepository;
import ru.zakharov.service.TaskService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;


    @Override
    public Task create(Task task) {
        return repository.save(task);
    }

    @Override
    public Task update(Task task) {
        Optional<Task> taskOptional = repository.findById(task.getId());
        Task taskFromDb = taskOptional.orElseThrow(() -> new IllegalArgumentException("Задача c id=" + task.getId() + " не найдена"));
        taskFromDb.setDescription(task.getDescription());
        taskFromDb.setStatus(task.getStatus());
        return repository.save(taskFromDb);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Task> findPaginated(Filter filter) {
        Sort sort = filter.sortDirection().equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(filter.sortField().toLowerCase()).ascending() : Sort.by(filter.sortField().toLowerCase()).descending();

        Pageable pageable = PageRequest.of(filter.pageNo() - 1, filter.pageSize(), sort);
        Page<Task> page = repository.findAll(pageable);

        if(filter.pageNo() > page.getTotalPages() && page.getTotalPages() != 0){
            filter = new Filter(filter.pageNo() - 1, filter.pageSize(), filter.sortField(), filter.sortDirection());
            pageable = PageRequest.of(filter.pageNo() - 1, filter.pageSize(), sort);
            page = repository.findAll(pageable);
        }
        return page;
    }
}
