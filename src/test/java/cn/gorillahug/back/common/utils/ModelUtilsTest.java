package cn.gorillahug.back.common.utils;

import cn.gorillahug.back.common.model.Work;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class ModelUtilsTest {

    @Test
    public void test() throws Exception {
        Work o = new Work();
        o.setOne("one");
        o.setTwo("two");
        List<Object> value = ModelUtils.getModelValue(o);
        log.info("result:{}", JSON.toJSONString(value));
    }
}
