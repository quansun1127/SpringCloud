package com.quansun.springcloud.feignconsumer.Service;

import com.quansun.springcloud.feignconsumer.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("service-sunquan")
public interface HelloService {
  @RequestMapping("hello")
  String hello();

  @RequestMapping(value = "hello1", method = RequestMethod.GET)
  String hello(@RequestParam(value = "name") String name);

  @RequestMapping(value = "hello2", method = RequestMethod.GET)
  User hello(@RequestHeader(value = "name") String name, @RequestHeader("age") Integer age);

  @RequestMapping(value = "hello3", method = RequestMethod.POST)
  String hello(@RequestBody User user);
}
