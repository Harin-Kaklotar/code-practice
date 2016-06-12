import java.util.*;

public class MapUtil {

    public static List<Map>  splitMapToSubMaps(Map sourceMap ,int noOfSubMaps ){
        List<Map> mapList = new ArrayList<>(noOfSubMaps);
        for (int i = 0; i < noOfSubMaps; i++) {
            mapList.add(new HashMap<>());
        }
        int i = 0;
        final Iterator iterator = sourceMap.keySet().iterator();
        while (iterator.hasNext()){
            Object key  = iterator.next();
            Object value  = sourceMap.get(key);
            mapList.get(i%mapList.size()).put(key,value);
            i++;
        }
        return mapList;
    }
}
