package com.xyhsoft.loganalyst.repository;

import com.xyhsoft.loganalyst.domain.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RecordRepository extends BaseRepository<Record> {
    private static Logger log = LoggerFactory.getLogger(RecordRepository.class);

    @Override
    protected Class<Record> getDomainClass() {
        return Record.class;
    }
}
