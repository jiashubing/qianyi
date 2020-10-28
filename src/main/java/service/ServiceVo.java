package service;

/**
 * 废弃了，因为补鞥呢改劲松文件，所以还是直接替换SQL比较稳定
 *
 * @author jiashubing
 * @since 2020/10/27
 */
@Deprecated
public class ServiceVo {
    private String tenantId;
    private String serviceCode;
    private String url;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
