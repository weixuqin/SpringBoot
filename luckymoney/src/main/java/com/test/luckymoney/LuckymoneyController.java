package com.test.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckmoneyRepository repository;

    @Autowired
    private LuckmoneyService service;

    // 获取红包列表
    @GetMapping("/luckmoneys")
    public List<Luckmoney> list() {
        return repository.findAll();
    }

    // 创建红包
    @PostMapping("/luckmoney")
    public Luckmoney create(@RequestParam("producer") String producer,
                            @RequestParam("money")BigDecimal money) {
        Luckmoney luckmoney = new Luckmoney();
        luckmoney.setProducer(producer);
        luckmoney.setMoney(money);
        return repository.save(luckmoney);
    }

    // 通过 id 查询红包
    @GetMapping("/luckmoneys/{id}")
    public Luckmoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }


    // 更新红包（领红包）
    @PutMapping("/luckmoneys/{id}")
    public Luckmoney update(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer) {
        Optional<Luckmoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckmoney luckmoney = optional.get();
            luckmoney.setConsumer(consumer);
            return repository.save(luckmoney);
        }
        return null;
    }

    // 执行事务
    @PostMapping("/luckmoneys/two")
    public void createTwo() {
        service.createTwo();
    }

}
