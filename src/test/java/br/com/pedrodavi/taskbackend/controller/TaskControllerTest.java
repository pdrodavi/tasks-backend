package br.com.pedrodavi.taskbackend.controller;

import br.com.pedrodavi.taskbackend.model.Task;
import br.com.pedrodavi.taskbackend.repo.TaskRepo;
import br.com.pedrodavi.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void naoDeveSalvarSemDescricao() {
        Task task = new Task();
        task.setDueDate(LocalDate.now());
        try {
            controller.save(task);
            Assert.fail("Não deveria chegar aqui!");
        } catch (ValidationException e) {
            assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarVazio() {
        Task task = new Task();
        task.setTask("Name");
        try {
            controller.save(task);
            Assert.fail("Não deveria chegar aqui!");
        } catch (ValidationException e) {
            assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarComDataPassada() {
        Task task = new Task();
        task.setDueDate(LocalDate.of(2010,10, 10));
        task.setTask("Name");
        try {
            controller.save(task);
            Assert.fail("Não deveria chegar aqui!");
        } catch (ValidationException e) {
            assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void salvarComSucesso() throws ValidationException {
        Task task = new Task();
        task.setDueDate(LocalDate.of(2030,10, 10));
        task.setTask("Name");
        controller.save(task);
        Mockito.verify(taskRepo).save(task);
    }

}
