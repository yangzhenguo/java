package com.yangzg.dr.service.impl;

import com.yangzg.dr.service.RamadanActivityService;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/12/18.
 */
@Service
public class RamadanActivityServiceImpl implements RamadanActivityService {
    @Override
    public void execute(String key, String message) {
        System.out.println(String.format("%s: key=%s, message=%s", "Ramadan", key, message));
    }

    @Override
    public boolean using() {
        return true;
    }
}
