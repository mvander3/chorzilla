package org.mvander3.chorzilla.domain;

import java.util.List;

public class ChoreList {

    private List<Chore> chores;

    public ChoreList(List<Chore> chores) {
        this.chores = chores;
    }

    public List<Chore> getChores() {
        return chores;
    }

    @Override
    public String toString() {
        return "ChoreList [chores=" + chores + "]";
    }
     
}
