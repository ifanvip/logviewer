package com.xyhsoft.loganalyst.repository;

import com.xyhsoft.loganalyst.commons.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public abstract class BaseRepository<T> {

    @Autowired
    protected RepositoryTemplate repositoryTemplate;

    /**
      * 获取需要操作的实体类class
      *
      * @return
      */
     protected abstract Class<T> getDomainClass();

    /**
     * 通过条件查询,查询分页结果
     *
     * @param pageNo
     * @param pageSize
     * @param query
     * @return
     */
    public Pagination<T> getPage(int pageNo, int pageSize, Query query) {
        long totalCount = this.repositoryTemplate.getMongoTemplate().count(query, this.getDomainClass());
        Pagination<T> page = new Pagination<T>(pageNo, pageSize, totalCount);
        query.skip(page.getFirstResult());// skip相当于从那条记录开始
        query.limit(pageSize);// 从skip开始,取多少条记录
        List<T> datas = this.find(query);
        page.setDatas(datas);
        return page;
    }

    /**
     * 通过条件查询实体(集合)
     *
     * @param query
     */
    public List<T> find(Query query) {
        return repositoryTemplate.getMongoTemplate().find(query, this.getDomainClass());
    }

    /**
     * 通过一定的条件查询一个实体
     *
     * @param query
     * @return
     */
    public T findOne(Query query) {
        return repositoryTemplate.getMongoTemplate().findOne(query, this.getDomainClass());
    }

    /**
     * 查询出所有数据
     *
     * @return
     */
    public List<T> findAll() {
        return this.repositoryTemplate.getMongoTemplate().findAll(getDomainClass());
    }

    /**
     * 查询并且修改记录
     *
     * @param query
     * @param update
     * @return
     */
    public T findAndModify(Query query, Update update) {
        return this.repositoryTemplate.getMongoTemplate().findAndModify(query, update, this.getDomainClass());
    }

    /**
     * 按条件查询,并且删除记录
     *
     * @param query
     * @return
     */
    public T findAndRemove(Query query) {
        return this.repositoryTemplate.getMongoTemplate().findAndRemove(query, this.getDomainClass());
    }

    /**
     * 通过条件查询更新数据
     *
     * @param query
     * @param update
     * @return
     */
    public void updateFirst(Query query, Update update) {
        repositoryTemplate.getMongoTemplate().updateFirst(query, update, this.getDomainClass());
    }

    /**
     * 保存一个对象到mongodb
     *
     * @param domain
     * @return
     */
    public T save(T domain) {
        repositoryTemplate.getMongoTemplate().save(domain);
        return domain;
    }

    /**
     * 通过ID获取记录
     *
     * @param id
     * @return
     */
    public T findById(String id) {
        return repositoryTemplate.getMongoTemplate().findById(id, this.getDomainClass());
    }

    /**
     * 通过ID获取记录,并且指定了集合名
     *
     * @param id
     * @param collectionName 集合名
     * @return
     */
    public T findById(String id, String collectionName) {
        return repositoryTemplate.getMongoTemplate().findById(id, this.getDomainClass(), collectionName);
    }

    public RepositoryTemplate getRepositoryTemplate() {
        return repositoryTemplate;
    }

    public void setRepositoryTemplate(RepositoryTemplate repositoryTemplate) {
        this.repositoryTemplate = repositoryTemplate;
    }
}
