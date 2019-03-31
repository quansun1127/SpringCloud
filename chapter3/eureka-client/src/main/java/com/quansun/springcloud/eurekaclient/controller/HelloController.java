package com.quansun.springcloud.eurekaclient.controller;

import com.quansun.springcloud.eurekaclient.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class HelloController {

  private final Logger logger = Logger.getLogger(getClass().getName());

  @Autowired private DiscoveryClient client;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String index() {
    List<String> serviceIds = client.getServices();
    serviceIds.stream()
        .forEach(
            serviceId -> {
              List<ServiceInstance> serviceInstances = client.getInstances(serviceId);
              serviceInstances.forEach(
                  serviceInstance ->
                      logger.info(
                          "/hello, host:"
                              + serviceInstance.getHost()
                              + ", service_id:"
                              + serviceInstance.getServiceId()));
            });
    return "Hello Spring Cloud Erureka Client.";
  }

  @RequestMapping(value = "hello1", method = RequestMethod.GET)
  public String hello(@RequestParam String name) {
    return "Hello " + name;
  }

  @RequestMapping(value = "hello2", method = RequestMethod.GET)
  public User hello(@RequestHeader String name, @RequestHeader Integer age) {
    return new User(name, age);
  }

  @RequestMapping(value = "hello3", method = RequestMethod.POST)
  public String hello(@RequestBody User user) {
    return "Hello " + user.getName() + ", " + user.getAge();
  }
}
