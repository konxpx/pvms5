package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Book;

public interface IbookService {
    JSONObject addBook(Book book);

    JSONObject deleteBook(Integer idList);

    JSONObject updateBook(Book book);

    JSONObject showBook(String searchName,String searchId,Integer pageNumber, Integer pageSize);

    JSONObject getBookById(int id);

    //JSONObject getBookByAccount(String account);
}
