package com.quansun.springcloud.feignconsumer.Controller;

import com.quansun.springcloud.feignconsumer.Service.HelloService;
import com.quansun.springcloud.feignconsumer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

  @Autowired HelloService helloService;

  @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
  public String helloConsumer() {
    return helloService.hello();
  }

  @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
  public String helloConsumer2() {
    StringBuilder sb = new StringBuilder();
    sb.append(helloService.hello()).append("\n");
    sb.append(helloService.hello("sunquan")).append("\n");
    sb.append(helloService.hello("sunquan", 30)).append("\n");
    sb.append(helloService.hello(new User("sunquan", 30))).append("\n");
    return sb.toString();
  }
}
