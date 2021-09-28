package spingbootbackend.backendspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spingbootbackend.backendspringboot.model.todo;

@Repository
public interface todoRepository extends JpaRepository<todo, Long>{

}
