package com.ford.blog.entity;

import com.ford.blog.entity.base.BaseEntity;
import com.ford.blog.util.SnowflakeIdWorker;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Category
 * @author: Ford.Zhang
 * @version: 1.0
 * 2019/12/18 下午 5:45
 **/
@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "category")
public class Category extends BaseEntity {

    @Override
    public void setEntityId(SnowflakeIdWorker snowflakeIdWorker) {
        if (StringUtils.isBlank(categoryId)) {
            categoryId = String.valueOf(snowflakeIdWorker.nextId());
        }
    }

    /**
     * 文章分类主键
     */
    @Id
    @Column(name = "id", nullable = false,length = 32, updatable = false, unique = true)
    private String categoryId;
    /**
     * 分类名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 启用日期
     */
    @Column(name = "active_date")
    private Date activeDate;
    /**
     * 文章分类关系
     */
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
