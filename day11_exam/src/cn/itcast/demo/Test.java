package cn.itcast.demo;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {

        for(int i=0;i<100;i++){
            //String id = UUID.randomUUID().toString();
            //id=id.replace("-","");
            //System.out.println(id);

            String id = UUID.randomUUID().toString().replace("-", "");
            System.out.println(id); // 唯一标识
        }

    }
}
