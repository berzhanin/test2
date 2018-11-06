package tests.task16;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Massive2Test {
    private Massive2 user;
    private Massive2 user1;
    private Massive2 user2;

    @BeforeMethod
    public void setUp2() throws Exception {
        user = new Massive2("Eugen", 35, "MALE");
        user1 = new Massive2("Marine", 34, "FEMALE");
        user2 = new Massive2("Mary", 7, "FEMALE");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("This will execute after every Method");
    }

    @BeforeGroups
    public void beforeGroups() throws Exception {
        System.out.println("BeforeGroups");
    }

    @AfterGroups
    public void afterGroups() throws Exception {
        System.out.println("@AfterGroups");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Testing Class Massive.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This will execute before the Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This will execute after the Test");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("This will execute after the Class");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute before the Test Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This will execute after Test Suite");
    }

    @Test
    public void getAllUsers() {
        List<Massive2> expected = Massive2.getAllUsers();

        List<Massive2> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<Massive2> expected = Massive2.getAllUsers();
        assertNotNull(expected);
    }

    @Test
    public void getAllUsers_MALE() {
        List<Massive2> expected = Massive2.getAllUsers("MALE");

        List<Massive2> actual = new ArrayList<>();
        actual.add(user);

        assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_MALE_NO_NULL() {
        //проверка на null
        List<Massive2> expected = Massive2.getAllUsers("MALE");
        assertNotNull(expected);
    }

    @Test
    public void getAllUsers_FEMALE() {
        List<Massive2> expected = Massive2.getAllUsers("FEMALE");

        List<Massive2> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);

        assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_FEMALE_NO_NULL() {
        //проверка на null
        List<Massive2> expected = Massive2.getAllUsers("FEMALE");
        assertNotNull(expected);
    }

    @Test
    public void getHowManyUsers() {
        int expected = Massive2.getHowManyUsers();
        int actual = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_MALE() {
        int expected = Massive2.getHowManyUsers("MALE");
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_FEMALE() {
        int expected = Massive2.getHowManyUsers("FEMALE");
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        int expected = Massive2.getAllAgeUsers();
        int actual = 35 + 34 + 7;
        assertEquals(expected, actual);
    }

    @Test(timeOut = 6000)
    public void getAllAgeUsers_MALE() {
        int expected = Massive2.getAllAgeUsers("MALE");
        int actual = 35;
        assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_FEMALE() {
        int expected = Massive2.getAllAgeUsers("FEMALE");
        int actual = 34 + 7;
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void exceptionTest() {
        user.myException();
    }

    @Test
    public void Test() {
        System.out.println("Этот тест будет проигнорирован! ");
    }
    @Test
    public void testEquals() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testToString() {
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerException() {
        List list = null;
        int size = list.size();
    }

    @Test(enabled = false)
    public void testsetProperty() {
        System.out.println("Этот метод будет проигнорирован в момент проведения тестирования!");
    }
}