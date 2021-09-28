package spingbootbackend.backendspringboot.model;

import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class todo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="task")
    private String task;

    @Column(name="completed")
    private Boolean completed;

    @CreationTimestamp
    @Column(name="date_added")
    private Timestamp date_added;

    @Column(name="date_completed")
    private String date_completed;

    public todo(){

    }
    public todo(long id, String task, Boolean completed, Timestamp date_added, String date_completed ){
        super();
        this.id = id;
        this.task = task;
        this.completed = completed;
        this.date_added = date_added;
        this.date_completed = date_completed;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id= id;
    }
    public String getTask(){
        return task;
    }
    public void setTask(String task){
        this.task = task;
    }
    public Boolean getCompleted(){
        return completed;
    }
    public Boolean setCompleted(Boolean completed){
        return true;
    }
    public Timestamp getDate_added(){
        return date_added;
    }
    public Timestamp setDate_added(){
        return date_added;
    }
    public String getDate_completed(String date_completed){
        return date_completed;
    }
    public void setDate_completed(String date_completed){
        this.date_completed = date_completed;
    }
}
