package cn.gorillahug.back.common.model.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author daixuan
 * @version 2019/5/21 21:56
 */
@Data
@XStreamAlias("dependency")
public class Dependency {
    private String groupId;
    private String artifactId;
    private String version;
    private String optional;
    private String scope;

}
