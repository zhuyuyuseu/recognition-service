package com.acxiom.recognition;

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
//        register(QuestionsResource.class);
////
////		// register filters
//        register(RequestContextFilter.class);
//        register(LoggingResponseFilter.class);
//        register(CORSResponseFilter.class);
////
////		// register exception mappers
//        register(GenericExceptionMapper.class);
//        register(AppExceptionMapper.class);
//        register(NotFoundExceptionMapper.class);
////
////		// register features
//        register(JacksonFeature.class);
//        register(EntityFilteringFeature.class);
//        EncodingFilter.enableFor(this, GZipEncoder.class);
//
//        property(EntityFilteringFeature.ENTITY_FILTERING_SCOPE, new Annotation[] {QuestionDetailedView.Factory.get()});
    }


}
