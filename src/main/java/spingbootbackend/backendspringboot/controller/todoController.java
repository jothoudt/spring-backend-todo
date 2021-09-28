package spingbootbackend.backendspringboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spingbootbackend.backendspringboot.exception.ResourceNotFoundException;
import spingbootbackend.backendspringboot.model.todo;
import spingbootbackend.backendspringboot.repository.todoRepository;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api/")
public class todoController {

	@Autowired
	private todoRepository todoRepository;
	
	// get all taska
	@GetMapping("/tasks")
	public List<todo> gettasks(){
		return todoRepository.findAll();
	}		
	
	// create task rest api
	@PostMapping("/tasks")
	public todo createTask(@RequestBody todo task) {
		return todoRepository.save(task);
	}

	
	// update task rest api
	@PutMapping("/tasks/{id}")
    public ResponseEntity<todo> updateEmployee(@PathVariable Long id){
		todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String date_completed= formattedDate;
        Boolean completed = true;
		todo.setCompleted(completed);
		todo.setDate_completed(date_completed);
		
		todo updatedTodo = todoRepository.save(todo);
		return ResponseEntity.ok(updatedTodo);
	}
	
	// delete employee rest api
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id){
		todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		todoRepository.delete(todo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
