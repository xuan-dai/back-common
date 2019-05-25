package cn.gorillahug.back.common.utils;


import de.siegmar.fastcsv.writer.CsvAppender;
import de.siegmar.fastcsv.writer.CsvWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Slf4j
public class CSVUtils {

    public static String makeCsvString(List<String> title, List<?> data) throws Exception {
        String result = "";
        if (CollectionUtils.isEmpty(data)) {
            return result;
        }
        CsvWriter csvWriter = new CsvWriter();
        StringWriter writer = new StringWriter();

        try (CsvAppender csvAppender = csvWriter.append(writer)) {
            if (!CollectionUtils.isEmpty(title)) {
                csvAppender.appendLine(title.toArray(new String[title.size()]));
            }

            data.stream().forEach(item -> {
                try {
                    List<Object> values = ModelUtils.getModelValue(item);
                    for (Object val : values) {
                        csvAppender.appendField((String) val);
                    }
                    csvAppender.endLine();
                } catch (IOException | IllegalAccessException e) {
                    e.printStackTrace();
                    log.error("gen csv string error," + e.getMessage());
                }
            });
            csvAppender.flush();
            result = writer.toString();
        } catch (IOException e) {
            throw e;
        }
        return result;
    }
}

