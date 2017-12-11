import com.jcourse.tyukhtenev.lab2.stackcalc.Command;
import com.jcourse.tyukhtenev.lab2.stackcalc.commands.PlusCommand;
import org.junit.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class TestCalc {
    private Map<String, Double> vars = new HashMap<>();
    private Stack<Double> stack = new Stack<>();
    Command command = new PlusCommand();

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before TestCalc.class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After TestCalc.class");
    }
//    @Before
//    public void initTest(){
//        stackCalc = new StackCalc();
//    }
//    @After
//    public void afterTest(){
//        stackCalc = null;
//    }
    @Test
    public void Plus(){

        stack.push(10.);
        stack.push(5.);
        vars.put("A", 5.);
        vars.put("B", 10.);

    }
    @Test
    public void testGetPlus() throws Exception {
        Assert.assertEquals(15, 15);
    }
}
