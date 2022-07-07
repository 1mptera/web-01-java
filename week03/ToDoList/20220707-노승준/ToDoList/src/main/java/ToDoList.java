import javax.swing.*;
import java.awt.*;

public class ToDoList {
  private JFrame frame;
  private JPanel panel;
  private JPanel menuPanel;
  private JPanel contentPanel;
  private JPanel titlePanel;
  private JTextField taskTextField;

  private TaskRepository taskRepository;
  private ToDoPanel toDoPanel;

  public ToDoList() {
    taskRepository = new TaskRepository();
  }

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public void run() {
    initFrame();

    initTitle();
    initMenu();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("ToDoList");
    frame.setSize(300, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    frame.add(panel);
  }

  public void initTitle() {
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

    menuPanel.add(createToDoListButton(taskRepository));

    panel.add(menuPanel);
  }

  public JButton createToDoListButton(TaskRepository taskRepository) {
    JButton button = new JButton("추가");
    button.addActionListener(event -> {
      String toDo = taskTextField.getText();
      taskRepository.add(toDo);

      toDoPanel = new ToDoPanel(taskRepository, this);
      showContentPanel(toDoPanel);
    });
    return button;
  }

  public void showContentPanel(JPanel toDoListPanel) {
    contentPanel.removeAll();
    contentPanel.add(toDoListPanel);

    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();

    panel.add(contentPanel);
  }
}
