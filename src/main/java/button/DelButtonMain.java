package button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author jiashubing
 * @since 2020/10/28
 */
public class DelButtonMain {

    // 在A、B两个环境分别执行下面SQL，分别填写到oldService.properties 、newService.properties
    // SELECT group_concat(service_code,"=",service_id) FROM workbench.wb_service WHERE service_id IN (select service_id from workbench.wb_service where application_id in (select application_id from workbench.wb_application where application_id in (select application_id from workbench.wb_label_application_relation where label_id in (select label_id from workbench.wb_label where label_type='domain' and label_name='贾树丙领域')))) GROUP BY service_code;
    // SELECT group_concat(service_code,"=",service_id) FROM workbench.wb_service WHERE service_id IN (select service_id from workbench.wb_service where application_id in (select application_id from workbench.wb_application where application_id in (select application_id from workbench.wb_label_application_relation where label_id in (select label_id from workbench.wb_label where label_type='domain' and label_name in ('ERP重构-预算中心','ERP重构-BM单中心'))))) GROUP BY service_code;
    private static Map<String, String> oldMap = new HashMap<>();
    private static Map<String, String> newMap = new HashMap<>();
    private static final String oldFileName = "oldService.properties";
    private static final String newFileName = "newService.properties";

    // 在A环境执行下面SQL，填写到button.txt
    // select * from workbench.wb_button_permission where service_id in (select service_id from workbench.wb_service where application_id in (select application_id from workbench.wb_application where application_id in (select application_id from workbench.wb_label_application_relation where label_id in (select label_id from workbench.wb_label where label_type='domain' and label_name='贾树丙领域'))));
    private static final String buttonName = "button.txt";

    public static void main(String[] args) {

        InputStream fr = DelButtonMain.class.getResourceAsStream(buttonName);
        BufferedReader in = new BufferedReader(new InputStreamReader(fr));
        String oneLine;
        try {
            int ans = 0;
            while ((oneLine = in.readLine()) != null) {
                boolean flag = deal(oneLine);
                if (flag) {
                    ans++;
                }
            }
            System.out.println("-- 共计修改了 " + ans + " 条数据");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean deal(String str) {

        for (Map.Entry<String, String> entry : oldMap.entrySet()) {
            if (str.contains(entry.getValue())) {
                String tmp = newMap.get(entry.getKey());
                if (tmp == null || "".equals(tmp)) {
                    System.out.println("新环境列没有对应的serviceId");
                }
                str.replaceFirst(entry.getValue(), tmp);
                System.out.println(str);
                return true;
            }
        }
        return false;
    }

}
