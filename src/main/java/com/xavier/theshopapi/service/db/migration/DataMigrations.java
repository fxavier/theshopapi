package com.xavier.theshopapi.service.db.migration;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.xavier.theshopapi.model.Produto;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@ChangeLog(order = "001")
public class DataMigrations {

    @ChangeSet(order = "001", author = "Xavier", id = "update entrega gratis")
    public void updateFreeShipping(MongoTemplate mongoTemplate) {
        Criteria freeShippingNullCriteria = new Criteria().orOperator(
                Criteria.where("freeShipping").is(null),
                Criteria.where("freeShipping").exists(false)
        );

        mongoTemplate.updateMulti(
                new Query(freeShippingNullCriteria),
                Update.update("freeshipping", true),
                Produto.class
        );

        System.out.println("Applied Changeset 001");
    }
}
