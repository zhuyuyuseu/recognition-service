package com.acxiom.recognition;

import com.acxiom.recognition.exception.GenericExceptionMapper;
import com.acxiom.recognition.exception.NotFoundExceptionMapper;
import com.acxiom.recognition.exception.RecognitionAppExceptionMapper;
import com.acxiom.recognition.filters.CORSResponseFilter;
import com.acxiom.recognition.filters.LoggingResponseFilter;
import com.acxiom.recognition.resource.RepositoriesResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import java.lang.annotation.Annotation;

/**
 * Created by yuyuzhu on 16/3/7.
 */
public class RecognitionApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public RecognitionApplication() {

        packages("com.acxiom.recognition");

////		// register application resources
        register(RepositoriesResource.class);
//
////		// register filters
        register(RequestContextFilter.class);
        register(LoggingResponseFilter.class);
        register(CORSResponseFilter.class);
////
////		// register exception mappers
        register(GenericExceptionMapper.class);
        register(RecognitionAppExceptionMapper.class);
        register(NotFoundExceptionMapper.class);
////
////		// register features
        register(JacksonFeature.class);
        register(EntityFilteringFeature.class);
        EncodingFilter.enableFor(this, GZipEncoder.class);
//
//        property(EntityFilteringFeature.ENTITY_FILTERING_SCOPE, new Annotation[] {QuestionDetailedView.Factory.get()});
    }


}
