package org.wahlzeit.utils;

import java.util.HashMap;
import java.util.Map;

public class MultiLevelHashMap<TKey1, TKey2, TKey3, TValue> {
    
    private final Map<TKey1, Map<TKey2, Map<TKey3, TValue>>> rootMap = new HashMap<>();


    /**
     * @methodtype get
     * @methodproperty composed
     */
    public TValue get(TKey1 key1, TKey2 key2, TKey3 key3) {
        return getValueMap(key1, key2).get(key3);
    }

    /***
     * @methodproperty composed
     */
    public void put(TKey1 key1, TKey2 key2, TKey3 key3, TValue value) {
        getValueMap(key1, key2).put(key3, value);
    }



    private Map<TKey3, TValue> getValueMap(TKey1 key1, TKey2 key2) {

        if(!rootMap.containsKey(key1)) {
            rootMap.put(key1, new HashMap<TKey2, Map<TKey3, TValue>>());
        }

        if(!rootMap.get(key1).containsKey(key2)) {
            rootMap.get(key1).put(key2, new HashMap<TKey3, TValue>());
        }



        return rootMap.get(key1).get(key2);
    }


}
