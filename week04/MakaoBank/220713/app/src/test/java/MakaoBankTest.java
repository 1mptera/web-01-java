import models.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MakaoBankTest {
  @Test
  void notNull() throws FileNotFoundException {
    MakaoBank makaoBank = new MakaoBank();

    List<Transaction> transactions = makaoBank.loadTransactions();

    assertNotNull(transactions);

    Transaction transaction1 = transactions.get(0);
    Transaction transaction2 = transactions.get(1);


    assertEquals(new Transaction("μμ‘",1000),transaction1);
    assertEquals(new Transaction("μκΈ",500),transaction2);

  }

}