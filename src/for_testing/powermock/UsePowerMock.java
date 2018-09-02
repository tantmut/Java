package powermock;

import for_testing.mockito.ImitationDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by nazar123 on 10.12.2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ImitationDB.class)
public class UsePowerMock {
    @Mock
    ImitationDB imitationDB;

    @Test
    public void shouldMockFinalMethod() {
        Mockito.when(imitationDB.print()).thenReturn(10);

        Assert.assertEquals(imitationDB.print(), 10);
    }

    @Test
    public void shouldMockStaticMethod() {
        PowerMockito.mockStatic(ImitationDB.class);

        Mockito.when(ImitationDB.printStatic()).thenReturn(10);

        Assert.assertEquals(ImitationDB.printStatic(), 10);
    }

    @Test
    public void shouldMockPrivateMethod() throws Exception {

        ImitationDB imitationDB = new ImitationDB();

        ImitationDB spy = PowerMockito.spy(imitationDB);

        PowerMockito.doReturn(45).when(spy, "printPrivate");

        Assert.assertEquals(spy.forPrivate(), 45);
    }
}
