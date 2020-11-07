package p02;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * AAA (Triple-A)
 * Arrange (준비) - 시스템이 적절한 상태에 있는지 확인,
 *                객체 생성, 객체와의 소통, API 호출
 * Act (실행) - 실제로 테스트 코드를 실행
 * Assert (단언) - 실행한 코드의 결과를 기대하는 값과 비교
 *
 * + @
 * After (사후) - 자원을 할당한 경우에는 이를 해제
 */

public class AccountTest {

    private Account account;

    // Before -> Test1 -> Before -> Test2
    // BeforeClass -> Before -> Test1
    // -> (After) -> Before -> Test2 -> (After) -> (AfterClass)

    @BeforeClass
    public static void classSetUp() {
        // 맨 처음 한번 실행
    }

    @Before
    public void setUpBySetBalanceOneHundred() {
        account = new Account(100);
    }

    @Test
    public void answerIsMinusWithNegativeBalance() {
        account.withdraw(150); // 2. Act
        boolean actualResult = account.isMinus();
        // boolean에 대한 assertion은 assertTrue, assertFalse를 쓰면 좋다.
//        assertFalse(actualResult);
        assertThat(actualResult, is(equalTo(true))); // 3. Assert
        assertThat(actualResult, not(equalTo(false))); // is <-> not
        // 단, 실패했을 때 정보를 잘 표현하기 위해서는
        // hamcrest의 CoreMatchers에 구현된 matcher를 쓰는 것이 좋다.
    }

    @Test
    public void answerIsNotMinusWithPositiveBalance() {
        account.withdraw(50);
        boolean actualResult = account.isMinus();

        assertThat(actualResult, is(not(equalTo(true))));
    }

    @Test
    public void checkPositiveBalanceAfterWithdrawal() {
        account.withdraw(80);
        int actualResult = account.getBalance();

        assertThat(actualResult, is(equalTo(20)));
    }

    @Test
    @Ignore("This will be tested later.") // 이것을 남겨두고 commit하지 마세요
    public void checkNegativeBalanceAfterWithdrawal() {
        account.withdraw(120);
        int actualResult = account.getBalance();

        assertThat(actualResult, is(equalTo(-20)));
    }

    // ArithmeticException이 발생하는지 assert하는 테스트

    // 간단하다는 장점이 있지만, 테스트 메소드 내부에 assert가 드러나지 않는다.
    @Test(expected=ArithmeticException.class)
    public void checkExceptionByAnnotation() {
        account.throwExcept();
    }

    // 인지적으로 더 개선되나, 코드가 매우 복잡해진다.
    @Test
    public void checkExceptionByTryCatch() {
        try {
            account.throwExcept();
            fail();
        } catch (ArithmeticException e) {
            assertThat(e.getClass(),
                    equalTo(ArithmeticException.class));
        }
    }


    // Rule을 이용하면 메소드 코드에 expected exception이 드러나므로 인지적으로 개선
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkExceptionByRule() {
        thrown.expect(ArithmeticException.class);
        account.throwExcept();
    }
}