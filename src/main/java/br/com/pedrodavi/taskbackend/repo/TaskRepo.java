package br.com.pedrodavi.taskbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrodavi.taskbackend.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
