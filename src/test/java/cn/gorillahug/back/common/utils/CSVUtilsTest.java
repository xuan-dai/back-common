package cn.gorillahug.back.common.utils;

import cn.gorillahug.back.common.model.Work;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CSVUtilsTest {

    @Test
    public void test() throws Exception {
        List<String> title = new ArrayList<>();
        List<Work> data = new ArrayList<>();

        Work work = new Work();
        work.setOne("one");
        work.setTwo("two");

        data.add(work);
        data.add(work);
        data.add(work);

        String csvString = CSVUtils.makeCsvString(title, data);
        log.info(csvString);
    }
}
