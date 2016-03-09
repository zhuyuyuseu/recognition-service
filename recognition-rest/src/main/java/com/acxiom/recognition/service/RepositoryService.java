package com.acxiom.recognition.service;

/**
 * Created by yuyuzhu on 16/3/9.
 */
//import java.util.List;
//

import com.acxiom.recognition.exception.RecognitionAppException;
import com.acxiom.recognition.resource.Repository;

/**
 * @author ama
 * @see <a href="http://www.codingpedia.org/ama/spring-mybatis-integration-example/">http://www.codingpedia.org/ama/spring-mybatis-integration-example/</a>
 */
public interface RepositoryService {


    public Long createRepository(Repository repository) throws RecognitionAppException;
//  public void createPodcasts(List<Podcast> podcasts) throws AppException;
//    public List<Podcast> getPodcasts(String orderByInsertionDate, Integer numberDaysToLookBack) throws AppException;


    public Repository getRepositoryById(Long id) throws RecognitionAppException;

//    public List<Podcast> getLegacyPodcasts();
//    public Podcast getLegacyPodcastById(Long id);
//    public void updateFullyPodcast(Podcast podcast) throws AppException;
//    public void updatePartiallyPodcast(Podcast podcast) throws AppException;
//    public void deletePodcastById(Long id);
//    public void deletePodcasts();
//    public Podcast verifyPodcastExistenceById(Long id);
//    public void generateCustomReasonPhraseException() throws CustomReasonPhraseException;

}
