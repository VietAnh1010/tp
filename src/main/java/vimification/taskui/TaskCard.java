package vimification.taskui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import vimification.model.task.Task;

/**
 * An UI component that displays information of a {@code Task}.
 */
public class TaskCard extends UiPart<HBox> {

    private static final String FXML = "TaskCard.fxml";

    @FXML
    private HBox cardPane;
    @FXML
    private Label description;
    @FXML
    private Label id;
    // @FXML
    // private FlowPane tags;

    /**
     * Creates a {@code TaskCode} with the given {@code Task} and index to display.
     */
    public TaskCard(Task task, int displayedIndex) {
        super(FXML);
        // this.task = task;
        id.setText(displayedIndex + ". ");
        description.setText(task.getDescription());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TaskCard)) {
            return false;
        }

        // state check
        // TODO: FIX CLASH WITH JIAYUE
        // TaskCard card = (TaskCard) other;
        // return id.getText().equals(card.id.getText())
        // && task.equals(card.task);

        // TODO: REMOVE THIS AFTER FIX ABOVE
        return false;
    }
}
