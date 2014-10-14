package ua.pp.fland.web.bookkeeping.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.pp.fland.web.bookkeeping.storage.dao.RecordDAO;
import ua.pp.fland.web.bookkeeping.storage.dao.RecordRepository;
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

    @Autowired
    RecordRepository recordRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public String getAll() {
        log.debug("Fetching all records...");

        List<Record> records = recordRepository.findAll();

        StringJoiner joiner = new StringJoiner("<br>");
        for (Record record : records) {
            joiner.add(record.toString());
        }

        return joiner.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    public String getById(@PathVariable("id") String id) {
        log.debug("Fetching record by id: " + id);

        Record record = recordRepository.findOne(id);

        return record.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/year")
    public List<Record> findByYear(@RequestParam int year) {
        log.debug("Getting records for year: " + year);

        return recordRepository.findByDateYear(year);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/date")
    public List<Record> findByYear(@RequestParam int year, @RequestParam int month, @RequestParam int day) {
        log.debug("Getting records for year: " + year + " month: " + month + " day: " + day);

        Record.Date date = new Record.Date(year, month, day);

        return recordRepository.findByDate(date);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/yearMonth")
    public List<Record> findByYearMonth(@RequestParam int year, @RequestParam int month) {
        log.debug("Getting records for year: " + year + " month: " + month);

        return recordRepository.findByDateYearAndDateMonth(year, month);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getJSON/{id}")
    @ResponseBody
    public Record getJSONById(@PathVariable("id") String id) {
        return recordRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    @ResponseBody
    public Record save(@RequestBody Record record) {
        log.debug("Saving: " + record);

        recordRepository.save(record);

        return record;
    }
}
