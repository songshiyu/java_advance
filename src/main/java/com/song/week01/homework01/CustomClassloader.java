package com.song.week01.homework01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

/**
 * @author songshiyu
 * @description: 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件
 * @create: 2021/5/8 15:55:21
 **/
public class CustomClassloader extends ClassLoader {

    private static Logger logger = LoggerFactory.getLogger(CustomClassloader.class.getSimpleName());

    private String filePath;


    public CustomClassloader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath), Charset.forName("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (String line : allLines) {
                sb.append(line);
            }
            logger.info("base64:{}", sb.toString());
            byte[] bytes = decode(sb.toString());
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
