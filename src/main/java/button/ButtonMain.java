package button;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author jiashubing
 * @since 2020/10/28
 */
public class ButtonMain {

    private static Map<String, String> oldMap = new HashMap<>();
    private static Map<String, String> newMap = new HashMap<>();
    private static final String oldFileName = "oldService.properties";
    private static final String newFileName = "newService.properties";

    public static void main(String[] args) {
        ButtonMain buttonMain = new ButtonMain();
        buttonMain.loadPorperties(oldMap,oldFileName);
    }

    private void loadPorperties(Map<String,String> map, String fileName) {
        // 在A、B两个环境分别执行下面SQL
        // SELECT group_concat(service_code,"=",service_id) FROM workbench.wb_service WHERE service_id IN (select service_id from workbench.wb_service where application_id in (select application_id from workbench.wb_application where application_id in (select application_id from workbench.wb_label_application_relation where label_id in (select label_id from workbench.wb_label where label_type='domain' and label_name='贾树丙领域')))) GROUP BY service_code;
        InputStream in = getClass().getResourceAsStream(fileName);
        Properties props = new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            map.put(entry.getKey().toString(), entry.getValue().toString());
        }

        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println(item.getKey());
        }

    }

}
