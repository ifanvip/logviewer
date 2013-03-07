package com.xyhsoft.loganalyst.repository;

import com.xyhsoft.loganalyst.BaseTestcase;
import com.xyhsoft.loganalyst.domain.Record;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class RecordRepositoryTest extends BaseTestcase {

    @Autowired
    private RecordRepository recordRepository;

    @Test
    public void findOne(){
        Criteria c = Criteria.where("level").is("WARN");
        Query q = Query.query(c);
        Record record = recordRepository.findOne(q);
        System.out.println(record);
    }

    public RecordRepository getRecordRepository() {
        return recordRepository;
    }

    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
}
