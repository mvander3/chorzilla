package org.mvander3.chorzilla.domain.schedule;

public class ChoreSchedule {
    
    private Long id;
    private ChoreScheduleType choreScheduleType;
    private ChoreScheduleDetail choreScheduleDetail;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChoreScheduleType getChoreScheduleType() {
        return choreScheduleType;
    }

    public void setChoreScheduleType(ChoreScheduleType choreScheduleType) {
        this.choreScheduleType = choreScheduleType;
    }

    public ChoreScheduleDetail getChoreScheduleDetail() {
        return choreScheduleDetail;
    }

    public void setChoreScheduleDetail(ChoreScheduleDetail choreScheduleDetail) {
        this.choreScheduleDetail = choreScheduleDetail;
    }
   
    @Override
    public String toString() {
        return "ChoreSchedule [id=" + id + ", choreScheduleType=" + choreScheduleType + ", choreScheduleDetail="
               + choreScheduleDetail + "]";
    }
    
}
