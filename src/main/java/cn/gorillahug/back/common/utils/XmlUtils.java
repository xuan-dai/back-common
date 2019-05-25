package cn.gorillahug.back.common.utils;

import cn.gorillahug.back.common.model.xml.Project;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daixuan
 * @version 2019/5/21 21:51
 */
@Slf4j
public class XmlUtils {

    public static Project xml2Bean(String xml){
        XStream xStream = new XStream(new DomDriver("utf-8"));
        xStream.registerConverter(new DateConverter());
        xStream.processAnnotations(Project.class);
        xStream.autodetectAnnotations(true);
        xStream.setClassLoader(Project.class.getClassLoader());
        return (Project)xStream.fromXML(xml);
    }

}
