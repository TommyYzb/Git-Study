package com.itheima.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectList(null));
    }


    @Test
    void tessGetPage(){
        IPage page= new Page(3,5);
        bookDao.selectPage(page,null);
    }



}
