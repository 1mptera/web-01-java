import org.junit.jupiter.api.Test;
import utils.ExpressionValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpgradeCalculatorTest {
  @Test
  void inputRightExpression() {
    UpgradeCalculator upgradedCalculator = new UpgradeCalculator();

    assertEquals("Result: 4", upgradedCalculator.compute("1 + 3"));
    assertEquals("Result: 6", upgradedCalculator.compute("3 * 2"));
    assertEquals("Result: 2", upgradedCalculator.compute("4 / 2"));
    assertEquals("Result: 3", upgradedCalculator.compute("5 - 2"));
  }

  @Test
  void inputSingleNumberExpression() {
    UpgradeCalculator upgradedCalculator = new UpgradeCalculator();

    assertEquals("Result: 1", upgradedCalculator.compute("1"));
    assertEquals("Result: 123", upgradedCalculator.compute("123"));
    assertEquals("Result: 41", upgradedCalculator.compute("41"));
  }

  @Test
  void inputWrongExpression() {
    UpgradeCalculator upgradedCalculator = new UpgradeCalculator();

    upgradedCalculator.showResultWithInvalidExpression("*");
    upgradedCalculator.showResultWithInvalidExpression("1 +");
    upgradedCalculator.showResultWithInvalidExpression("1 1 1");
    upgradedCalculator.showResultWithInvalidExpression("123&");
  }
}