import models.Transaction;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void loadTransaction() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();

    List<Transaction> transactions = makaoBank.loadTransaction();

    assertNotNull(transactions);

    Transaction transaction = transactions.get(0);
    Transaction transaction2 = transactions.get(1);

    assertEquals(new Transaction("μμ‘", 1000) , transaction);
    assertEquals(new Transaction("μκΈ", 2000) , transaction2);
    assertEquals(5 , transactions.size());
  }
}