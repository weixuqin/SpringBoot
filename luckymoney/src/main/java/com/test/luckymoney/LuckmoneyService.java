package com.test.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckmoneyService {

    @Autowired
    private LuckmoneyRepository repository;

    /**
     * 事务是指数据库的事务，不是指 java 事务，下方的注解只是添加了执行，回滚的操作，具体的事务执行还是要根据数据库情况
     * 比如有些数据库不支持事务，MySQL中 MyISAM 引擎是不支持事务的
     */
    @Transactional
    public void createTwo() {
        Luckmoney luckmoney1 = new Luckmoney();
        luckmoney1.setProducer("魏先生");
        luckmoney1.setMoney(new BigDecimal("520"));
        repository.save(luckmoney1);

        Luckmoney luckmoney2 = new Luckmoney();
        luckmoney2.setProducer("魏先生");
        luckmoney2.setMoney(new BigDecimal("1314"));
        repository.save(luckmoney2);
    }

}
