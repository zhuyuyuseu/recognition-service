package com.acxiom.recognition.resource;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Podcast resource placeholder for json/xml representation
 *
 * @author ama
 */
@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository implements Serializable {

    private static final long serialVersionUID = -8039686696076337053L;

    /**
     * id of the podcast
     */
    @XmlElement(name = "id")
    private Long id;

    /**
     * title of the podcast
     */
    @XmlElement(name = "content")
    private String content;


    public Question(QuestionEntity questionEntity) {
        try {
            BeanUtils.copyProperties(this, questionEntity);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
