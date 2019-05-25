package cn.gorillahug.back.common.model.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @author daixuan
 * @version 2019/5/25 18:59
 */
@Data
@XStreamAlias("project")
public class Project {

    private String modelVersion;
    private String groupId;
    private String artifactId;
    private String version;
    private String description;

    @XStreamAlias("dependencies")
    private List<Dependency> dependencies;
//    @XStreamAlias("parent")
    private Parent parent;

}
