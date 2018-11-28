package tests.task15;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class MassiveTest {
    private Massive user;
    private Massive user1;
    private Massive user2;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Testing Class Massive.");
    }

    @Before
    public void setUp() throws Exception {
        user = new Massive("Eugen", 35, "MALE");
        user1 = new Massive("Marine", 34, "FEMALE");
        user2 = new Massive("Mary", 7, "FEMALE");
    }

    @Test
    public void getAllUsers() {
        List<Massive> expected = Massive.getAllUsers();

        List<Massive> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<Massive> expected = Massive.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_MALE() {
        List<Massive> expected = Massive.getAllUsers("MALE");

        List<Massive> actual = new ArrayList<>();
        actual.add(user);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_MALE_NO_NULL() {
        //проверка на null
        List<Massive> expected = Massive.getAllUsers("MALE");
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_FEMALE() {
        List<Massive> expected = Massive.getAllUsers("FEMALE");

        List<Massive> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_FEMALE_NO_NULL() {
        //проверка на null
        List<Massive> expected = Massive.getAllUsers("FEMALE");
        Assert.assertNotNull(expected);
    }

    @Test
    public void getHowManyUsers() {
        int expected = Massive.getHowManyUsers();

        int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_MALE() {
        int expected = Massive.getHowManyUsers("MALE");

        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_FEMALE() {
        int expected = Massive.getHowManyUsers("FEMALE");

        int actual = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        int expected = Massive.getAllAgeUsers();

        int actual = 35 + 34 + 7;

        Assert.assertEquals(expected, actual);
    }

    @Test (timeout = 6000)
    public void getAllAgeUsers_MALE() {
        int expected = Massive.getAllAgeUsers("MALE");

        int actual = 35;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_FEMALE() {
        int expected = Massive.getAllAgeUsers("FEMALE");

        int actual = 34 + 7;

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void exceptionTest() {
        user.myException();
    }

    @Test
    @Ignore
    public void Test() {
        System.out.println("Этот тест будет проигнорирован! ");
    }

    @After
    public void after() {
        user = null;
        user1 = null;
        user2 = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Testing Class Massive the end.");
    }
}