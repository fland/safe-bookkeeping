package ua.pp.fland.web.bookkeeping.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ua.pp.fland.web.bookkeeping.storage.model.Record;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: maxim
 * Date: 9/25/14
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RecordDAO {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Record record) {
        mongoOperations.save(record);
    }

    public void deleteAll() {
        mongoOperations.dropCollection(Record.class);
    }

    public Record getById(String id) {
        return mongoOperations.findById(id, Record.class);
    }

    public List<Record> getAll() {
        return mongoOperations.findAll(Record.class);
    }

    public long countAll() {
        return mongoOperations.count(new Query(), Record.class);
    }

    /*public List<Record> getByYear(int year){
        Query query = new Query(Criteria.where("date.year").is(year));
        query.
        mongoOperations.find()
    }*/
}
