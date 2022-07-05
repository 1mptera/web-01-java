import javax.swing.*;
import java.awt.*;

public class ToDoList {
  private JFrame frame;

  private JPanel panel;
  private JPanel menuPanel;
  private JPanel contentPanel;
  private JPanel titlePanel;

  private JTextField taskTextField;

  private Task task;

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  private void run() {
    task = new Task();

    frame = new JFrame("ToDoList");
    frame.setSize(300, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    frame.add(panel);

    initTitle();
    initMenu();
    initContentPanel();

    frame.setVisible(true);
  }

  private void initTitle() {
    titlePanel = new JPanel();
    titlePanel.add(new JLabel("할 일 목록"));
    titlePanel.setLayout(new GridLayout(3, 1));
    panel.add(titlePanel, BorderLayout.PAGE_START);
  }

  public void initMenu() {
    menuPanel = new JPanel();
    menuPanel.add(new JLabel("할 일: "));
    taskTextField = new JTextField(10);
    menuPanel.add(taskTextField);
    menuPanel.add(createToDoListButton());
    panel.add(menuPanel);
  }

  private JButton createToDoListButton() {
    JButton button = new JButton("추가");
    button.addActionListener(event -> {
      task.counter();
      task.submit(taskTextField.getText());
      JPanel toDoListPanel = new ToDoListPanel(task);
      showContentPanel(toDoListPanel);
    });
    return button;
  }

  private void showContentPanel(JPanel panel) {
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setLayout(new GridLayout(task.getCount(), 1));

    panel.add(contentPanel);
  }
}
