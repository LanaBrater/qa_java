import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionsKittensTest() throws Exception {
        int expectedResult = 1;
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(expectedResult);
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void lionsFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = List.of("Животные", "Птицы", "Рыба");
        List<String> expectedResult = lion.getFood();
        assertEquals(expectedResult, actualResult);
    }
    @Test(expected = Exception.class)
    public void exceptionTest() throws Exception {
        Lion lion = new Lion("tiger", feline);
    }
}


