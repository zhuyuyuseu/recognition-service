package com.acxiom.recognition.dao;

import com.acxiom.recognition.entity.RepositoryEntity;

/**
 * Created by yuyuzhu on 16/3/9.
 */
public interface RepositoryDao {

//    public List<PodcastEntity> getPodcasts(String orderByInsertionDate);
//
//    public List<PodcastEntity> getRecentPodcasts(int numberOfDaysToLookBack);

    public RepositoryEntity getRepositoryById(Long id);

//    public PodcastEntity getPodcastByFeed(String feed);
//
//    public void deletePodcastById(Long id);

    public Long createRepository(RepositoryEntity repositoryEntity);

//    public void updatePodcast(PodcastEntity podcast);
//
//    /** removes all podcasts */
//    public void deletePodcasts();
//
//    /**
//     * Returns all podcasts from "legacy" system
//     * @return
//     */
//    public List<PodcastEntity> getLegacyPodcasts();
//
//    /**
//     * Returns a "legacy" podcast given its id
//     *
//     * @param id
//     * @return
//     */
//    public PodcastEntity getLegacyPodcastById(Long id);

}
