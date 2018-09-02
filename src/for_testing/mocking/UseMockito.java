package mocking;

import for_testing.mockito.ImitationDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;


@RunWith(MockitoJUnitRunner.class)
public class UseMockito {

    @Mock
    ImitationDB imitationDB;

    /*@Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();*/

    @Test
    public void getAllRecordsUsingMockObject() {

//        ImitationDB imitationDB = Mockito.mock(ImitationDB.class);

        Mockito.when(imitationDB.getAllRecords()).thenReturn(Arrays.asList("Empty"));

        Assert.assertArrayEquals(imitationDB.getAllRecords().toArray(), Arrays.asList("Empty").toArray());

        Mockito.verify(imitationDB, Mockito.times(1)).getAllRecords();
    }



    /*
    * method{
    * int a = method1
    * }
    * */
}
