package view;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName: SystemBackup
 * @Description: TODO
 * @Author: 梁壮
 * @Date: 2019/6/10 10:52
 * @Version: 1.0
 */
public class SystemBackup  {

    public SystemBackup(String path) {
        String proName = "/my.properties";
        Map<String, String> map = this.proRead(proName);
        exportSql(map,path);
    }

    public Map<String, String> proRead(String proName){
        //Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
        Properties properties = new Properties();
        Map<String, String> map = new HashMap<String, String>();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(getClass().getResourceAsStream(proName), StandardCharsets.UTF_8);
            properties.load(inputStreamReader);
            Enumeration enumeration=properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key=(String) enumeration.nextElement();
                String value=properties.getProperty(key);
                map.put(key, value);

            }
            return map;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return null;

    }

    public static void exportSql(Map<String, String> map, String path){
        String user = map.get("jdbc.user");
        String password = map.get("jdbc.password");
        String host = map.get("jdbc.host");
        String exportDatabaseName = map.get("jdbc.exportDatabaseName");

        String exportPath = path;

        //使用拼接的方式来完成dos命令

        String command = "cmd /k mysqldump -u" + user + " -p" + password + " " + exportDatabaseName + " >" + exportPath;
        System.out.println(command);
        //执行命令行
        //每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。可以通过 getRuntime 方法获取当前运行时。
        Runtime runtime = Runtime.getRuntime();
        try {
            //cmd /k在执行命令后不关掉命令行窗口  cmd /c在执行完命令行后关掉命令行窗口   \\表示转译符也可使用/替代，linux使用/
            Process process = runtime.exec(command);
            JOptionPane.showMessageDialog(null, "系统备份成功，sql文件保存在"+path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
