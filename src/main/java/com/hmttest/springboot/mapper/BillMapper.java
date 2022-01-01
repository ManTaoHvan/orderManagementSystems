package com.hmttest.springboot.mapper;

import com.hmttest.springboot.entities.Bill;
import com.hmttest.springboot.entities.BillProvider;
import com.hmttest.springboot.entities.Provider;

import java.util.List;

/**
 * @Auther: HMT
 */
//@Mapper 或 @MapperScan("com.hmttest.springboot.mapper")
public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deteleBillByBid(Integer bid);

}
