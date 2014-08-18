package ua.pp.fland.web.bookkeeping.web.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: Maksim_Bondarenko
 * Date: 8/8/14
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return name + " from the server привет";
    }
}
