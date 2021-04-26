import main.Main;
import main.exo1.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestsExo1 {

    private Model model;

    @BeforeEach
    public void freshModel(){

        this.model = new Model(Main.buildTasks());
    }

    @Test
    void sortModelTest() {

        this.model.sortDescending();
        //Assertions.assertEquals(,);
    }

    @Test
    void penaltyNotNegativeTest(){


    }

    @Test
    void buildCorrectlyTest(){


    }

    @Test
    void valueMinLimitTest(){


    }

    @Test
    void pathMinLimitTest(){


    }
}


