package com.hmttest.springboot.controller;

import com.hmttest.springboot.dao.ProviderDao;
import com.hmttest.springboot.entities.Provider;
import com.hmttest.springboot.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 供应商的控制层
 * @Auther: HMT
 */
@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProviderDao providerDao;
    
    @Autowired
    ProviderMapper providerMapper;
    

    @GetMapping("/providers")
    public String list(Map<String, Object> map, Provider provider) {
        logger.info("供应商列表查询。。。" + provider);

        List<Provider> providers = providerMapper.getProviders(provider);

        map.put("providers", providers);
        map.put("providerName", provider.getProviderName());

        return "provider/list";
    }

    /**
     * type = null 进入查看详情页面view.html，
     * type=update 则是进入update.html
     * @param pid 供应商id
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value="type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + pid + "的供应商详细信息");

        Provider provider = providerMapper.getProviderByPid(pid);

        map.put("provider", provider);

        // type = null 则进入view.html， type=update 则是进入update.html
        return "provider/" + type;
    }

    //修改供应商信息
    @PutMapping("/provider")
    public String update(Provider provider) {
        logger.info("更改供应商信息。。。");
        //更新操作
        providerMapper.updateProvider(provider);

        return "redirect:providers";
    }

    //前往添加 页面
    @GetMapping("/provider")
    public String toAddPage() {
        return "provider/add";
    }


    //添加数据
    @PostMapping("/provider")
    public String add(Provider provider) {
        logger.info("添加供应商数据" + provider);
        //保存数据操作
        providerMapper.addProvider(provider);

        return "redirect:/providers";
    }

    //删除供应商
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除操作, pid=" + pid);
        providerMapper.deleteProviderByPid(pid);
        return "redirect:/providers";
    }
}
