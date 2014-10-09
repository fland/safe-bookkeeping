package ua.pp.fland.web.bookkeeping.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.pp.fland.web.bookkeeping.storage.dao.RecordDAO;
import ua.pp.fland.web.bookkeeping.storage.model.Record;

import java.time.LocalDate;
import java.util.Date;


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

    @Autowired
    private RecordDAO recordDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/say/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return name + " from the server привет";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String add() {
        Record record = new Record();
        record.setDescription("Value. Date: " + new Date());
        Record.Date date = new Record.Date();
        date.setYear(2012);
        date.setMonth(6);
        date.setDay(13);
        record.setDate(date);
        recordDAO.save(record);
        LocalDate temp = LocalDate.now();
        temp.getYear();
        return "Done. Decs: " + record.getDescription();
    }
}
