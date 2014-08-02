package org.mvander3.chorzilla.domain.schedule;

public class RegularlyRepeatedScheduleDetail extends ChoreScheduleDetail {

    private Long id;
    private Frequency frequency; 
    private Long value;

    public enum Frequency {
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    @Override
    public ChoreScheduleType getScheduleType() {
        return ChoreScheduleType.REGULARLY_REPEATED;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RegularlyRepeatedScheduleDetail [id=" + id + ", frequency=" + frequency + ", value=" + value + "]";
    }

}
