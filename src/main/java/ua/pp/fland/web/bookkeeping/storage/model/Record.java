package ua.pp.fland.web.bookkeeping.storage.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@ToString(includeFieldNames = true)
public class Record {

    public static final String COLLECTION_NAME = "records";

    @Id
    @Setter
    @Getter
    private String id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Date date;

    public Record() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (description != null ? !description.equals(record.description) : record.description != null) return false;
        if (id != null ? !id.equals(record.id) : record.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ToString(includeFieldNames = true)
    public static class Date {

        @Getter
        @Setter
        private int year;

        @Getter
        @Setter
        private int month;

        @Getter
        @Setter
        private int day;

        public Date() {
        }

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

}
