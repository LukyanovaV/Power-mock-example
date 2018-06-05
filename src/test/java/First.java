import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Second.class)
public class First {



    @Test
    public void testSecondClass(){

        Second i = mock(Second.class);
        when(i.method()).thenReturn("Hello Word");
        String result = i.method();

        assertEquals(result, "Hello Word");


    }

    @Test
    public void testPrivateMethod() throws Exception {

        String name = "James";

        Second second = new Second();

        Second i = PowerMockito.spy(second);

        PowerMockito.doReturn(name).when(i, "privatMethod");

        String value = i.callPrivateMethod();

        Assert.assertEquals(value, "Hello James");
        PowerMockito.verifyPrivate(i, Mockito.times(1)).invoke("privatMethod");





    }

    @Test
    public void testWhitebox() throws Exception {
        Second second = new Second();

        String actual = Whitebox.invokeMethod(second, "privatMethod");

        assertEquals(actual, "person");
    }
}
