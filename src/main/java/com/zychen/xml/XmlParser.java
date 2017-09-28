package com.zychen.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

/**
 * @author 章源辰
 * @time: 2017/9/28 23:08
 * @describion: 解析xml文件到Java对象，可以根据不同的字段映射
 */
public class XmlParser {

    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("/Users/gemini/WorkSpace/java/utils/src/main/java/com/zychen/xml/user.xml"));
        Element root = document.getRootElement();
        User user = parseXmlToObject(root.elementIterator(), new User());
        System.out.println(user);
    }


    public static User parseXmlToObject(Iterator<Element> it, User user) throws DocumentException, IllegalAccessException {
        Field[] fields = user.getClass().getDeclaredFields();
        String mapperValue = null;

        while (it.hasNext()) {
            Element element = it.next();
            Iterator<Attribute> attributes = element.attributeIterator();
            while (attributes.hasNext()) {
                Attribute attr = attributes.next();
                String name = attr.getName();
                String value = attr.getValue();
                for (Field field : fields) {
                    //Mapper mapper = AnnotationUtils.findAnnotation(cls, Mapper.class);
                    Mapper mapper = field.getAnnotation(Mapper.class);
                    mapperValue = mapper.value();
                    if (name.equals(mapperValue)) {
                        field.setAccessible(true);
                        field.set(user, value);
                    }
                }
            }
        }

        return user;
    }
}
