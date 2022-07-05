import javax.swing.*;
import java.awt.*;

public class ToDoListPanel extends JPanel {
  //  private final JPanel taskListPanel;
  private final JCheckBox checkBox;
  private final JLabel taskLabel;

  private Task task;

  ToDoListPanel(Task task) {
    this.task = task;

//    taskListPanel = new JPanel();

//    this.add(taskListPanel);

    checkBox = new JCheckBox();
    this.add(checkBox);

    taskLabel = new JLabel(task.getTask());
    this.add(taskLabel);

    JButton button = new JButton("X");
    button.addActionListener(event -> {
      showTaskListPanel(button);
    });
    this.add(button);

  }

  private void showTaskListPanel(JButton button) {
    this.remove(checkBox);
    this.remove(taskLabel);
    this.remove(button);
    this.setVisible(false);
    this.setVisible(true);
  }
}
