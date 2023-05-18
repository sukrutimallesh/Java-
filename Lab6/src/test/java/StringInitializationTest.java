import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringInitializationTest {

    String testString;

    @BeforeEach
    public void before() {
        testString = "mz";
    }

    @Test
    public void createSimpleInstance() {
        String name = "String";
        System.out.println(name);
    }

    @Test
    public void createStringUsingConstructor() {
        String name = new String("String");
        System.out.println(name);
    }


    @Test
    public void create2StringWithSameValue() {
        String a = "hey";
        String b = "hey";

        //TODO write a suitable test to check equality of these strings
        if(a.length() != b.length()){
            System.out.println("The Strings are not equal");
        }
        else{
            if(a.equals(b)){
                System.out.println("The Strings are equal");
            }
            else{
                System.out.println("The Strings are not equal");
            }
        }
    }

    @Test
    public void create2StringArrays() {
        String[] a = {"java", "c++", "javascript"};
        String[] b = {"java", "c++", "javascript"};

        //TODO write a suitable test to check equality of these string arrays
        if(a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (!a[i].equals(b[i])) {
                    System.out.println("The String arrays are not equal");
                    break;
                }
            }
            System.out.println("The String arrays are equal");
        }
        else{
            System.out.println("The String arrays are not equal");
        }
    }

    @Test
    public void equalityOfStrings() {
        String[] data1 = {"mz", "my", "my", "mx", "mz", "mx", "my", "mz"};
        String[] data2 = {"mz", "mz", "mz", "mx", "mx", "my", "my", "my"};

        System.out.println(data1[0].equals("mz"));
        System.out.println(data1[0].equals(data2[2]));
        System.out.println(data1[0].equals(new String(data2[0])));

        //TODO convert below prints to asserts
        assert data1[0].equals(testString) : "data1[0] is not equal to testString";
        assert data1[0].equals(new String(testString)) : "data1[0] is not equal to a new String object created from testString";
    }
}
