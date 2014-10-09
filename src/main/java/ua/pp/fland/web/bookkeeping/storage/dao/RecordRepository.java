package ua.pp.fland.web.bookkeeping.storage.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.pp.fland.web.bookkeeping.storage.model.Record;

/**
 * Created with IntelliJ IDEA.
 * User: maxim
 * Date: 10/9/14
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface RecordRepository extends MongoRepository<Record, String> {
}
