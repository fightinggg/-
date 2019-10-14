package video;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AAPlayer {
    static Map<String, String> nametojar = new TreeMap<String, String>();
    static Map<String, String> nametoclass = new TreeMap<String, String>();

    public static void loadJar(String jarPath) {
        File jarFile = new File(jarPath);
        // 从URLClassLoader类中获取类所在文件夹的方法，jar也可以认为是一个文件夹
        Method method = null;
        try {
            method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        } catch (NoSuchMethodException | SecurityException e1) {
            e1.printStackTrace();
        }
        // 获取方法的访问权限以便写回
        boolean accessible = method.isAccessible();
        try {
            method.setAccessible(true);
            // 获取系统类加载器
            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            URL url = jarFile.toURI().toURL();
            method.invoke(classLoader, url);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.setAccessible(accessible);
        }
    }

    public static void readingxml() throws DocumentException {
        //reading
        String path = "/Users/s/Desktop/workspace/java/plugin/src/plugin.xml";
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(path));
        Element root = document.getRootElement();
        List<?> plugins = ((org.dom4j.Element) root).elements("plugin");
        for (Object pluginObj : plugins) {
            Element pluginEle = (Element) pluginObj;
            String name = pluginEle.elementText("name");
            String jar = pluginEle.elementText("jar");
            String clas = pluginEle.elementText("class");
//            loadJar(jar);
            nametojar.put(name, jar);
            nametoclass.put(name, clas);
        }
    }

    public static void main(String[] args) throws DocumentException {
        readingxml();
        new AAPFrame().goGOGO();
    }
}
