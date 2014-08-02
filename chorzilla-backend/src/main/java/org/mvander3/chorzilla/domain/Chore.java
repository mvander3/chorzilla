package org.mvander3.chorzilla.domain;

import java.util.Date;

import org.mvander3.chorzilla.domain.history.ChoreHistory;
import org.mvander3.chorzilla.domain.schedule.ChoreSchedule;
import org.springframework.data.annotation.Transient;

public class Chore {
    
    private Long id;
    private String name;
    private String description;
    private ChoreSchedule schedule;
    private ChoreHistory history;
    private Date lastCompletedDate;
    private Date createdDate;
    
    private ChoreStatus status; 
    
    @Transient
    public ChoreStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(ChoreStatus status) {
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public ChoreSchedule getSchedule() {
        return schedule;
    }
    
    public void setSchedule(ChoreSchedule schedule) {
        this.schedule = schedule;
    }
    
    public ChoreHistory getHistory() {
        return history;
    }
    
    public void setHistory(ChoreHistory history) {
        this.history = history;
    }
    
    public Date getLastCompletedDate() {
        return lastCompletedDate;
    }
    
    public void setLastCompletedDate(Date lastCompletedDate) {
        this.lastCompletedDate = lastCompletedDate;
    }

    @Override
    public String toString() {
        return "Chore [id=" + id + ", name=" + name + ", description=" + description + ", schedule=" + schedule 
            + ", history=" + history + ", lastCompletedDate=" + lastCompletedDate + ", createdDate=" + createdDate + "]";
    }
    
}
