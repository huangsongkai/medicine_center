package com.medicineCenter.util.codeGenerator;

import com.medicineCenter.util.StringUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by song on 16/8/30.
 */
public class GeneratorUtil {

    public static String genContent(VelocityEngine ve, String moduleName, VelocityContext context){
        StringWriter writer = new StringWriter();
        Template t = ve.getTemplate("velocity/ssm/"+moduleName+".vm");
        t.merge(context, writer);
        System.out.println(writer.toString());
        return writer.toString();
    }

    public static void generateFile(String fileName, String content){
        File file = new File(fileName);
        int index = 1;
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        while (file.exists()){
            file = new File(fileName+(index++));
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Class getClass(String classPath, String simpleClassName){
        Class E = null;
        try {
            E = Class.forName(classPath+".model.dataObject."+simpleClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return E;
    }
}
