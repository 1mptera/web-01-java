package models;

import org.junit.jupiter.api.Test;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("2022-07-13T03:04:16.972836", "빨래하기", "ADDED");
  }
}
