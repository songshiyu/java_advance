package com.song.week01.homework01;

/**
 * @author songshiyu
 * @description:
 * @create: 2021/5/8 17:49:33
 **/
public class main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String filePath = "/Users/songshiyu/IdeaProjects/java_advance/src/main/java/com/song/week01/Hello.xlass";

        CustomClassloader customClassloader = new CustomClassloader(filePath);
        customClassloader.findClass("JVM.Hello").newInstance();
    }
}
