import org.testng.annotations.*;

public class TestNG_Annotation_8_Beforeaftergroup {

    @BeforeGroups("login")
    public void beforeLoginGroup() {
        System.out.println("Setting up resources before the 'login' group tests");
    }

    @AfterGroups("login")
    public void afterLoginGroup() {
        System.out.println("Cleaning up resources after the 'login' group tests");
    }

    @Test(groups = "login")
    public void testLoginValidUser() {
        System.out.println("Executing login test with valid user");
    }

    @Test(groups = "login")
    public void testLoginInvalidUser() {
        System.out.println("Executing login test with invalid user");
    }

    @Test(groups = "search")
    public void testSearchFeature() {
        System.out.println("Executing search feature test");
    }
}
