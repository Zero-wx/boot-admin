package com.zero.serverApi.service.system;

import com.zero.serverApi.bean.entity.system.Account;
import com.zero.serverApi.mapper.system.AccountMapper;
import com.zero.serverApi.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService extends BaseService<Account, Long> {


    @Autowired
    private AccountMapper accountMapper;


    @Override
    public int insert(Account record) {
        return accountMapper.insertAccount(record);
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    /**
     * 查询所有
     *
     * @return 返回所有结果
     */
    @Override
    public List<Account> selectAll() {
        return null;
    }

    /**
     * 根据单个 id 查询
     *
     * @param id
     * @return
     */
    @Override
    public List<Account> selectById(int id) {
        return null;
    }

    @Override
    public List<Account> selectAll(String record) {
        return null;
    }

    @Override
    public Account findByAccount(String record) {
        return accountMapper.findByAccount(record);
    }


    public int insertUserInfo(Account params) {
        return accountMapper.insertUserInfo(params);
    }

    public int deleteAccount(Integer id) {
        return accountMapper.deleteAccount(id);
    }
}
