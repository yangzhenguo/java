package com.yangzg.dao.impl;

import com.yangzg.dao.inf.ProductDao;
import com.yangzg.model.Product;
import com.yangzg.util.MysqlPool;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sam on 2019/9/20.
 */
public class ProductDaoImpl implements ProductDao {

    private static final String TABLE_NAME = "product_bak";
    private QueryRunner queryRunner = new QueryRunner(MysqlPool.getDataSource());

    @Override
    public List<Product> selectAll() throws SQLException {
        return queryRunner.query(String.format("select * from %s order by pid", TABLE_NAME), new BeanListHandler<Product>(Product.class, new BasicRowProcessor(new BeanProcessor(new HashMap<String, String>(){
            private static final long serialVersionUID = -3217595755446845376L;

            {
                put("pid", "id");
                put("pname", "name");
                put("market_price", "marketPrice");
                put("shop_price", "shopPrice");
                put("pimage", "image");
                put("pdate", "date");
                put("is_hot", "isHot");
                put("pdesc", "desc");
            }
        }))));
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return this.queryRunner.update(String.format("delete from %s where pid = %d", TABLE_NAME, id)) > 0;
    }

    private static final ResultSetHandler<List<Product>> LIST_RESULT_SET_HANDLER = rs -> new ArrayList<Product>(){
        private static final long serialVersionUID = -3217595755446845376L;
        {
            while (rs.next()) {
                add(new Product(
                        rs.getInt("pid"),
                        rs.getString("pname"),
                        rs.getDouble("market_price"),
                        rs.getDouble("shop_price"),
                        rs.getString("pimage"),
                        rs.getDate("pdate"),
                        rs.getInt("is_hot") == 1,
                        rs.getString("pdesc")
                ));
            }
        }
    };
}
