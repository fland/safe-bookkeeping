package ua.pp.fland.web.bookkeeping.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.pp.fland.web.bookkeeping.storage.dao.RecordDAO;
import ua.pp.fland.web.bookkeeping.storage.model.Record;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created with IntelliJ IDEA.
 * User: maxim
 * Date: 9/26/14
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/records")
public class RecordsController {

    public static final Logger log = LoggerFactory.getLogger(RecordsController.class);

    @Autowired
    RecordDAO recordDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public String getAll() {
        log.debug("Fetching all records...");

        List<Record> records = recordDAO.getAll();

        StringJoiner joiner = new StringJoiner("<br>");
        for (Record record : records) {
            joiner.add(record.toString());
        }

        return joiner.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public String getById(@PathVariable("id") String id) {
        log.debug("Fetching record by id: " + id);

        Record record = recordDAO.getById(id);

        return record.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getJSON/{id}")
    @ResponseBody
    public Record getJSONById(@PathVariable("id") String id) {
        return recordDAO.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    @ResponseBody
    public Record save(@RequestBody Record record) {
        log.debug("Saving: " + record);

        recordDAO.save(record);

        return record;
    }
}
