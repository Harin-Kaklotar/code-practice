import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MapUtilTest {

    @Test
    public void testSplitMapToSubMaps() throws Exception {
        Map<String, String> map = new HashMap<>();
        int totalRecords = 1051;
        for (int i = 0; i < totalRecords; i++) {
            map.put("test" + i, "test2");
        }

        int split = 10;
        final List<Map> mapList = MapUtil.splitMapToSubMaps(map, split);
        assertEquals(split, mapList.size());
        for (Map map1 : mapList) {
            assertTrue("map-size = " + map1.size(), (map1.size() == 1050 / 10) || (map1.size() == (1050 / 10 + 1)));
        }
    }
}