package com.hmttest.springboot.entities;

/**
 * 封装新的实体，因为帐单列表还有详情都要有供应商名称
 * @Auther: HMT
 */
public class BillProvider extends Bill {

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
