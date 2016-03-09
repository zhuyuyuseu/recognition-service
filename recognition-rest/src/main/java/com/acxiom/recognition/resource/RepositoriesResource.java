package com.acxiom.recognition.resource;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acxiom.recognition.exception.RecognitionAppException;
import com.acxiom.recognition.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class that handles REST requests
 *
 * @author amacoder
 */
@Component
@Path("/repositories")
public class RepositoriesResource {

    @Autowired
    private RepositoryService repositoryService;

    /**
     * Adds a new resource (podcast) from the given json format (at least title
     * and feed elements are required at the DB level)
     *
     * @param repository
     * @return
     * @throws RecognitionAppException
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    public Response createRepository(Repository repository) throws RecognitionAppException {
        Long createQuestionId = repositoryService.createRepository(repository);
        return Response.status(Response.Status.CREATED)// 201
                .entity("A new question has been created")
                .header("Location",
                        "http://localhost:8080/recognition-rest/questions/"
                                + String.valueOf(createQuestionId)).build();
    }

    //
//    /**
//     * Adds a new podcast (resource) from "form" (at least title and feed
//     * elements are required at the DB level)
//     *
//     * @param title
//     * @param linkOnPodcastpedia
//     * @param feed
//     * @param description
//     * @return
//     * @throws AppException
//     */
////    @POST
////    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
////    @Produces({MediaType.TEXT_HTML})
////    @Transactional
////    public Response createPodcastFromApplicationFormURLencoded(
////            @FormParam("title") String title,
////            @FormParam("linkOnPodcastpedia") String linkOnPodcastpedia,
////            @FormParam("feed") String feed,
////            @FormParam("description") String description) throws AppException {
////
////        Podcast podcast = new Podcast(title, linkOnPodcastpedia, feed,
////                description);
////        Long createPodcastid = podcastService.createPodcast(podcast);
////
////        return Response
////                .status(Response.Status.CREATED)// 201
////                .entity("A new podcast/resource has been created at /demo-rest-jersey-spring/podcasts/"
////                        + createPodcastid)
////                .header("Location",
////                        "http://localhost:8888/demo-rest-jersey-spring/podcasts/"
////                                + String.valueOf(createPodcastid)).build();
////    }
//
//    /**
//     * A list of resources (here podcasts) provided in json format will be added
//     * to the database.
//     *
//     * @param podcasts
//     * @return
//     * @throws AppException
//     */
////    @POST
////    @Path("list")
////    @Consumes({MediaType.APPLICATION_JSON})
////    public Response createPodcasts(List<Podcast> podcasts) throws AppException {
////        podcastService.createPodcasts(podcasts);
////        return Response.status(Response.Status.CREATED) // 201
////                .entity("List of podcasts was successfully created").build();
////    }
//
//	/*
//	 * *********************************** READ ***********************************
//	 */
//
//    /**
//     * Returns all resources (podcasts) from the database
//     *
//     * @return
//     * @throws IOException
//     * @throws JsonMappingException
//     * @throws JsonGenerationException
//     * @throws AppException
//     */
////    @GET
////    //@Compress //can be used only if you want to SELECTIVELY enable compression at the method level. By using the EncodingFilter everything is compressed now.
////    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
////    public List<Podcast> getPodcasts(
////            @QueryParam("orderByInsertionDate") String orderByInsertionDate,
////            @QueryParam("numberDaysToLookBack") Integer numberDaysToLookBack)
////            throws IOException, AppException {
////        List<Podcast> podcasts = podcastService.getPodcasts(
////                orderByInsertionDate, numberDaysToLookBack);
////        return podcasts;
////    }
//
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getRepositoryById(@PathParam("id") Long id, @QueryParam("detailed") boolean detailed)
            throws IOException, RecognitionAppException {
        Repository repository = repositoryService.getRepositoryById(id);
        return Response.status(200)
                .entity(repository, detailed ? new Annotation[]{RepositoryDetailedView.Factory.get()} : new Annotation[0])
                .header("Access-Control-Allow-Headers", "X-extra-header")
                .allow("OPTIONS").build();
    }

    //
////	@GET
////	@Path("{id}")
////	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
////	@PodcastDetailedView
////	public Podcast getPodcastById(@PathParam("id") Long id, @QueryParam("detailed") boolean detailed)
////			throws IOException,	AppException {
////		Podcast podcastById = podcastService.getPodcastById(id);
////
////		return podcastById;
//////		return Response.status(200)
//////				.entity(podcastById, detailed ? new Annotation[]{PodcastDetailedView.Factory.get()} : new Annotation[0])
//////				.header("Access-Control-Allow-Headers", "X-extra-header")
//////				.allow("OPTIONS").build();
////	}
//
//	/*
//	 * *********************************** UPDATE ***********************************
//	 */
//
//    /**
//     * The method offers both Creation and Update resource functionality. If
//     * there is no resource yet at the specified location, then a podcast
//     * creation is executed and if there is then the resource will be full
//     * updated.
//     *
//     * @param id
//     * @param podcast
//     * @return
//     * @throws AppException
//     */
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.TEXT_HTML})
//    public Response putPodcastById(@PathParam("id") Long id, Podcast podcast)
//            throws AppException {
//
//        Podcast podcastById = podcastService.verifyPodcastExistenceById(id);
//
//        if (podcastById == null) {
//            // resource not existent yet, and should be created under the
//            // specified URI
//            Long createPodcastId = podcastService.createPodcast(podcast);
//            return Response
//                    .status(Response.Status.CREATED)
//                    // 201
//                    .entity("A new podcast has been created AT THE LOCATION you specified")
//                    .header("Location",
//                            "http://localhost:8888/demo-rest-jersey-spring/podcasts/"
//                                    + String.valueOf(createPodcastId)).build();
//        } else {
//            // resource is existent and a full update should occur
//            podcastService.updateFullyPodcast(podcast);
//            return Response
//                    .status(Response.Status.OK)
//                    // 200
//                    .entity("The podcast you specified has been fully updated created AT THE LOCATION you specified")
//                    .header("Location",
//                            "http://localhost:8888/demo-rest-jersey-spring/podcasts/"
//                                    + String.valueOf(id)).build();
//        }
//    }
//
//    // PARTIAL update
//    @POST
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.TEXT_HTML})
//    public Response partialUpdatePodcast(@PathParam("id") Long id,
//                                         Podcast podcast) throws AppException {
//        podcast.setId(id);
//        podcastService.updatePartiallyPodcast(podcast);
//        return Response
//                .status(Response.Status.OK)
//                // 200
//                .entity("The podcast you specified has been successfully updated")
//                .build();
//    }
//
//    /*
//     * *********************************** DELETE ***********************************
//     */
//    @DELETE
//    @Path("{id}")
//    @Produces({MediaType.TEXT_HTML})
//    public Response deletePodcastById(@PathParam("id") Long id) {
//        podcastService.deletePodcastById(id);
//        return Response.status(Response.Status.NO_CONTENT)// 204
//                .entity("Podcast successfully removed from database").build();
//    }
//
//    @DELETE
//    @Produces({MediaType.TEXT_HTML})
//    public Response deletePodcasts() {
//        podcastService.deletePodcasts();
//        return Response.status(Response.Status.NO_CONTENT)// 204
//                .entity("All podcasts have been successfully removed").build();
//    }
//
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

}
