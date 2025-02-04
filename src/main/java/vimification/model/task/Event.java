package vimification.model.task;

import java.time.LocalDateTime;
import static vimification.commons.util.CollectionUtil.requireAllNonNull;

public class Event extends Task {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Event(String description, boolean isDone,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime) {
        super(description, isDone);
        requireAllNonNull(startDateTime, endDateTime);
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Event(String description, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this(description, false, startDateTime, endDateTime);
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public Event clone() {
        return new Event(getDescription(), isDone(), startDateTime, endDateTime);
    }

    @Override
    public boolean isSameTask(Task task) {
        if (task == this) {
            return true;
        }
        if (!(task instanceof Event)) {
            return false;
        }
        Event otherEvent = (Event) task;
        return super.isSameTask(otherEvent)
                && otherEvent.startDateTime.equals(startDateTime)
                && otherEvent.endDateTime.equals(endDateTime);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event otherEvent = (Event) other;
        return super.equals(otherEvent)
                && otherEvent.startDateTime.equals(startDateTime)
                && otherEvent.endDateTime.equals(endDateTime);
    }

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Event ")
                .append(super.toString())
                .append("; from: ")
                .append(startDateTime)
                .append(" to: ")
                .append(endDateTime);
        return builder.toString();
    }
}
