package StorProject;

import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;
@Listeners({listeners.class})
public class VerifyElements extends StoreApp
{
    public void assertEqualsfun(String actual, String expected)
    {
        assertEquals(actual,expected);
    }

}
