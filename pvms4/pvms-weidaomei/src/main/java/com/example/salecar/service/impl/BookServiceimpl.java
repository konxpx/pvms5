package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.BookMapper;
import com.example.salecar.pojo.Book;
import com.example.salecar.service.IbookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class BookServiceimpl implements IbookService {
    final BookMapper bookMapper;

    public BookServiceimpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public JSONObject addBook(Book book) {
        JSONObject resp = new JSONObject();
        bookMapper.insert(book.getCus_id(), book.getCar_id(), book.getS_id(), book.getBook_time(),book.getBook_addr());


        resp.put("code", 200);
        resp.put("msg", "addBook successful");
        return resp;
    }

    @Override
    public JSONObject deleteBook(Integer idList) {
        JSONObject resp = new JSONObject();
        try {
//            for (Integer id : idList) {
            bookMapper.deleteByPrimaryKey(idList);
//            }
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "delete cudtomer error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "delete Book successful");
        return resp;
    }

    @Override
    public JSONObject updateBook(Book book) {
        JSONObject resp = new JSONObject();
        try {
            bookMapper.updateByPrimaryKey(book.getBook_id(), book.getCus_id(),book.getCar_id(), book.getS_id()
                    , book.getBook_time(), book.getBook_addr());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "update book error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update book successful");
        return resp;
    }

    @Override
    public JSONObject showBook(String searchCusid,String searchStaffid,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(bookMapper.getBookList(searchCusid,searchStaffid));
            resp.put("code", 200);
            resp.put("msg", "show Books successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }

    @Override
    public JSONObject getBookById(int id) {
        try {
            Book book = bookMapper.selectByPrimaryKey(id);
            if (book == null) {
                JSONObject resp1 = new JSONObject();
                resp1.put("code", 500);
                resp1.put("msg", "the book not exist");
                return resp1;
            }
            JSONObject resp = (JSONObject) JSONObject.toJSON(book);
            resp.put("code", 200);
            resp.put("msg", "get successful");
            return resp;
        } catch (Exception e) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
    }

//    @Override
//    public JSONObject getBookByAccount(String account) {
//        JSONObject resp;
//        Book book;
//        try {
//            book = bookMapper.selectByAccount(account);
//        } catch (Exception e) {
//            resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("error", e.toString());
//            return resp;
//        }
//        if (book == null) {
//            resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "the book not exist");
//            return resp;
//        }
//        resp = (JSONObject) JSONObject.toJSON(book);
//        resp.put("code", 200);
//        return resp;
//    }

}
