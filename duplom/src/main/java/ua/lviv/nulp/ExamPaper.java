package ua.lviv.nulp;

import java.util.*;
import java.util.List;

public class ExamPaper {
List<Task> tasks = new ArrayList<Task>();

    public ExamPaper() {
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "tasks=" + tasks +
                '}';
    }
}
