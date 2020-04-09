package com.yangzg.web01.service.impl;

import com.yangzg.web01.dao.PersonDao;
import com.yangzg.web01.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author Sam
 * @date 2020/3/28 8:05 PM
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    @Lazy
    private PersonDao personDao;
}
