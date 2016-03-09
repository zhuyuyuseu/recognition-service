package com.acxiom.recognition.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import com.acxiom.recognition.resource.Repository;

/**
 * Podcast entity
 *
 * @author ama
 */
@Entity
@Table(name = "repositories")
public class RepositoryEntity implements Serializable {

    private static final long serialVersionUID = -8039686696076337053L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * title of the podcast
     */
    @Column(name = "name")
    private String name;

    public RepositoryEntity() {
    }


    public RepositoryEntity(Repository repository) {
        try {
            BeanUtils.copyProperties(this, repository);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


