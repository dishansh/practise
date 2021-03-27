import com.marvel.api.controllers.CharactersController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MarvelApiApplicationTest {

    @Autowired
    private CharactersController charactersController;

    @Test
    public void contextLoads(){}

    @Test
    public void testIfCharactersControllerLoads(){
        Assert.assertEquals(null, charactersController);
    }
}
