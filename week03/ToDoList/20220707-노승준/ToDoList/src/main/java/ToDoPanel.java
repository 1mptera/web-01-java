import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDoPanel extends JPanel {
  private TaskRepository task;
  private ToDoList toDoList;

  ToDoPanel(TaskRepository task, ToDoList toDoList) {
    this.task = task;
    this.toDoList = toDoList;

    this.setLayout(new GridLayout(0, 1));

    showTaskListPanel();
  }

  private void createTaskPanels() {
    for (String toDo : task.getTasks()) {
      JPanel toDoPanel = new JPanel();

      JCheckBox checkBox = new JCheckBox();
      toDoPanel.add(checkBox);

      JLabel taskLabel = new JLabel(toDo);
      taskLabel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          if (checkBox.isSelected()) {
            checkBox.setSelected(false);
            return;
          }
          checkBox.setSelected(true);
        }
      });
      toDoPanel.add(taskLabel);

      JButton button = new JButton("X");
      button.addActionListener(event -> {
        task.deleteTask(toDo);
        showTaskListPanel();
        toDoList.showContentPanel(this);
      });
      toDoPanel.add(button);

      this.add(toDoPanel);
    }
  }

  private void showTaskListPanel() {
    this.removeAll();
    this.createTaskPanels();
    this.setVisible(false);
    this.setVisible(true);
  }
}
