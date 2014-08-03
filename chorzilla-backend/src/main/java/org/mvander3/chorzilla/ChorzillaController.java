package org.mvander3.chorzilla;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.joda.time.DateTime;
import org.mvander3.chorzilla.domain.Chore;
import org.mvander3.chorzilla.domain.ChoreStatus;
import org.mvander3.chorzilla.domain.history.ChoreHistory;
import org.mvander3.chorzilla.domain.history.CompletionRecord;
import org.mvander3.chorzilla.domain.schedule.ChoreSchedule;
import org.mvander3.chorzilla.domain.schedule.ChoreScheduleType;
import org.mvander3.chorzilla.domain.schedule.RegularlyRepeatedScheduleDetail;
import org.mvander3.chorzilla.domain.schedule.RegularlyRepeatedScheduleDetail.Frequency;
import org.mvander3.chorzilla.domain.schedule.SingleOccurrenceScheduleDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

@RestController
public class ChorzillaController {
    
    private Logger log = LoggerFactory.getLogger(getClass());

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/chores")
    public List<Chore> getChores(@RequestParam(value="name", required=false, defaultValue="anyone") String name) {
//        try {
            List<Chore> choreList = Lists.newArrayList(makeMopKitchenChore(), makeStainMailboxChore());
            log.info("Returning choreList for " + name + ": " + choreList);
            if(name.equals("anyone")) {
                throw new RuntimeException("Please pass a name.");
            } 
            return choreList;
//        } catch(Exception e) {
//            log.error("Error grabbing chore list: ",e);
//        }
    }
    
    private Chore makeMopKitchenChore() {
        Chore chore = new Chore();
        long choreId = counter.incrementAndGet();
        chore.setId(choreId);
        chore.setName("Mop Kitchen Floor");
        chore.setDescription("Use a mop, water, and soap to clean the floor of the kitchen");
        chore.setSchedule(getBiweeklySchedule());
        Date lastCompletedDate = new DateTime().minusDays(15).toDate();
        chore.setLastCompletedDate(lastCompletedDate);
        chore.setHistory(makeChoreHistory(choreId, lastCompletedDate,new DateTime().minusDays(25).toDate()));
        chore.setStatus(ChoreStatus.PAST_DUE);
        return chore;
    }
    
    private Chore makeStainMailboxChore() {
        Chore chore = new Chore();
        chore.setId(counter.incrementAndGet());
        chore.setName("Stain Mailbox");
        chore.setDescription("Use a brush and brown stainer to make the mailbox look presentable and protected from the elements");
        chore.setSchedule(getOneOffSchedule(new DateTime().plusDays(5).toDate()));
        chore.setStatus(ChoreStatus.PENDING);
        return chore;
    }
    
    private ChoreSchedule getOneOffSchedule(Date dueDate) {
        SingleOccurrenceScheduleDetail scheduleDetail = new SingleOccurrenceScheduleDetail();
        scheduleDetail.setDueDate(dueDate);
        
        ChoreSchedule schedule = new ChoreSchedule();
        schedule.setChoreScheduleType(ChoreScheduleType.SINGLE_OCCURRENCE);
        schedule.setChoreScheduleDetail(scheduleDetail);
        return schedule;
    }
    
    private ChoreSchedule getBiweeklySchedule() {
        RegularlyRepeatedScheduleDetail scheduleDetail = new RegularlyRepeatedScheduleDetail();
        scheduleDetail.setFrequency(Frequency.WEEK);
        scheduleDetail.setValue(2L);
        
        ChoreSchedule schedule = new ChoreSchedule();
        schedule.setChoreScheduleType(ChoreScheduleType.REGULARLY_REPEATED);
        schedule.setChoreScheduleDetail(scheduleDetail);
        return schedule;
    }
    
    private ChoreHistory makeChoreHistory(Long choreId, Date... completionDates) {
        Collection<CompletionRecord> completionRecords = Lists.newArrayList();
        for(Date completionDate : completionDates) {
            CompletionRecord completionRecord = new CompletionRecord();
            completionRecord.setChoreId(choreId);
            completionRecord.setCompletionDate(completionDate);
            completionRecord.setModifiedDate(completionDate);
            completionRecord.setDueDateAtCompletionTime(new DateTime(completionDate).minusDays(1).toDate());
            completionRecords.add(completionRecord);
        }
        
        ChoreHistory choreHistory = new ChoreHistory();
        choreHistory.setCompletionRecords(completionRecords);
        return choreHistory;
    }
}
