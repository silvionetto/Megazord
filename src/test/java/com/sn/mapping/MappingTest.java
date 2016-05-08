package com.sn.mapping;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by silvionetto on 5/8/16.
 */
@RunWith(ConcordionRunner.class)
public class MappingTest {

    public Integer testMapIteration(String arg1, String arg2){
        Map<Integer, String> map = new HashMap<Integer, String>();
            map.put(0, arg1);
            map.put(1, arg2);

        List<String> jvmLangs = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            jvmLangs.add(entry.getValue());
        }
        return jvmLangs.size();
    }
}
