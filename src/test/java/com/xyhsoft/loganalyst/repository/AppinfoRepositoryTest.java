package com.xyhsoft.loganalyst.repository;

import com.xyhsoft.loganalyst.BaseTestcase;
import com.xyhsoft.loganalyst.domain.Appinfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;

public class AppinfoRepositoryTest extends BaseTestcase {
    @Autowired
    private AppinfoRepository appinfoRepository;

    @Test
    public void save(){
        Appinfo info = new Appinfo();
        info.setName("LogAnalyst");
        info.setVersion("1.0-SNAPSHOT");
        info.setCreateDate(new Date());
        info.setContact("test");
        info.setPassword("123");
        appinfoRepository.save(info);
    }

    @Test
    public void findOne(){
        Criteria c = Criteria.where("contact").is("test");
        Query q = Query.query(c);
        Appinfo info = appinfoRepository.findOne(q);
        if(null != info){
            System.out.println(info.getCreateDate().getTime());
        }
        System.out.println(new Date(1362623178765l));
    }

    public AppinfoRepository getAppinfoRepository() {
        return appinfoRepository;
    }

    public void setAppinfoRepository(AppinfoRepository appinfoRepository) {
        this.appinfoRepository = appinfoRepository;
    }
}
