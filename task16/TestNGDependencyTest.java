package tests.task16;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestNGDependencyTest {
    @Test
    public void initEnvironmentTest() {
        System.out.println("This is initEnvironmentTest");
    }

    @Test(dependsOnMethods={"initEnvironmentTest"})
    public void testmethod() {
        System.out.println("This is testmethod");
    }

    @Test(groups = { "init" })
    public void initEnvironmentTest1() {
        System.out.println("This is initEnvironmentTest1");
    }

    @Test(groups = { "init" })
    public void initEnvironmentTest2() {
        System.out.println("This is initEnvironmentTest2");
    }

    @Test(dependsOnGroups={"init"})
    public void testmethods() {
        System.out.println("This is testmethod");
    }
}