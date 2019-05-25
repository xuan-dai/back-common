package cn.gorillahug.back.common.model.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author daixuan
 * @version 2019/5/25 18:59
 */
@Data
@XStreamAlias("parent")
public class Parent {
    private String groupId;
    private String artifactId;
    private String version;
    private String relativePath;

}
