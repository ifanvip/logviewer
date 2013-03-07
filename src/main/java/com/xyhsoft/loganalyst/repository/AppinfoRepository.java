package com.xyhsoft.loganalyst.repository;

import com.xyhsoft.loganalyst.domain.Appinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AppinfoRepository extends BaseRepository<Appinfo> {

    private static Logger log = LoggerFactory.getLogger(AppinfoRepository.class);

    @Override
    protected Class<Appinfo> getDomainClass() {
        return Appinfo.class;
    }
}
