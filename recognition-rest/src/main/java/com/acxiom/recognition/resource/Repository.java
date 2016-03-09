package com.acxiom.recognition.resource;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.acxiom.recognition.entity.RepositoryEntity;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Repository resource placeholder for json/xml representation
 *
 * @author ama
 */
@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository implements Serializable {

    private static final long serialVersionUID = -8039686696076337053L;

    /**
     * id of the repository
     */
    @XmlElement(name = "id")
    private Long id;

    /**
     * repository name
     */
    @XmlElement(name = "name")
    private String name;


    public Repository(RepositoryEntity repositoryEntity) {
        try {
            BeanUtils.copyProperties(this, repositoryEntity);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Repository() {
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
