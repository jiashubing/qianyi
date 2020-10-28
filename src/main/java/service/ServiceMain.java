package service;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @author jiashubing
 * @since 2020/10/27
 */
public class ServiceMain {
    private static String oldStr = "http://dev.nbf.qm.cn/";
    private static String newStr = "http://stage.nbf.faw.cn/";

    public static void main(String[] args) {


        String json = "[{\"createTime\":1603355746000,\"ts\":1603355746000,\"creator\":\"ec4326d0-d490-4d5a-9105-260b51fd16d0\",\"tenantId\":\"r2sc8ufe\",\"orgFuncationsGlobal\":false,\"serviceId\":\"aaa3bee6-e457-4e2b-9793-c50ed244655a\",\"serviceName\":\"单卡\",\"serviceNameMultiLangText\":{\"textMap\":{\"zh_CN\":\"单卡\"}},\"identitys\":\"1\",\"serviceCode\":\"474cc868-df15-4943-a5b1-ab806d3e7a93\",\"applicationId\":\"3d0c0971-9f02-4030-b45c-688659687ad1\",\"enable\":true,\"url\":\"http://dev.nbf.qm.cn/developplatform/meta/Voucher/3cf694ea/add?_preview=1\",\"capable\":false,\"ykjId\":0,\"level\":0,\"teamMenbersUnuse\":false,\"crossTenant\":false,\"selected\":false,\"simpleApplicationStatus\":false,\"clientStatus\":false,\"webStatus\":true,\"phoneStatus\":false,\"retailStatus\":false,\"nativeMobileStatus\":false,\"vxStatus\":false,\"dingdingStatus\":false,\"everyone\":false,\"sysEveryone\":false,\"phoneOrder\":0,\"businessTypeInt\":2,\"openNewTab\":false,\"nccEnable\":false,\"lisenceBeforeOpen\":true,\"serviceType\":1,\"hasWidget\":false,\"relationServices\":[],\"relationUsers\":[],\"buttonPerms\":[],\"authorizationSet\":[],\"home\":false,\"first\":false,\"primitive\":false,\"navShow\":\"1\",\"pcOpenType\":1,\"webOpenType\":0,\"orders\":99,\"systemTypeService\":false,\"managerTypeService\":true,\"businessTypeService\":false},{\"createTime\":1603355746000,\"ts\":1603355746000,\"creator\":\"ec4326d0-d490-4d5a-9105-260b51fd16d0\",\"tenantId\":\"r2sc8ufe\",\"orgFuncationsGlobal\":false,\"serviceId\":\"db763eeb-450d-4482-8161-cd4edf6b47b1\",\"serviceName\":\"单卡列表\",\"serviceNameMultiLangText\":{\"textMap\":{\"zh_CN\":\"单卡列表\"}},\"identitys\":\"1\",\"serviceCode\":\"e5954239-84da-4ed0-91f8-94e8c91c85b6\",\"applicationId\":\"3d0c0971-9f02-4030-b45c-688659687ad1\",\"enable\":true,\"url\":\"http://dev.nbf.qm.cn/developplatform/meta/VoucherList/3cf694eaList?_preview=1\",\"capable\":false,\"ykjId\":0,\"level\":0,\"teamMenbersUnuse\":false,\"crossTenant\":false,\"selected\":false,\"simpleApplicationStatus\":false,\"clientStatus\":false,\"webStatus\":true,\"phoneStatus\":false,\"retailStatus\":false,\"nativeMobileStatus\":false,\"vxStatus\":false,\"dingdingStatus\":false,\"everyone\":false,\"sysEveryone\":false,\"phoneOrder\":0,\"businessTypeInt\":2,\"openNewTab\":false,\"nccEnable\":false,\"lisenceBeforeOpen\":true,\"serviceType\":1,\"hasWidget\":false,\"relationServices\":[],\"relationUsers\":[],\"buttonPerms\":[],\"authorizationSet\":[],\"home\":false,\"first\":false,\"primitive\":false,\"navShow\":\"1\",\"pcOpenType\":1,\"webOpenType\":0,\"orders\":99,\"systemTypeService\":false,\"managerTypeService\":true,\"businessTypeService\":false}]";

        int ans = 0;
        List<ServiceVo> list = JSONArray.parseArray(json, ServiceVo.class);
        for (ServiceVo item : list) {
            if (item.getUrl().contains(oldStr)) {
                ans++;
                String tmp = item.getUrl().replace(oldStr, newStr);
                System.out.println("update workbench.wb_service set url = '" +
                        tmp + "' where tenant_id = '" +
                        item.getTenantId() + "' and service_code = '" + item.getServiceCode() + "';");
            }
        }

        System.out.println("-- 共计修改了 " + ans + " 条数据");

    }
}
