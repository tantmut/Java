package homeworks.HW.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

/**
 * Created by nazar123 on 06.02.2018.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(for_testing.Calculator.class)
public class Calculator {


    @Test
    public void shouldReturnSumNumbers() {

        PowerMockito.mockStatic(for_testing.Calculator.class);

        Mockito.when(for_testing.Calculator.returnAnyNumberA()).thenReturn(8);

        Mockito.when(for_testing.Calculator.returnAnyNumberB()).thenReturn(5);

        Mockito.when(for_testing.Calculator.addNumbers()).thenCallRealMethod();

        Assert.assertEquals(13, for_testing.Calculator.addNumbers());
    }


}
//    Создать калькулятор:
//        Метод класса возвращает значение для операции. Создать методы под действия *, /, -, +, %.
//        Создать два public метода, возвращающих случайные числа.
//        Каждый метод класса вызывает один из методов(возвращают случайные числа),
//        чтобы получить значения для операций.
//        Протестировать методы, выполняющие мат. действия. Для каждой операции в тесте возвращать разные значения используя Mockito.
//
//        Создать private методы, возвращающих случ. числа и сделать аналогичные операции, использовав PowerMock.
//        Создать public static методы, возвращающих случ. числа и сделать аналогичные операции.PowerMock
