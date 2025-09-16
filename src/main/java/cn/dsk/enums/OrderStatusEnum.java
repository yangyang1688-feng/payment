package cn.dsk.enums;

public enum OrderStatusEnum {
    CREATED("已创建"),
    PAYING("支付中"),
    PAID("已支付"),
    FAILED("支付失败");
    
    private final String description;
    
    OrderStatusEnum(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}