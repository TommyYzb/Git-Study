package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    /*新增*/
    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);

    }

    /*修改*/
    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);

    }

    /*删除*/
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);

    }

    /*根据id获取*/
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "数据查询失败，请重试!";
        return new Result(code, book, msg);
    }

    /*获取所有*/
    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.list();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试!";
        return new Result(code, bookList, msg);
    }


    /* 多条件查询*/
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        Integer code = page != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page != null ? "" : "数据查询失败，请重试!";

        //解决在分页查询下删除功能的bug：如果当前页面页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize,book);
        }

        return new Result(code, page, msg);
    }

}
