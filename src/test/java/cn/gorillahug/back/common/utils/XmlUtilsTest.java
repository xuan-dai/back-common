package cn.gorillahug.back.common.utils;

import cn.gorillahug.back.common.model.xml.Project;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Slf4j
public class XmlUtilsTest {

    @Test
    public void test() throws Exception {
        String filePath = "E:\\workspace\\gorillahug\\back-common\\src\\main\\resources\\demo.xml";
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        StringBuilder xml = new StringBuilder();
        String line = buffer.readLine();
        // 小细节，换行时，line="",所以不能使用StringUtils.isNotEmpty()，否则将导致xml文件读取错误
        while (line != null) {
            xml.append(line);
            xml.append("\n");
            line = buffer.readLine();
        }
        Project student = XmlUtils.xml2Bean(xml.toString());
        log.info(JSON.toJSONString(student));
    }
}
