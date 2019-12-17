package com.xiayu.demo.feign;

import com.xiayu.demo.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/17 15:36
 */

@FeignClient(value = "business-profile-service", path = "profile", configuration = FeignRequestConfiguration.class)
public interface TestInterface {
}
