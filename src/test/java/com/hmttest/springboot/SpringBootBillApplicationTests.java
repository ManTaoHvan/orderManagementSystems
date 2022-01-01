package com.hmttest.springboot;

import com.hmttest.springboot.entities.Bill;
import com.hmttest.springboot.entities.BillProvider;
import com.hmttest.springboot.entities.Provider;
import com.hmttest.springboot.mapper.BillMapper;
import com.hmttest.springboot.mapper.ProviderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;

    @Test
    public void contextLoads() {
        Provider p = new Provider();
        p.setProviderName("A货");
        List<Provider> providers = providerMapper.getProviders(p);
        System.out.println(providers.get(0));

        Provider provider = providerMapper.getProviderByPid(2);
        System.out.println(provider);

        provider.setProviderName("B货域名供应商....");
        int size = providerMapper.updateProvider(provider);
        System.out.println(size);

        //providerMapper.addProvider(new Provider(null, "PR-AA", "HMT供应商111", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"));

        providerMapper.deleteProviderByPid(8);
    }

    @Autowired
    BillMapper billMapper;
    @Test
    public void testBill() {
        Bill b = new Bill();
        b.setBillName("com");
        List<BillProvider> bills = billMapper.getBills(b);
        System.out.println(bills.get(0));

        BillProvider billProvider = billMapper.getBillByBid(4);
        System.out.println(billProvider);

        Bill bill = (Bill) billProvider;
        bill.setBillName("cn域名...");
        billMapper.updateBill(bill);

        //billMapper.addBill(new Bill(3001, "Bi-AA11", "粮油aaa", "斤", 80,480.8, new Provider(null, "PR-BB", "HMT供应商222", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"), 1));
        billMapper.deteleBillByBid(7);
    }

}
