package org.mvander3.chorzilla.domain.history;

import java.util.Collection;

public class ChoreHistory {
    
    private Collection<CompletionRecord> completionRecords;

    public Collection<CompletionRecord> getCompletionRecords() {
        return completionRecords;
    }

    public void setCompletionRecords(Collection<CompletionRecord> completionRecords) {
        this.completionRecords = completionRecords;
    }

    @Override
    public String toString() {
        return "ChoreHistory [lastCompletionRecord=" + (completionRecords.isEmpty() ? "NONE" : completionRecords.iterator().next()) + ", numCompletionRecords=" + completionRecords.size() +"]";
    }
    
}
