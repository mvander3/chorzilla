package org.mvander3.chorzilla.domain.schedule;

import java.util.Date;

public class SingleOccurrenceScheduleDetail extends ChoreScheduleDetail {

    private Date dueDate;
    
    @Override
    public ChoreScheduleType getScheduleType() {
        return ChoreScheduleType.SINGLE_OCCURRENCE;
    }
    
    public Date getDueDate() {
        return this.dueDate;
    }
    
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "SingleOccurrenceScheduleDetail [dueDate=" + dueDate + "]";
    }

}
