package ua.pp.fland.web.bookkeeping.storage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: maxim
 * Date: 9/25/14
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */

@Document(collection = Record.COLLECTION_NAME)
public class Record {

    public static final String COLLECTION_NAME = "records";

    @Id
    private String id;

    private String decs;

    public Record() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }
}
