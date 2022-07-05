public class Task {
  private String task = "";
  private int count = 0;

  public String getTask() {
    return task;
  }

  public void submit(String task) {
    this.task = task;
  }

  public int getCount() {
    return count;
  }

  public void counter() {
    this.count += 1;
  }
}
