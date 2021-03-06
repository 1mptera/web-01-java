import models.Transaction;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void loadTransaction() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();

    List<Transaction> transactions = makaoBank.loadTransaction();

    assertEquals(5, transactions.size());

    assertNotNull(transactions);

    Transaction transaction1 = transactions.get(0);
    Transaction transaction2 = transactions.get(1);
    Transaction transaction3 = transactions.get(2);

    assertEquals(new Transaction("잔액", 1000), transaction1);
    assertEquals(new Transaction("입금", 2000), transaction2);
    assertEquals(new Transaction("출금", 830), transaction3);
  }
}
