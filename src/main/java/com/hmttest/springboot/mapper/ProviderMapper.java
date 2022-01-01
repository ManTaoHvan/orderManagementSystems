package com.hmttest.springboot.mapper;

import com.hmttest.springboot.entities.Provider;


import java.util.List;

/**
 * @Auther: HMT
 */
//@Mapper 或 @MapperScan("com.hmttest.springboot.mapper")
public interface ProviderMapper {

    List<Provider> getProviders(Provider provider);

    Provider getProviderByPid(Integer pid);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    int updateProvider(Provider provider);

}
