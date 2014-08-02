package org.mvander3.chorzilla.domain.history;

import java.util.Date;

public class CompletionRecord {
    
    private Long id;
    private Long choreId;
    private Date dueDateAtCompletionTime;
    private Date completionDate;
    private Date modifiedDate;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChoreId() {
        return choreId;
    }

    public void setChoreId(Long choreId) {
        this.choreId = choreId;
    }

    public Date getDueDateAtCompletionTime() {
        return dueDateAtCompletionTime;
    }

    public void setDueDateAtCompletionTime(Date dueDateAtCompletionTime) {
        this.dueDateAtCompletionTime = dueDateAtCompletionTime;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "CompletionRecord [id=" + id + ", choreId=" + choreId + ", dueDateAtCompletionTime="
               + dueDateAtCompletionTime + ", completionDate=" + completionDate + ", modifiedDate=" + modifiedDate
               + "]";
    }

}
