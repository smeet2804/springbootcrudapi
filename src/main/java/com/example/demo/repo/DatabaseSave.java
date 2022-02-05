package com.example.demo.repo;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class DatabaseSave {

    @Autowired
    private EntityManager entityManager;

    public List<Map<String,Object>>   runNativeQuery(String name) {
        System.out.println(name);
        Query query=entityManager.createNativeQuery("select * from colleges c where lower(c.name) like :keyword");
        query.setParameter("keyword","%"+name+"%");
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String,Object>> result = nativeQuery.getResultList();
        return result;
    }
}
