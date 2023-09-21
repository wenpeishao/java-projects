import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.FileNotFoundException;

public class DataWranglerTests {
    public HouseLoader houseL;

    @BeforeEach
    public void createInstance() {
        houseL = new HouseLoader();
    }

    /**
     * testing loading an empty xml file
     */
    @Test
    public void test1() {
        try {
            List<House> list = houseL.loadHouses(System.getProperty("user.dir") + "/empty.xml");
            assertEquals(0, list.size());
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    /**
     * testing loading a valid xml file
     */
    @Test
    public void test2() {
        try {
            List<House> list = houseL.loadHouses(System.getProperty("user.dir") + "/Housing.xml");
            assertEquals(545, list.size());
            for (House house : list) {
                if (Objects.isNull(house.getPrice()) || Objects.isNull(house.getNumBaths())
                        || Objects.isNull(house.getNumBedrooms())) {
                    fail();
                }
            }
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    /**
     * testing loading an invalid xml file
     */
    @Test
    public void test3() {
        try {
            List<House> list = houseL.loadHouses(System.getProperty("user.dir") + "nonexistent.xml");
            fail();
        } catch (FileNotFoundException e) {

        }
    }

    /**
     * testing if loading a valid xml file will result in any exceptions
     */
    @Test
    public void test4() {
        try {
            List<House> list = houseL.loadHouses(System.getProperty("user.dir") + "/Housing.xml");
        } catch (FileNotFoundException e) {
            fail();
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * testing if loading a valid null path to the xml file
     */
    @Test
    public void test5() {
        try {
            String nullPath=null;
            List<House> list = houseL.loadHouses(nullPath);
            fail();
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            fail();
        }
    }
}
