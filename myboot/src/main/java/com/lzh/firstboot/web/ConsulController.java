package com.lzh.firstboot.web;

import com.lzh.firstboot.service.ConsulService;
import com.microservice.archaius.ConsulConfigurationSource;
import com.netflix.config.*;
import com.orbitz.consul.model.health.ServiceHealth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 作者： Jonathan
 * 创建时间： 2016/10/17 ${Time}.
 * ConsulController的描述：${DESCRIPTION}
 */
@RestController
@RequestMapping("/consul")
@Api("Consul相关API")
public class ConsulController {
    @Autowired
    private ConsulService consulService;

    /**
     * 服务器注册与发现
     */
    @ApiOperation("注册服务")
    @RequestMapping(value = "/registerService/{servicename}/{serviceid}", method = RequestMethod.POST)
    public void registerService(@PathVariable("servicename") String serviceName, @PathVariable("serviceid") String serviceId) {
        consulService.registerService(serviceName, serviceId);
    }

    @ApiOperation("发现服务")
    @RequestMapping(value = "/discoverService/{servicename}", method = RequestMethod.GET)
    public List<ServiceHealth> discoverService(@PathVariable("servicename") String serviceName) {
        return consulService.findHealthyService(serviceName);
    }
    /*******************************KV*******************************/
    @ApiOperation("store KV")
    @RequestMapping(value="/kv/{key}/{value}",method=RequestMethod.POST)
    public void storeKV(@PathVariable("key") String key,
                        @PathVariable("value") String value) {
        consulService.storeKV(key, value);
    }

    @ApiOperation("get KV")
    @RequestMapping(value="/kv/{key}",method=RequestMethod.GET)
    public String getKV(@PathVariable("key") String key) {
        return consulService.getKV(key);
    }

    /*******************************server*******************************/
    @ApiOperation("获取同一个DC中的所有server节点")
    @RequestMapping(value="/raftpeers",method=RequestMethod.GET)
    public List<String> findRaftPeers() {
        return consulService.findRaftPeers();
    }

    @ApiOperation("获取leader")
    @RequestMapping(value="/leader",method=RequestMethod.GET)
    public String leader() {
        return consulService.findRaftLeader();
    }

    /**
     * 根据数据配置源PolledConfigurationSource与调度器AbstractPollingScheduler构建DynamicConfiguration（该类实际上就是一个Property）
     将DynamicConfiguration加入到ConfigurationManager中
     使用DynamicPropertyFactory.getInstance().getStringProperty(String key, String defaultValue)去动态读取
     * @param key
     * @throws IOException
     */

    @ApiOperation("get KV from consul by archaius")
    @RequestMapping(value="/kv2/",method=RequestMethod.GET)
    public void getKVByArchaius(@RequestParam("key") String key) throws IOException {

        PolledConfigurationSource source = new ConsulConfigurationSource(key);//定义读取配置的源头
        AbstractPollingScheduler scheduler = new FixedDelayPollingScheduler();//设置读取配置文件的
        DynamicConfiguration configuration = new DynamicConfiguration(source, scheduler);

        ConfigurationManager.install(configuration);

        DynamicStringProperty dsp = DynamicPropertyFactory.getInstance().getStringProperty("mysql.driverClassName", "lzhDriver");
        System.out.println("当前时间：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")+ "-->值：" + dsp.get());
        try {
            Thread.sleep(60000);//睡60s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前时间：" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "-->值：" + dsp.get());
    }


}
