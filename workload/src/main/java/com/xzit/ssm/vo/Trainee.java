package com.xzit.ssm.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * create by hjx on 2018/11/15 0015
 */
public class Trainee {
    private String name;
    private int n;
    private float k;

    private static Map<String,Trainee> traineeMap;

    private Trainee(String name,int n,float k){
        this.name = name;
        this.n = n;
        this.k = k;
    }

    static {
        traineeMap = new HashMap<>();
        traineeMap.put("校内实习实训",new Trainee("校内实习实训",25,1.0f));
        traineeMap.put("校内实习",new Trainee("校内实习",25,1.0f));
        traineeMap.put("校内实训",new Trainee("校内实训",25,1.0f));
        traineeMap.put("校内集中实习",new Trainee("校内集中实习",25,1.0f));
        traineeMap.put("校内集中实训",new Trainee("校内集中实训",25,1.0f));
        traineeMap.put("校内金工实习",new Trainee("校内金工实习",15,1.0f));
        traineeMap.put("校内金工",new Trainee("校内金工",15,1.0f));
        traineeMap.put("数控实习",new Trainee("数控实习",15,1.0f));
        traineeMap.put("校内金工实习数控实习",new Trainee("校内金工实习数控实习",15,1.0f));
        traineeMap.put("校外集中实训校企合作",new Trainee("校外集中实训校企合作",25,0.4f));
        traineeMap.put("校外集中实习市内",new Trainee("校外集中实习市内",25,1.1f));
        traineeMap.put("校外集中实习市外",new Trainee("校外集中实习市外",25,1.2f));
        traineeMap.put("校外分散实习",new Trainee("校外分散实习",50,0.3f));
        traineeMap.put("寒暑假社会实践",new Trainee("寒暑假社会实践",50,0.1f));
    }

    public static Trainee getTrainee(String key){
        return traineeMap.get(key);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public float getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
