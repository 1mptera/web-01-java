import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

  private List<String> tasks = new ArrayList<>();

  public void add(String toDo) {
    tasks.add(toDo);
  }

  public List<String> getTasks() {
    return tasks;
  }

  public void deleteTask(String toDo) {
    tasks.remove(toDo);
  }
}
