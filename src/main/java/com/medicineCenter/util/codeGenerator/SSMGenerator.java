package com.medicineCenter.util.codeGenerator;
import com.medicineCenter.util.StringUtil;
import com.medicineCenter.util.TimeUtil;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by song on 16/9/1.
 */
public class SSMGenerator implements Generator{

    String simpleClassName;
    String projectName;
    String jarHome;
    String vmHome;
    String webHome;
    String classPath;

    VelocityEngine ve = new VelocityEngine();
    VelocityContext context = new VelocityContext();


    // 设置模板的路径
    String projectHome;

    public void init(Properties properties){
        this.simpleClassName = properties.getProperty("simpleClassName");
        this.projectName = properties.getProperty("projectName");
        this.projectHome = "src/main/java/com/"+projectName;
        this.jarHome = projectHome;
        this.vmHome = this.jarHome +"/util/codeGenerator";
        this.webHome = "web/WEB-INF/pages";
        this.classPath = "com."+projectName;
        Properties veProperties = new Properties();
        veProperties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, vmHome);
        veProperties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        ve.init(veProperties);
        setDefaultContext(properties);
    }

    public void setDefaultContext(Properties properties){
        for(String name : properties.stringPropertyNames()){
            addContext(name, properties.getProperty(name));
        }
        addContext("object", StringUtil.getObjName(this.simpleClassName));
    }
    void addContext(String key, String value){
        this.context.put(key, value);
    }

    public SSMGenerator generateJsp(){
        Class E = GeneratorUtil.getClass(classPath, simpleClassName);
        Field[] declaredFields = E.getDeclaredFields();
        List<ValuePair> fieldList = new ArrayList<ValuePair>();
        for(Field field : declaredFields){
            if(field.getName().equals("createTime"))
                continue;
            ValuePair valuePair = new ValuePair();
            valuePair.setName(field.getName());
            if(field.getName().toLowerCase().contains("time"))
                valuePair.setValue(TimeUtil.now());
            else
                valuePair.setValue(field.getName());
            fieldList.add(valuePair);
        }
        context.put("fieldList", fieldList);
        context.put("object", E.getSimpleName().toLowerCase());
        String filePath = this.webHome + "/" + StringUtil.getObjName(this.simpleClassName);
        generateTemplate(filePath + "/add.jsp", "add_jsp");
        generateTemplate(filePath + "/edit.jsp", "edit_jsp");
        generateTemplate(filePath + "/list.jsp", "list_jsp");
        return this;
    }

    public SSMGenerator generateController(){
        setIdType();
        generateTemplate(this.projectHome + "/interfaces/controller/" + simpleClassName + "CrudController.java", "controller");
        return this;
    }

    public SSMGenerator generateService(){
        setIdType();
        generateTemplate(this.projectHome + "/service/" + simpleClassName + "CrudService.java", "service");
        return this;
    }
    public SSMGenerator generateMapperExt(){
        generateTemplate(this.projectHome + "/dao/" + simpleClassName + "MapperExt.java", "mapperExt");
        return this;
    }

    public void generateTemplate(String fileName, String moduleName){
        GeneratorUtil.generateFile(fileName,
                GeneratorUtil.genContent(ve, moduleName, context));
    }

    public void setIdType(){
        if(!context.containsKey("idType")){
            Field[] declaredFields = GeneratorUtil.getClass(classPath, simpleClassName).getDeclaredFields();
            addContext("idType", declaredFields[0].getType().getName());
        }
    }

    public void generateAll(){
        generateJsp().generateController().generateService().generateMapperExt();
    }

    public static void main(String args[]){
        SSMGenerator ssm = new SSMGenerator();
        Properties properties = new Properties();
        properties.setProperty("projectName", "medicineCenter");
        properties.setProperty("simpleClassName", "Test");
        ssm.init(properties);
        ssm.generateAll();
//      ssm.generateJsp();
    }
}
