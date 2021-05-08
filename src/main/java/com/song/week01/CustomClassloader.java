package com.song.week01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author songshiyu
 * @description: 自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码
 * @create: 2021/5/8 15:55:21
 **/
public class CustomClassloader extends ClassLoader {

    private static Logger logger = LoggerFactory.getLogger(CustomClassloader.class.getSimpleName());

    private static String filePath = "/Users/songshiyu/IdeaProjects/java_advance/src/main/java/com/song/week01/Hello.xlass";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filePath)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
