package my.com.seleniumsample.test.test;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SampleTest extends BaseTest {
    @Test
    public void sample(){

        Assert.assertEquals(2, 1+1);
    }

}
